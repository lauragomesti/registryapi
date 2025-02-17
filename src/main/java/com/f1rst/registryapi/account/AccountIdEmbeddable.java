package com.f1rst.registryapi.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Embeddable
@Getter
@AllArgsConstructor
public class AccountIdEmbeddable implements java.io.Serializable {

    @Column(name = "id_agency")
    private Long id_agency;

    @Column(name = "account_number")
    private Integer account_number;

    public AccountIdEmbeddable(){

    }

}
