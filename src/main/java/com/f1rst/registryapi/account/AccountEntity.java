package com.f1rst.registryapi.account;

import com.f1rst.registryapi.agency.AgencyEntity;
import com.f1rst.registryapi.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "account")
@Entity
@Data
@AllArgsConstructor
@IdClass(AccountIdEmbeddable.class)
public class AccountEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AgencyEntity agency;

    @Id
    @Column(name = "account_number")
    private Integer accountNumber;

    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_account")
    private StatusAccountEnum statusAccountEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    private ClientEntity clientEntity;

    public AccountEntity() {
    }

    public AccountEntity(AccountRecord record) {

        this.agency = new AgencyEntity();
        this.agency.setId(record.agencyId());

        this.accountNumber = record.accountNumber();
        this.balance = record.balance();
        this.statusAccountEnum = record.statusAccountEnum();

        this.clientEntity = new ClientEntity();
        this.clientEntity.setId(record.clientId());

    }
}
