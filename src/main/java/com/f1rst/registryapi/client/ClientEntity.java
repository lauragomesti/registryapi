package com.f1rst.registryapi.client;

import com.f1rst.registryapi.account.AccountEntity;
import com.f1rst.registryapi.endereco.AddressEmbeddable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
}