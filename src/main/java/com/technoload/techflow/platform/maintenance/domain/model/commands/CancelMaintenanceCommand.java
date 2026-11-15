package com.technoload.techflow.platform.maintenance.domain.model.commands;

public record CancelMaintenanceCommand(Long maintenanceId, Long ownerProfileId) {
}
