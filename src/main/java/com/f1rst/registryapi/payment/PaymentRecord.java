package com.f1rst.registryapi.payment;

import com.f1rst.registryapi.transaction.TransactionPaymentStatusEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PaymentRecord(
        Long id,
        @NotNull
        Integer originAccountId,
        @NotNull
        Integer destinationAccountId,
        @NotNull
        TransactionPaymentStatusEnum transactionStatusEnum,
        @NotNull
        LocalDateTime dataHora,
        @NotNull
        Double paymentAmount
) {
    public PaymentRecord(PaymentEntity entity) {
        this(
                entity.getId(),
                entity.getOriginAccount().getAccountNumber(),
                entity.getDestinationAccount().getAccountNumber(),
                entity.getTransactionStatusEnum(),
                entity.getDataHora(),
                entity.getPaymentAmount()
        );
    }
}

