package com.technoload.techflow.platform.fleet.domain.model.commands;

/**
 * Internal command: a confirmed rental reserves the machine.
 */
public record ReserveMachineryCommand(Long machineryId) {
}
