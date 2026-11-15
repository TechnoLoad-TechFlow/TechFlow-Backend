package com.technoload.techflow.platform.billing.application.internal.eventhandlers;

import com.technoload.techflow.platform.billing.application.commandservices.BillingManagementCommandService;
import com.technoload.techflow.platform.billing.application.internal.outboundservices.acl.ExternalFleetService;
import com.technoload.techflow.platform.billing.application.internal.outboundservices.acl.ExternalRentalService;
import com.technoload.techflow.platform.billing.domain.model.aggregates.Invoice;
import com.technoload.techflow.platform.billing.domain.model.commands.ApplyLatePenaltyCommand;
import com.technoload.techflow.platform.billing.domain.model.commands.CalculateRentalAmountCommand;
import com.technoload.techflow.platform.operations.interfaces.events.OperationCompletedIntegrationEvent;
import com.technoload.techflow.platform.rental.interfaces.events.RentalCompletedIntegrationEvent;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;
import com.technoload.techflow.platform.shared.domain.model.valueobjects.Money;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Handles integration events from other contexts (Operations, Rental)
 * to enact billing policies (calculating invoice amounts, assessing late penalties).
 */
@Service
@Slf4j
public class BillingIntegrationEventHandler {

    private final BillingManagementCommandService billingManagementCommandService;
    private final ExternalRentalService externalRentalService;
    private final ExternalFleetService externalFleetService;

    public BillingIntegrationEventHandler(BillingManagementCommandService billingManagementCommandService,
                                         @Qualifier("billingExternalRentalService") ExternalRentalService externalRentalService,
                                         @Qualifier("billingExternalFleetService") ExternalFleetService externalFleetService) {
        this.billingManagementCommandService = billingManagementCommandService;
        this.externalRentalService = externalRentalService;
        this.externalFleetService = externalFleetService;
    }

    /**
     * Policy: when operation completes, compute and record the rental invoice.
     */
    @EventListener
    public void on(OperationCompletedIntegrationEvent event) {
        log.info("Operation completed for rental {}. Triggering invoice calculation.", event.rentalId());

        BigDecimal totalAmount = externalRentalService.fetchRentalTotalAmount(event.rentalId());
        String currency = externalRentalService.fetchRentalCurrency(event.rentalId());
        if (currency == null || currency.isBlank()) {
            currency = "PEN";
        }

        if (totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            BigDecimal hourlyRate = externalFleetService.fetchHourlyRateAmount(event.machineryId());
            if (hourlyRate != null && hourlyRate.compareTo(BigDecimal.ZERO) > 0 && event.totalHours() != null) {
                totalAmount = hourlyRate.multiply(event.totalHours());
            } else {
                totalAmount = BigDecimal.ZERO;
            }
        }

        Money amount = new Money(totalAmount, currency);
        var result = billingManagementCommandService.handle(new CalculateRentalAmountCommand(event.rentalId(), amount));
        if (result instanceof Result.Failure<Invoice, ApplicationError> failure) {
            log.warn("Failed to calculate rental invoice: {}", failure.error().message());
        }
    }

    /**
     * Policy: when rental completes, verify if the return date exceeded the agreed end date.
     * If late, automatically apply a late penalty.
     */
    @EventListener
    public void on(RentalCompletedIntegrationEvent event) {
        log.info("Rental {} completed. Checking for late return.", event.rentalId());
        LocalDate agreedEndDate = externalRentalService.fetchRentalEndDate(event.rentalId());
        if (agreedEndDate == null) {
            return;
        }

        LocalDate actualDate = LocalDate.now();
        if (actualDate.isAfter(agreedEndDate)) {
            long daysLate = ChronoUnit.DAYS.between(agreedEndDate, actualDate);
            BigDecimal penaltyRatePerDay = BigDecimal.valueOf(100);
            BigDecimal totalPenalty = penaltyRatePerDay.multiply(BigDecimal.valueOf(daysLate));

            String currency = externalRentalService.fetchRentalCurrency(event.rentalId());
            if (currency == null || currency.isBlank()) {
                currency = "PEN";
            }

            log.info("Rental {} returned {} days late. Applying late penalty of {} {}",
                    event.rentalId(), daysLate, totalPenalty, currency);

            billingManagementCommandService.handle(new ApplyLatePenaltyCommand(
                    event.rentalId(),
                    new Money(totalPenalty, currency),
                    "Late machinery return: " + daysLate + " day(s) overdue"
            ));
        }
    }
}
