package com.f1rst.registryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idPagamento", referencedColumnName = "id")
    private Pagamento pagamento;

    @Enumerated(EnumType.STRING)
    private Operacao operacao;
}

enum Operacao {
    FINALIZADA, REVERTIDA, ANULADA;
}
