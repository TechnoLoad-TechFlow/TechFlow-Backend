package com.technoload.techflow.platform.subscription.domain.model.commands;

import com.technoload.techflow.platform.subscription.domain.model.valueobjects.PlanCode;

public record SubscribeToPlanCommand(Long ownerProfileId, PlanCode planCode) {
}
