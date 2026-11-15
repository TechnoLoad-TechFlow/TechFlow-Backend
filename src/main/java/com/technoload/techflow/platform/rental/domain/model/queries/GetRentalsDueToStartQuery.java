package com.technoload.techflow.platform.rental.domain.model.queries;

import java.time.LocalDate;

public record GetRentalsDueToStartQuery(LocalDate today) {
}
