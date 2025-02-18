package com.f1rst.registryapi.ddd.agency;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgencyRecord(

        Long id,
        @NotBlank(message = "Nome é obrigatório!")
        String name,
        @NotNull(message = "Numero da conta é obrigatório!")
        Integer agencyNumber,
        @NotNull(message = "Tipo da agencia é obrigatório!")
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
