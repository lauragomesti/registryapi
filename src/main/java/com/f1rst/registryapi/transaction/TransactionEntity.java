package com.f1rst.registryapi.transaction;

import com.f1rst.registryapi.payment.PaymentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "transaction")
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

    @Column(name = "agency_type")
    private String agencyType;

    public TransactionEntity() {
    }

    public TransactionEntity(TransactionRecord record) {
        this.id = record.id();

        this.paymentEntity = new PaymentEntity();
        this.paymentEntity.setId(record.paymentId());

        this.transactionOperationEnum = record.transactionOperationEnum();
        this.agencyType = record.agencyType();
    }
}

