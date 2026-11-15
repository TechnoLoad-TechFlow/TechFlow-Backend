package com.technoload.techflow.platform.rental.domain.model.events;

public record RentalCancelledEvent(Long rentalId, Long machineryId, Long contractorProfileId, String reason) {
}
