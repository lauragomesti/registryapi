package com.f1rst.registryapi.ddd.agency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository <AgencyEntity, Long> {
}
