package com.technoload.techflow.platform.fleet.domain.model.commands;

/**
 * Internal command: a maintenance started on the machine.
 */
public record StartMachineryMaintenanceCommand(Long machineryId) {
}
