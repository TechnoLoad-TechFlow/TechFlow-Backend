package com.technoload.techflow.platform.operations.domain.model.commands;

public record RejectWorkedHoursCommand(Long operationId, Long workedHoursId, Long validatorProfileId) {
}
