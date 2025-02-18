package com.f1rst.registryapi.ddd.transaction;

import jakarta.validation.constraints.NotNull;

public record TransactionRecord(
        Long id,
        @NotNull
        Long paymentId,
        @NotNull
        TransactionOperationEnum transactionOperationEnum,
        @NotNull
        String agencyType
) {
    public TransactionRecord(TransactionEntity entity) {
        this(
                entity.getId(),
                entity.getPaymentEntity().getId(),
                entity.getTransactionOperationEnum(),
                entity.getAgencyType()
        );
    }
}
