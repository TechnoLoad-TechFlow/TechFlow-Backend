package com.technoload.techflow.platform.maintenance.domain.model.valueobjects;

/**
 * Lifecycle of a maintenance.
 */
public enum MaintenanceStatus {
    SCHEDULED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    public boolean isPending() {
        return this == SCHEDULED || this == IN_PROGRESS;
    }
}
