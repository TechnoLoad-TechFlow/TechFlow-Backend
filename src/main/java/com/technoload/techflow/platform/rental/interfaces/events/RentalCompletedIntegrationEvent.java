package com.technoload.techflow.platform.rental.interfaces.events;

/**
 * Integration event emitted when a rental is completed.
 */
public record RentalCompletedIntegrationEvent(Long rentalId, Long machineryId, Long contractorProfileId) {
}
