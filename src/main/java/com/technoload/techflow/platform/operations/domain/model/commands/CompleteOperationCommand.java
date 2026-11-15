package com.technoload.techflow.platform.operations.domain.model.commands;

public record CompleteOperationCommand(Long operationId, Long validatorProfileId) {
}
