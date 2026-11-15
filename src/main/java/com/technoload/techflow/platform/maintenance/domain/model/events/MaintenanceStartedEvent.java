package com.technoload.techflow.platform.maintenance.domain.model.events;

public record MaintenanceStartedEvent(Long maintenanceId, Long machineryId) {
}
