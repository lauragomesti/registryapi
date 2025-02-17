package com.f1rst.registryapi.client;

import com.f1rst.registryapi.account.AccountEntity;
import com.f1rst.registryapi.address.AddressEmbeddable;
import com.f1rst.registryapi.address.AddressRecord;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "client")
@Entity
@Data
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "clientEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AccountEntity> accounts;

    @Column(name="id_address")
    private AddressEmbeddable addressEmbeddable;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_client")
    private TypeClientEnum typeClientEnum;

    @Column(unique = true, nullable = false)
    private String cpfcnpj;

    public ClientEntity() {
    }

    public ClientEntity(ClientRecord record) {
        this.id = record.id();
        this.cpfcnpj = record.cpfcnpj();
        this.typeClientEnum = record.typeClientEnum();
        this.addressEmbeddable = new AddressEmbeddable(record.address());

        // Inicializa a lista de contas se o record contiver contas
        if (record.accounts() != null) {
            this.accounts = record.accounts().stream()
                    .map(AccountEntity::new) // Converte cada AccountRecord em AccountEntity
                    .collect(Collectors.toList());
        } else {
            this.accounts = new ArrayList<>();
        }
    }

}