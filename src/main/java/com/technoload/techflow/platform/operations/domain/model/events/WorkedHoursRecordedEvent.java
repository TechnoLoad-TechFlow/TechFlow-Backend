package com.technoload.techflow.platform.operations.domain.model.events;

import java.math.BigDecimal;

/**
 * Domain event published when worked hours are recorded.
 */
public record WorkedHoursRecordedEvent(Long operationId, Long workedHoursId, BigDecimal hours) {
}
