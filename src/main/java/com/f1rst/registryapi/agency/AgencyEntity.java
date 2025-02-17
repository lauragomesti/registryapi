package com.f1rst.registryapi.agency;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "agency")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class AgencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "agency_number", unique = true, nullable = false)
    private Integer agencyNumber;

    AgencyType agencyType;

    public AgencyEntity() {}

    public AgencyEntity (AgencyRegisterRecord record) {
        this.name = record.name();
        this.agencyNumber =  record.agencyNumber();
    }
}
