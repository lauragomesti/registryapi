package com.f1rst.registryapi.ddd.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public void save(AccountRecord record) {
        repository.save(new AccountEntity(record));
    }

    public void delete(AccountRecord record) {
///
    }

    public Optional<AccountRecord> detail(Long id) {
        return repository.findById(id).stream().findFirst().map(AccountRecord::new);
    }

    public Page<AccountRecord> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(AccountRecord::new);
    }

}
