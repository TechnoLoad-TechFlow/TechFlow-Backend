package com.technoload.techflow.platform.rental.application.queryservices;

import com.technoload.techflow.platform.rental.domain.model.aggregates.Rental;
import com.technoload.techflow.platform.rental.domain.model.queries.CheckMachineryAvailabilityQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.GetRentalByIdQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.GetRentalsDueToCompleteQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.GetRentalsDueToStartQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.ViewFleetRentalsQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.ViewMyReservationsQuery;
import com.technoload.techflow.platform.rental.domain.model.queries.ViewPendingRequestsQuery;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;

import java.util.List;
import java.util.Optional;

/**
 * Query service for the Rental Management bounded context.
 */
public interface RentalManagementQueryService {

    Optional<Rental> handle(GetRentalByIdQuery query);

    List<Rental> handle(ViewMyReservationsQuery query);

    List<Rental> handle(ViewPendingRequestsQuery query);

    List<Rental> handle(ViewFleetRentalsQuery query);

    Result<Boolean, ApplicationError> handle(CheckMachineryAvailabilityQuery query);

    List<Rental> handle(GetRentalsDueToStartQuery query);

    List<Rental> handle(GetRentalsDueToCompleteQuery query);
}
