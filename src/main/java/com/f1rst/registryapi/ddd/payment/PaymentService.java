package com.f1rst.registryapi.ddd.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public void save(PaymentRecord record) {
        repository.save(new PaymentEntity(record));
    }

    public void delete(PaymentRecord record) {
///
    }

    public Optional<PaymentRecord> detail(Long id) {
        return repository.findById(id).stream().findFirst().map(PaymentRecord::new);
    }

    public Page<PaymentRecord> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(PaymentRecord::new);
    }

}
