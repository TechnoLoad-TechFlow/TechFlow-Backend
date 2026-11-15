package com.technoload.techflow.platform.profiles.domain.model.commands;

import com.technoload.techflow.platform.profiles.domain.model.valueobjects.DocumentType;

public record CreateProfileCommand(Long userAccountId, String firstName, String lastName,
                                   DocumentType documentType, String documentNumber,
                                   String phoneNumber, String secondaryEmail, String address,
                                   String district, String city) {
}
