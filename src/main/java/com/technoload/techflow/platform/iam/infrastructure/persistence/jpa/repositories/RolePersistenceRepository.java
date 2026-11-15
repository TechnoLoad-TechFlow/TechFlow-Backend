package com.technoload.techflow.platform.iam.infrastructure.persistence.jpa.repositories;

import com.technoload.techflow.platform.iam.domain.model.valueobjects.RoleName;
import com.technoload.techflow.platform.iam.infrastructure.persistence.jpa.entities.RolePersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolePersistenceRepository extends JpaRepository<RolePersistenceEntity, Long> {

    Optional<RolePersistenceEntity> findByName(RoleName name);

    boolean existsByName(RoleName name);
}
