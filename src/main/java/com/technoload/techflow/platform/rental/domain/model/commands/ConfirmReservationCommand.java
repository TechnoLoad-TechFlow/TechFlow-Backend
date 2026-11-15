package com.technoload.techflow.platform.rental.domain.model.commands;

public record ConfirmReservationCommand(Long rentalId, Long ownerProfileId) {
}
