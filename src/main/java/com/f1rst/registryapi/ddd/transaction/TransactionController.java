package com.f1rst.registryapi.ddd.transaction;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid TransactionRecord record){
        service.save(record);
        return ResponseEntity.ok("Transaction successfully registered");
    }

    @GetMapping
    public ResponseEntity<Page<TransactionRecord>>
    findAll(@PageableDefault(size = 10) Pageable pageable){
        var page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var record = service.detail(id);
        return ResponseEntity.ok(record);

    }
}
