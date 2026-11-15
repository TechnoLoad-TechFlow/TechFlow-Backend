package com.technoload.techflow.platform.profiles.interfaces.rest.transform;

import com.technoload.techflow.platform.profiles.domain.model.commands.UpdateProfileCommand;
import com.technoload.techflow.platform.profiles.domain.model.valueobjects.DocumentType;
import com.technoload.techflow.platform.profiles.interfaces.rest.resources.ContactInformationResource;
import com.technoload.techflow.platform.profiles.interfaces.rest.resources.UpdateProfileResource;

public final class UpdateProfileCommandFromResourceAssembler {

    private UpdateProfileCommandFromResourceAssembler() {
    }

    public static UpdateProfileCommand toCommandFromResource(Long profileId, Long userAccountId, UpdateProfileResource resource) {
        var contact = resource.contactInformation() == null
                ? new ContactInformationResource(null, null, null, null, null)
                : resource.contactInformation();
        return new UpdateProfileCommand(profileId, userAccountId, resource.firstName(), resource.lastName(),
                EnumFromStringAssembler.toEnum(DocumentType.class, resource.documentType(), "documentType"),
                resource.documentNumber(), contact.phoneNumber(), contact.secondaryEmail(), contact.address(),
                contact.district(), contact.city());
    }
}
