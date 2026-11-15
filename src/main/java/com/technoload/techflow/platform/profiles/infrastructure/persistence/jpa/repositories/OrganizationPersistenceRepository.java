package com.technoload.techflow.platform.profiles.infrastructure.persistence.jpa.repositories;

import com.technoload.techflow.platform.profiles.infrastructure.persistence.jpa.entities.OrganizationPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationPersistenceRepository extends JpaRepository<OrganizationPersistenceEntity, Long> {

    boolean existsByTaxId(String taxId);

    boolean existsByTaxIdAndIdNot(String taxId, Long id);
}
