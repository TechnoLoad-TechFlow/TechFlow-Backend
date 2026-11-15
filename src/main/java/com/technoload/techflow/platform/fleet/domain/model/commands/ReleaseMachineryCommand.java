package com.technoload.techflow.platform.fleet.domain.model.commands;

/**
 * Internal command: no rental keeps the machine committed any more.
 */
public record ReleaseMachineryCommand(Long machineryId) {
}
