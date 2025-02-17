package com.f1rst.registryapi.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository repository;

    public void save(AgencyRegisterRecord record) {
        repository.save(new AgencyEntity(record));
    }

    public void delete(AgencyRecord record) {
///
    }

    public Optional<AgencyRecord> detail(Long id) {
        return repository.findById(id).stream().findFirst().map(AgencyRecord::new);
    }


    public Page<AgencyRecord> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(AgencyRecord::new);
    }

}
