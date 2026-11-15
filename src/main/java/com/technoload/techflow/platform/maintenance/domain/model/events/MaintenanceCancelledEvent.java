package com.technoload.techflow.platform.maintenance.domain.model.events;

public record MaintenanceCancelledEvent(Long maintenanceId, Long machineryId) {
}
