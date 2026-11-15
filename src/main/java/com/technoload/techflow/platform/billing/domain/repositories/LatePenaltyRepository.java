package com.technoload.techflow.platform.billing.domain.repositories;

import com.technoload.techflow.platform.billing.domain.model.aggregates.LatePenalty;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Domain repository port for {@link LatePenalty}.
 */
public interface LatePenaltyRepository {

    LatePenalty save(LatePenalty penalty);

    Optional<LatePenalty> findById(Long id);

    List<LatePenalty> findByRentalId(Long rentalId);

    List<LatePenalty> findByRentalIdIn(Collection<Long> rentalIds);

    List<LatePenalty> findAll();
}
