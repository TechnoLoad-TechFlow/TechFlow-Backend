package com.technoload.techflow.platform.subscription.domain.model.events;

/**
 * Domain event published when a fleet owner requests a plan subscription.
 */
public record SubscriptionRequestedEvent(Long subscriptionId, Long ownerProfileId, Long planId) {
}
