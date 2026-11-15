package com.technoload.techflow.platform.subscription.domain.model.events;

/**
 * Domain event published when a subscription is cancelled.
 */
public record SubscriptionCancelledEvent(Long subscriptionId, Long ownerProfileId, String reason) {
}
