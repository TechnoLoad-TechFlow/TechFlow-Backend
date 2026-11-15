package com.technoload.techflow.platform.billing.domain.model.commands;

import com.technoload.techflow.platform.shared.domain.model.valueobjects.Money;

public record CalculateRentalAmountCommand(Long rentalId, Money amount) {
}
