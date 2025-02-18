package com.f1rst.registryapi.ddd.account;

import com.f1rst.registryapi.ddd.agency.AgencyEntity;
import com.f1rst.registryapi.ddd.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "account")
@Entity
@Data
@AllArgsConstructor
public class AccountEntity {

    @EmbeddedId
    private AccountIdEmbeddable id;

    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_account")
    private StatusAccountEnum statusAccountEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private ClientEntity clientEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agency", referencedColumnName = "id", insertable = false, updatable = false)
    private AgencyEntity agency;

    public AccountEntity() {
    }

    public AccountEntity(AccountRecord record) {


        this.id = new AccountIdEmbeddable(record.agencyId(), record.accountNumber());

        this.balance = record.balance();
        this.statusAccountEnum = record.statusAccountEnum();

        this.clientEntity = new ClientEntity();
        this.clientEntity.setId(record.clientId());

    }
}
