package com.technoload.techflow.platform.iam.domain.repositories;

import com.technoload.techflow.platform.iam.domain.model.aggregates.UserAccount;
import com.technoload.techflow.platform.iam.domain.model.valueobjects.EmailAddress;

import java.util.Optional;

/**
 * Domain port for user account persistence.
 */
public interface UserAccountRepository {

    UserAccount save(UserAccount account);

    Optional<UserAccount> findById(Long id);

    Optional<UserAccount> findByEmail(EmailAddress email);

    boolean existsByEmail(EmailAddress email);
}
