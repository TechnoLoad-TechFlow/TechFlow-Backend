package com.technoload.techflow.platform.subscription.domain.model.commands;

public record CancelSubscriptionCommand(Long subscriptionId, Long ownerProfileId, String reason) {
}
