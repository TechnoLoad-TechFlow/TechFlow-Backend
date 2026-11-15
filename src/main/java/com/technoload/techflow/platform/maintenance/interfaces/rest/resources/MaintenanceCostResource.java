package com.technoload.techflow.platform.maintenance.interfaces.rest.resources;

import java.math.BigDecimal;

public record MaintenanceCostResource(BigDecimal amount, String currency) {
}
