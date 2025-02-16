package com.f1rst.registryapi.transacional;

import com.f1rst.registryapi.pagamento.PaymentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "payment")
@Entity
@Data
@AllArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_payment", referencedColumnName = "id")
    private PaymentEntity paymentEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_operation")
    private TransactionOperationEnum transactionOperationEnum;

    public TransactionEntity() {
    }
}

