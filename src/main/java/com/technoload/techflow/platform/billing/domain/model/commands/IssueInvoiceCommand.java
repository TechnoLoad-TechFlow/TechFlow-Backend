package com.technoload.techflow.platform.billing.domain.model.commands;

public record IssueInvoiceCommand(Long invoiceId, Long ownerProfileId) {
}
