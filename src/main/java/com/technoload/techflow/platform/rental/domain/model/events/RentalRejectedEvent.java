package com.technoload.techflow.platform.rental.domain.model.events;

public record RentalRejectedEvent(Long rentalId, Long machineryId, Long contractorProfileId, String reason) {
}
