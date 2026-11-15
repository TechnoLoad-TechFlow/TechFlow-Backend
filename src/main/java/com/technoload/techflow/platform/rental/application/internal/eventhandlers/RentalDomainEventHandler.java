package com.technoload.techflow.platform.rental.application.internal.eventhandlers;

import com.technoload.techflow.platform.rental.domain.model.events.RentalCancelledEvent;
import com.technoload.techflow.platform.rental.domain.model.events.RentalCompletedEvent;
import com.technoload.techflow.platform.rental.domain.model.events.RentalConfirmedEvent;
import com.technoload.techflow.platform.rental.domain.model.events.RentalStartedEvent;
import com.technoload.techflow.platform.rental.domain.model.valueobjects.RentalStatus;
import com.technoload.techflow.platform.rental.domain.repositories.RentalRepository;
import com.technoload.techflow.platform.rental.interfaces.events.RentalClosedIntegrationEvent;
import com.technoload.techflow.platform.rental.interfaces.events.RentalConfirmedIntegrationEvent;
import com.technoload.techflow.platform.rental.interfaces.events.RentalStartedIntegrationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

/**
 * Turns Rental domain events (delivered by the outbox relay) into integration events that other
 * bounded contexts listen to, so they never depend on Rental's domain model.
 */
@Service
@Slf4j
public class RentalDomainEventHandler {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final RentalRepository rentalRepository;

    public RentalDomainEventHandler(ApplicationEventPublisher applicationEventPublisher, RentalRepository rentalRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.rentalRepository = rentalRepository;
    }

    @EventListener
    public void on(RentalConfirmedEvent event) {
        applicationEventPublisher.publishEvent(new RentalConfirmedIntegrationEvent(event.rentalId(), event.machineryId()));
    }

    @EventListener
    public void on(RentalStartedEvent event) {
        applicationEventPublisher.publishEvent(new RentalStartedIntegrationEvent(event.rentalId(), event.machineryId()));
    }

    @EventListener
    public void on(RentalCancelledEvent event) {
        publishClosed(event.rentalId(), event.machineryId());
    }

    @EventListener
    public void on(RentalCompletedEvent event) {
        publishClosed(event.rentalId(), event.machineryId());
        applicationEventPublisher.publishEvent(new com.technoload.techflow.platform.rental.interfaces.events.RentalCompletedIntegrationEvent(
                event.rentalId(), event.machineryId(), event.contractorProfileId()));
    }

    private void publishClosed(Long rentalId, Long machineryId) {
        var stillCommitted = rentalRepository.existsOtherInStatuses(machineryId,
                EnumSet.of(RentalStatus.CONFIRMED, RentalStatus.IN_PROGRESS), rentalId);
        applicationEventPublisher.publishEvent(new RentalClosedIntegrationEvent(rentalId, machineryId, stillCommitted));
    }
}
