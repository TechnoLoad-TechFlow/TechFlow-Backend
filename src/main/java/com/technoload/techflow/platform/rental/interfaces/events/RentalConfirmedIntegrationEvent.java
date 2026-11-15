package com.technoload.techflow.platform.rental.interfaces.events;

/**
 * Published for other bounded contexts when an owner confirms a rental.
 */
public record RentalConfirmedIntegrationEvent(Long rentalId, Long machineryId) {
}
