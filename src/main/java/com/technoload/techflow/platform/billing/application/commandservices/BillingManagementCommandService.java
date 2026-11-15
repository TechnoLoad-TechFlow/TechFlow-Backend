package com.technoload.techflow.platform.billing.application.commandservices;

import com.technoload.techflow.platform.billing.domain.model.aggregates.Invoice;
import com.technoload.techflow.platform.billing.domain.model.aggregates.LatePenalty;
import com.technoload.techflow.platform.billing.domain.model.commands.ApplyLatePenaltyCommand;
import com.technoload.techflow.platform.billing.domain.model.commands.CalculateRentalAmountCommand;
import com.technoload.techflow.platform.billing.domain.model.commands.IssueInvoiceCommand;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;

/**
 * Command service port for Billing Management.
 */
public interface BillingManagementCommandService {

    Result<Invoice, ApplicationError> handle(CalculateRentalAmountCommand command);

    Result<Invoice, ApplicationError> handle(IssueInvoiceCommand command);

    Result<LatePenalty, ApplicationError> handle(ApplyLatePenaltyCommand command);
}
