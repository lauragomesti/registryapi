package com.f1rst.registryapi.agency;

import jakarta.validation.constraints.NotBlank;

public record AgencyRegisterRecord(
        String name,
        Integer agencyNumber) {

    public AgencyRegisterRecord(AgencyEntity entity) {
        this(entity.getName(),
                entity.getAgencyNumber());
    }
}
