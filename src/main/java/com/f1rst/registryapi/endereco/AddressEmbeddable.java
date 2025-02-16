package com.f1rst.registryapi.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class AddressEmbeddable {

    private String street;
    private String district;
    private String cep;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public AddressEmbeddable() {
    }

    public AddressEmbeddable(AddressRecord addressRecord) {
        this.street = addressRecord.street();
        this.district = addressRecord.district();
        this.cep = addressRecord.cep();
        this.uf = addressRecord.uf();
        this.city = addressRecord.city();
        this.number = addressRecord.number();
        this.complement = addressRecord.complement();
    }

}
