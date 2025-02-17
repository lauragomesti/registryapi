package com.f1rst.registryapi.payment;

import com.f1rst.registryapi.account.AccountEntity;


import com.f1rst.registryapi.account.AccountIdEmbeddable;
import com.f1rst.registryapi.transaction.TransactionPaymentStatusEnum;
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
    @JoinColumns({
            @JoinColumn(name = "id_origin_agency", referencedColumnName = "id_agency"),
            @JoinColumn(name = "id_origin_account", referencedColumnName = "account_number")
    })
    private AccountEntity originAccount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_destination_agency", referencedColumnName = "id_agency"),
            @JoinColumn(name = "id_destination_account", referencedColumnName = "account_number")
    })
    private AccountEntity destinationAccount;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_status")
    private TransactionPaymentStatusEnum transactionStatusEnum;

    @Column(name="data_hora")
    private LocalDateTime dataHora;

    private Double paymentAmount;

    public PaymentEntity() {
    }

    public PaymentEntity(PaymentRecord record) {
        this.id = record.id();

        this.originAccount = new AccountEntity();
        this.originAccount.setId(new AccountIdEmbeddable(record.originAgencyId(), record.originAccountId()));

        this.destinationAccount = new AccountEntity();
        this.destinationAccount.setId(new AccountIdEmbeddable(record.destinationAgencyId(), record.destinationAccountId()));

        this.transactionStatusEnum = record.transactionStatusEnum();
        this.dataHora = record.dataHora();
        this.paymentAmount = record.paymentAmount();
    }


}
