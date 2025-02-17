package com.f1rst.registryapi.agency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository <AgencyEntity, Long> {
}
