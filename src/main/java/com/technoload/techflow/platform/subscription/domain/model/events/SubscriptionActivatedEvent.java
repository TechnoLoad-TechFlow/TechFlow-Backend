package com.technoload.techflow.platform.subscription.domain.model.events;

/**
 * Domain event published when a subscription is activated.
 */
public record SubscriptionActivatedEvent(Long subscriptionId, Long ownerProfileId, Long planId) {
}
