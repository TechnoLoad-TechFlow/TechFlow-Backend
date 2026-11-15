package com.technoload.techflow.platform.fleet.interfaces.rest.transform;

import com.technoload.techflow.platform.fleet.domain.model.commands.UpdateMachineryCommand;
import com.technoload.techflow.platform.fleet.interfaces.rest.resources.UpdateMachineryResource;

public final class UpdateMachineryCommandFromResourceAssembler {

    private UpdateMachineryCommandFromResourceAssembler() {
    }

    public static UpdateMachineryCommand toCommandFromResource(Long machineryId, Long ownerProfileId,
                                                               UpdateMachineryResource resource) {
        var rate = resource.hourlyRate();
        var location = resource.location();
        return new UpdateMachineryCommand(machineryId, ownerProfileId, resource.categoryId(), resource.name(),
                resource.description(), resource.brand(), resource.model(), resource.manufactureYear(),
                rate.amount(), rate.currency(), location.department(), location.province(), location.district(),
                location.address(), location.latitude(), location.longitude());
    }
}
