package com.technoload.techflow.platform.profiles.interfaces.rest.transform;

import com.technoload.techflow.platform.profiles.domain.model.entities.Organization;
import com.technoload.techflow.platform.profiles.interfaces.rest.resources.OrganizationResource;

public final class OrganizationResourceFromEntityAssembler {

    private OrganizationResourceFromEntityAssembler() {
    }

    public static OrganizationResource toResourceFromEntity(Organization organization) {
        if (organization == null) {
            return null;
        }
        return new OrganizationResource(organization.getId(), organization.getLegalName(), organization.getTradeName(),
                organization.getTaxId().value(), organization.getType().name(), organization.getAddress());
    }
}
