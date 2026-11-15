package com.technoload.techflow.platform.rental.interfaces.rest.resources;

import java.time.LocalDate;

public record RentalPeriodResource(LocalDate startDate, LocalDate endDate) {
}
