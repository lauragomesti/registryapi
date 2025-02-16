package com.f1rst.registryapi.pagamento;

import com.f1rst.registryapi.account.AccountEntity;


import com.f1rst.registryapi.transacional.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "payment")
@Entity
@Data
@AllArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_origin_account", referencedColumnName = "id")
    private AccountEntity originAccount;

    @ManyToOne
    @JoinColumn(name = "id_destination_account", referencedColumnName = "id")
    private AccountEntity destinationAccount;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_status")
    private TransactionStatusEnum transactionStatusEnum;

    @Column(name="data_hora")
    private LocalDateTime dataHora;

    private Double paymentAmount;

    public PaymentEntity() {
    }


}
