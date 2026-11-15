package com.technoload.techflow.platform.subscription.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResource(
        Long id,
        String provider,
        String providerPaymentId,
        BigDecimal amount,
        String currency,
        String status,
        LocalDateTime paidAt
) {
}
