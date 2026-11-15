package com.technoload.techflow.platform.rental.domain.model.events;

public record RentalStartedEvent(Long rentalId, Long machineryId, Long contractorProfileId) {
}
