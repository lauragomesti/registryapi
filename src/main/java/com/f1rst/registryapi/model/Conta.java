package com.f1rst.registryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ContaId.class)
public class Conta {
    @Id
    @ManyToOne
    @JoinColumn(name = "idAgencia", referencedColumnName = "id")
    private Agencia agencia;

    @Id
    private Integer numeroConta;

    private Double saldo;

    @Enumerated(EnumType.STRING)
    private StatusConta status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
