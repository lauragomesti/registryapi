package com.f1rst.registryapi.client;

import com.f1rst.registryapi.account.AccountRecord;
import com.f1rst.registryapi.address.AddressRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record ClientRecord(
        Long id,
        @NotBlank
        String cpfcnpj,
        @NotNull
        TypeClientEnum typeClientEnum,
        AddressRecord address,
        List<AccountRecord> accounts
) {
    public ClientRecord(ClientEntity entity) {
        this(
                entity.getId(),
                entity.getCpfcnpj(),
                entity.getTypeClientEnum(),
                new AddressRecord(entity.getAddressEmbeddable()),
                entity.getAccounts().stream().map(AccountRecord::new).collect(Collectors.toList())
        );
    }
}