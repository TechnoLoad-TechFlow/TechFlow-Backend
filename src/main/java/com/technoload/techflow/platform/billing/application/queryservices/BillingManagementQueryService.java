package com.technoload.techflow.platform.billing.application.queryservices;

import com.technoload.techflow.platform.billing.domain.model.aggregates.Invoice;
import com.technoload.techflow.platform.billing.domain.model.aggregates.LatePenalty;
import com.technoload.techflow.platform.billing.domain.model.queries.GetLatePenaltyByIdQuery;
import com.technoload.techflow.platform.billing.domain.model.queries.ViewInvoiceByRentalIdQuery;
import com.technoload.techflow.platform.billing.domain.model.queries.ViewInvoiceHistoryQuery;
import com.technoload.techflow.platform.billing.domain.model.queries.ViewInvoiceQuery;
import com.technoload.techflow.platform.billing.domain.model.queries.ViewInvoicesByOwnerProfileIdQuery;
import com.technoload.techflow.platform.billing.domain.model.queries.ViewLatePenaltiesQuery;

import java.util.List;
import java.util.Optional;

/**
 * Query service port for Billing Management.
 */
public interface BillingManagementQueryService {

    Optional<Invoice> handle(ViewInvoiceQuery query);

    Optional<Invoice> handle(ViewInvoiceByRentalIdQuery query);

    List<Invoice> handle(ViewInvoiceHistoryQuery query);

    List<Invoice> handle(ViewInvoicesByOwnerProfileIdQuery query);

    List<LatePenalty> handle(ViewLatePenaltiesQuery query);

    Optional<LatePenalty> handle(GetLatePenaltyByIdQuery query);
}
