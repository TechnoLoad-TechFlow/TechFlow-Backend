package com.technoload.techflow.platform.maintenance.interfaces.events;

/**
 * Published for other bounded contexts when a maintenance starts.
 */
public record MaintenanceStartedIntegrationEvent(Long maintenanceId, Long machineryId) {
}
