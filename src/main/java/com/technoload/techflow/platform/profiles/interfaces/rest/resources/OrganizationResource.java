package com.technoload.techflow.platform.profiles.interfaces.rest.resources;

public record OrganizationResource(Long id, String legalName, String tradeName, String taxId, String type, String address) {
}
