package com.f1rst.registryapi.ddd.client;

import com.f1rst.registryapi.ddd.account.AccountEntity;
import com.f1rst.registryapi.ddd.address.AddressEmbeddable;
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

    private String name;

    @OneToMany(mappedBy = "clientEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AccountEntity> accounts;

    @Embedded
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
        this.name = record.name();
        this.cpfcnpj = record.cpfcnpj();
        this.typeClientEnum = record.typeClientEnum();
        this.addressEmbeddable = new AddressEmbeddable(record.address());

        // Inicializa a lista de contas se o record tiver contas
        if (record.accounts() != null) {
            this.accounts = record.accounts().stream()
                    .map(AccountEntity::new) // Converte cada AccountRecord em AccountEntity
                    .collect(Collectors.toList());
        } else {
            this.accounts = new ArrayList<>();
        }
    }

}