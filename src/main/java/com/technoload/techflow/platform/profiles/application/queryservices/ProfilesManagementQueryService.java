package com.technoload.techflow.platform.profiles.application.queryservices;

import com.technoload.techflow.platform.profiles.domain.model.aggregates.Profile;
import com.technoload.techflow.platform.profiles.domain.model.entities.Organization;
import com.technoload.techflow.platform.profiles.domain.model.queries.GetProfileByUserAccountIdQuery;
import com.technoload.techflow.platform.profiles.domain.model.queries.ViewOrganizationQuery;
import com.technoload.techflow.platform.profiles.domain.model.queries.ViewProfileQuery;

import java.util.Optional;

/**
 * Query service for the Profiles bounded context.
 */
public interface ProfilesManagementQueryService {

    Optional<Profile> handle(ViewProfileQuery query);

    Optional<Profile> handle(GetProfileByUserAccountIdQuery query);

    Optional<Organization> handle(ViewOrganizationQuery query);
}
