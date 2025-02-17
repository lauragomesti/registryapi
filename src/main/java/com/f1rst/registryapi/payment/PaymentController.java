package com.f1rst.registryapi.payment;

import com.f1rst.registryapi.client.ClientRecord;
import com.f1rst.registryapi.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid PaymentRecord record){
        service.save(record);
        return ResponseEntity.ok("Client successfully registered");
    }

    @GetMapping
    public ResponseEntity<Page<PaymentRecord>>
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
