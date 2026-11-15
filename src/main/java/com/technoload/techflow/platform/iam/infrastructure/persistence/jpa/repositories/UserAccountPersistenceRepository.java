package com.technoload.techflow.platform.iam.infrastructure.persistence.jpa.repositories;

import com.technoload.techflow.platform.iam.infrastructure.persistence.jpa.entities.UserAccountPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountPersistenceRepository extends JpaRepository<UserAccountPersistenceEntity, Long> {

    Optional<UserAccountPersistenceEntity> findByEmail(String email);

    boolean existsByEmail(String email);
}
