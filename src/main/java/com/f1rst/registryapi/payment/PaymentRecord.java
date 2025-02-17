package com.f1rst.registryapi.payment;

import com.f1rst.registryapi.transaction.TransactionPaymentStatusEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PaymentRecord(
        Long id,
        @NotNull Long originAgencyId,
        @NotNull Integer originAccountId,
        @NotNull Long destinationAgencyId,
        @NotNull Integer destinationAccountId,
        @NotNull TransactionPaymentStatusEnum transactionStatusEnum,
        @NotNull LocalDateTime dataHora,
        @NotNull Double paymentAmount
) {
    public PaymentRecord(PaymentEntity entity) {
        this(
                entity.getId(),
                entity.getOriginAccount().getId().getId_agency(),
                entity.getOriginAccount().getId().getAccount_number(),
                entity.getDestinationAccount().getId().getId_agency(),
                entity.getDestinationAccount().getId().getAccount_number(),
                entity.getTransactionStatusEnum(),
                entity.getDataHora(),
                entity.getPaymentAmount()
        );
    }
}

