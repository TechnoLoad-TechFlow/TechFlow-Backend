package com.technoload.techflow.platform.profiles.domain.repositories;

import com.technoload.techflow.platform.profiles.domain.model.aggregates.Profile;

import java.util.Optional;

/**
 * Domain port for profile persistence. Organizations are saved through their profile.
 */
public interface ProfileRepository {

    Profile save(Profile profile);

    Optional<Profile> findById(Long id);

    Optional<Profile> findByUserAccountId(Long userAccountId);

    Optional<Profile> findByOrganizationId(Long organizationId);

    boolean existsByUserAccountId(Long userAccountId);

    boolean existsByDocumentNumber(String documentNumber, Long excludedProfileId);

    boolean existsOrganizationByTaxId(String taxId, Long excludedOrganizationId);
}
