package com.technoload.techflow.platform.maintenance.domain.model.events;

public record MaintenanceCompletedEvent(Long maintenanceId, Long machineryId) {
}
