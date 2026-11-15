package com.technoload.techflow.platform.operations.domain.model.commands;

public record StartOperationCommand(Long rentalId, Long machineryId, Long operatorProfileId, Long requesterProfileId, boolean requesterIsOperator) {
}
