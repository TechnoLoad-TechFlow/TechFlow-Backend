package com.technoload.techflow.platform.maintenance.domain.model.commands;

public record StartMaintenanceCommand(Long maintenanceId, Long ownerProfileId) {
}
