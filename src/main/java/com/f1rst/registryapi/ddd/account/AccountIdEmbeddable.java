package com.f1rst.registryapi.ddd.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountIdEmbeddable that = (AccountIdEmbeddable) o;
        return Objects.equals(id_agency, that.id_agency) &&
                Objects.equals(account_number, that.account_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_agency, account_number);
    }
}


