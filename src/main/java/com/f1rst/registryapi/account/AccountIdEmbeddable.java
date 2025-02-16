package com.f1rst.registryapi.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class AccountIdEmbeddable implements java.io.Serializable {
    private Long agency;
    private Integer accountNumber;
}
