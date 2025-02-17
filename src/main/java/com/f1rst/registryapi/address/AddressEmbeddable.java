package com.f1rst.registryapi.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class AddressEmbeddable {

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_district")
    private String district;

    @Column(name = "address_cep")
    private String cep;

    @Column(name = "address_number")
    private String number;

    @Column(name = "address_complement")
    private String complement;

    @Column(name = "address_city")
    private String city;

    @Column(name = "address_uf")
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
