package com.technoload.techflow.platform.fleet.domain.model.commands;

import com.technoload.techflow.platform.fleet.domain.model.valueobjects.MachineryStatus;

public record ChangeMachineryStatusCommand(Long machineryId, Long ownerProfileId, MachineryStatus status) {
}
