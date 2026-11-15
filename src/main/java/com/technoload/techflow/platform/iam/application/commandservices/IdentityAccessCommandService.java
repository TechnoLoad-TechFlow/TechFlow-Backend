package com.technoload.techflow.platform.iam.application.commandservices;

import com.technoload.techflow.platform.iam.domain.model.aggregates.UserAccount;
import com.technoload.techflow.platform.iam.domain.model.commands.SeedRolesCommand;
import com.technoload.techflow.platform.iam.domain.model.commands.SignInCommand;
import com.technoload.techflow.platform.iam.domain.model.commands.SignUpCommand;
import com.technoload.techflow.platform.shared.application.result.ApplicationError;
import com.technoload.techflow.platform.shared.application.result.Result;

/**
 * Command service for the Identity and Access Management bounded context.
 */
public interface IdentityAccessCommandService {

    Result<UserAccount, ApplicationError> handle(SignUpCommand command);

    Result<AuthenticatedUserAccount, ApplicationError> handle(SignInCommand command);

    void handle(SeedRolesCommand command);
}
