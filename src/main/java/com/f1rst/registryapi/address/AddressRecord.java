package com.f1rst.registryapi.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRecord(

    @NotBlank
    String street,
    @NotBlank
    String district,
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep,
    @NotBlank
    String uf,
    @NotBlank
    String number,
    @NotBlank
    String city,
    String complement
   ) {
}
