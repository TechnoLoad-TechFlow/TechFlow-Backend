package com.technoload.techflow.platform.fleet.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;

public record RenameCategoryResource(@NotBlank String name) {
}
