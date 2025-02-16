package com.f1rst.registryapi.agency;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "agency")
@Entity
@Data
@AllArgsConstructor
public class AgencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "agency_number", unique = true, nullable = false)
    private Integer agencyNumber;

    public AgencyEntity() {
    }
}
