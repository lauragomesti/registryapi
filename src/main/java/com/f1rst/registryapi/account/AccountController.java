package com.f1rst.registryapi.account;

import com.f1rst.registryapi.agency.AgencyRecord;
import com.f1rst.registryapi.agency.AgencyRegisterRecord;
import com.f1rst.registryapi.agency.AgencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid AccountRecord record){
        service.save(record);
        return ResponseEntity.ok("Account successfully registered");
    }

    @GetMapping
    public ResponseEntity<Page<AccountRecord>>
    findAll(@PageableDefault(size = 10, sort = {"statusAccountEnum"}) Pageable pageable){
        var page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var record = service.detail(id);
        return ResponseEntity.ok(record);

    }
}
