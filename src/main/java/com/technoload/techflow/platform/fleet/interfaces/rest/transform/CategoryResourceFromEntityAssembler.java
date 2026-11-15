package com.technoload.techflow.platform.fleet.interfaces.rest.transform;

import com.technoload.techflow.platform.fleet.domain.model.aggregates.Category;
import com.technoload.techflow.platform.fleet.interfaces.rest.resources.CategoryResource;

public final class CategoryResourceFromEntityAssembler {

    private CategoryResourceFromEntityAssembler() {
    }

    public static CategoryResource toResourceFromEntity(Category category) {
        return new CategoryResource(category.getId(), category.getCode(), category.getName());
    }
}
