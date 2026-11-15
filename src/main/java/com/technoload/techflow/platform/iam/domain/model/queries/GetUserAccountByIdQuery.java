package com.technoload.techflow.platform.iam.domain.model.queries;

/**
 * Query for a user account by id.
 *
 * @param userAccountId the account id
 */
public record GetUserAccountByIdQuery(Long userAccountId) {
}
