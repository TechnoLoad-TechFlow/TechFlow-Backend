package com.technoload.techflow.platform.operations.domain.model.events;

import java.math.BigDecimal;

/**
 * Domain event published when a service operation completes.
 */
public record OperationCompletedEvent(Long operationId, Long rentalId, Long machineryId, BigDecimal totalHours) {
}
