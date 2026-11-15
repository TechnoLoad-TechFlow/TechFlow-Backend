package com.technoload.techflow.platform.billing.domain.model.commands;

import com.technoload.techflow.platform.shared.domain.model.valueobjects.Money;

public record ApplyLatePenaltyCommand(Long rentalId, Money amount, String reason) {
}
