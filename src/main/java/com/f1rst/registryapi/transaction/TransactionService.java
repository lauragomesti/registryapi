package com.f1rst.registryapi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public void save(TransactionRecord record) {
        repository.save(new TransactionEntity(record));
    }

    public void delete(TransactionRecord record) {
///
    }

    public Optional<TransactionRecord> detail(Long id) {
        return repository.findById(id).stream().findFirst().map(TransactionRecord::new);
    }

    public Page<TransactionRecord> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(TransactionRecord::new);
    }

}
