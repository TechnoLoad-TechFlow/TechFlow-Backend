package com.technoload.techflow.platform.rental.interfaces.rest.resources;

import java.math.BigDecimal;

public record RentalAmountResource(BigDecimal amount, String currency) {
}
