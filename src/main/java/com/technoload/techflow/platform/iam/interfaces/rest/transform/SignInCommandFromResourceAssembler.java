package com.technoload.techflow.platform.iam.interfaces.rest.transform;

import com.technoload.techflow.platform.iam.domain.model.commands.SignInCommand;
import com.technoload.techflow.platform.iam.interfaces.rest.resources.SignInResource;

public final class SignInCommandFromResourceAssembler {

    private SignInCommandFromResourceAssembler() {
    }

    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.email(), resource.password());
    }
}
