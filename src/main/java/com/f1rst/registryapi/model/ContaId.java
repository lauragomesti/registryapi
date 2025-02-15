package com.f1rst.registryapi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class ContaId implements java.io.Serializable {
    private Long agencia;
    private Integer numeroConta;
}
