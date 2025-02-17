package com.f1rst.registryapi.agency;


import com.f1rst.registryapi.agency.AgencyEntity;
import jakarta.validation.constraints.NotBlank;

public record AgencyRecord(

        Long id,
        @NotBlank(message = "Nome é obrigatório!")
        String name,
        Integer agencyNumber,
        AgencyTypeEnum agencyType){

        public AgencyRecord(AgencyEntity entity) {
            this(
                    entity.getId(),
                    entity.getName(),
                    entity.getAgencyNumber(),
                    entity.getAgencyType()
            );
        }
}
