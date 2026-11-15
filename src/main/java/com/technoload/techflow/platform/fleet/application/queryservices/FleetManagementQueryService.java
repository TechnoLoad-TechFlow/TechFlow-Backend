package com.technoload.techflow.platform.fleet.application.queryservices;

import com.technoload.techflow.platform.fleet.domain.model.aggregates.Category;
import com.technoload.techflow.platform.fleet.domain.model.aggregates.Machinery;
import com.technoload.techflow.platform.fleet.domain.model.queries.GetCategoryByIdQuery;
import com.technoload.techflow.platform.fleet.domain.model.queries.GetMachineryByIdQuery;
import com.technoload.techflow.platform.fleet.domain.model.queries.GetMachineryByOwnerProfileIdQuery;
import com.technoload.techflow.platform.fleet.domain.model.queries.ViewCategoriesQuery;
import com.technoload.techflow.platform.fleet.domain.model.queries.ViewMachineryCatalogQuery;

import java.util.List;
import java.util.Optional;

/**
 * Query service for the Fleet Management bounded context.
 */
public interface FleetManagementQueryService {

    List<Machinery> handle(ViewMachineryCatalogQuery query);

    Optional<Machinery> handle(GetMachineryByIdQuery query);

    List<Machinery> handle(GetMachineryByOwnerProfileIdQuery query);

    List<Category> handle(ViewCategoriesQuery query);

    Optional<Category> handle(GetCategoryByIdQuery query);
}
