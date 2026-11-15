package com.technoload.techflow.platform.rental.domain.model.events;

public record RentalCompletedEvent(Long rentalId, Long machineryId, Long contractorProfileId) {
}
