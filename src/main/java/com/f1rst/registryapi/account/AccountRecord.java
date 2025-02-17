package com.f1rst.registryapi.account;


import jakarta.validation.constraints.NotNull;

public record AccountRecord(
        @NotNull
        Long agencyId,
        @NotNull
        Integer accountNumber,
        @NotNull
        Double balance,
        @NotNull
        StatusAccountEnum statusAccountEnum,
        @NotNull
        Long clientId
) {
    public AccountRecord(AccountEntity entity) {
        this(
                entity.getId().getId_agency(),
                entity.getId().getAccount_number(),
                entity.getBalance(),
                entity.getStatusAccountEnum(),
                entity.getClientEntity().getId()
        );
    }

}