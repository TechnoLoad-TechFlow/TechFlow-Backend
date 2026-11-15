package com.technoload.techflow.platform.profiles.interfaces.rest.transform;

import com.technoload.techflow.platform.profiles.domain.model.commands.UpdateOrganizationCommand;
import com.technoload.techflow.platform.profiles.domain.model.valueobjects.OrganizationType;
import com.technoload.techflow.platform.profiles.interfaces.rest.resources.UpdateOrganizationResource;

public final class UpdateOrganizationCommandFromResourceAssembler {

    private UpdateOrganizationCommandFromResourceAssembler() {
    }

    public static UpdateOrganizationCommand toCommandFromResource(Long organizationId, Long userAccountId,
                                                                  UpdateOrganizationResource resource) {
        return new UpdateOrganizationCommand(organizationId, userAccountId, resource.legalName(), resource.tradeName(),
                resource.taxId(), EnumFromStringAssembler.toEnum(OrganizationType.class, resource.type(), "type"),
                resource.address());
    }
}
