package com.f1rst.registryapi.ddd.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public void save(ClientRecord record) {
        repository.save(new ClientEntity(record));
    }

    public void delete(ClientRecord record) {
///
    }

    public Optional<ClientRecord> detail(Long id) {
        return repository.findById(id).stream().findFirst().map(ClientRecord::new);
    }

    public Page<ClientRecord> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ClientRecord::new);
    }

}
