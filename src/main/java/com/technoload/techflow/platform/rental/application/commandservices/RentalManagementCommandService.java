package com.technoload.techflow.platform.rental.application.commandservices;

import com.technoload.techflow.platform.rental.domain.model.aggregates.Rental;
import com.technoload.techflow.platform.rental.domain.model.commands.CancelReservationCommand;
import com.technoload.techflow.platform.rental.domain.model.commands.CompleteRentalCommand;
import com.technoload.techflow.platform.rental.domain.model.commands.ConfirmReservationCommand;
import com.technoload.techflow.platform.rental.domain.model.commands.RejectReservationCommand;
import com.technoload.techflow.platform.rental.domain.model.commands.RequestRentalCommand;
import com.technoload.techflow.platform.rental.domain.model.commands.StartRentalCommand;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;

/**
 * Command service for the Rental Management bounded context.
 */
public interface RentalManagementCommandService {

    Result<Rental, ApplicationError> handle(RequestRentalCommand command);

    Result<Rental, ApplicationError> handle(ConfirmReservationCommand command);

    Result<Rental, ApplicationError> handle(RejectReservationCommand command);

    Result<Rental, ApplicationError> handle(CancelReservationCommand command);

    Result<Rental, ApplicationError> handle(StartRentalCommand command);

    Result<Rental, ApplicationError> handle(CompleteRentalCommand command);
}
