package com.f1rst.registryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idContaOrigem", referencedColumnName = "id")
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "idContaDestino", referencedColumnName = "id")
    private Conta contaDestino;

    @Enumerated(EnumType.STRING)
    private StatusTransacao statusTransacao;

    private LocalDateTime dataEhHora;
    private Double valorPagamento;
}
