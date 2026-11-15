package com.technoload.techflow.platform.maintenance.application.commandservices;

import com.technoload.techflow.platform.maintenance.domain.model.aggregates.Maintenance;
import com.technoload.techflow.platform.maintenance.domain.model.commands.CancelMaintenanceCommand;
import com.technoload.techflow.platform.maintenance.domain.model.commands.CompleteMaintenanceCommand;
import com.technoload.techflow.platform.maintenance.domain.model.commands.ReportBreakdownCommand;
import com.technoload.techflow.platform.maintenance.domain.model.commands.ScheduleMaintenanceCommand;
import com.technoload.techflow.platform.maintenance.domain.model.commands.StartMaintenanceCommand;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;

/**
 * Command service for the Maintenance Management bounded context.
 */
public interface MaintenanceManagementCommandService {

    Result<Maintenance, ApplicationError> handle(ScheduleMaintenanceCommand command);

    Result<Maintenance, ApplicationError> handle(StartMaintenanceCommand command);

    Result<Maintenance, ApplicationError> handle(CancelMaintenanceCommand command);

    Result<Maintenance, ApplicationError> handle(CompleteMaintenanceCommand command);

    Result<Maintenance, ApplicationError> handle(ReportBreakdownCommand command);
}
