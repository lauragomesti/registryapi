package com.f1rst.registryapi.client;

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
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid ClientRecord record){
        service.save(record);
        return ResponseEntity.ok("Client successfully registered");
    }

    @GetMapping
    public ResponseEntity<Page<ClientRecord>>
    findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var record = service.detail(id);
        return ResponseEntity.ok(record);

    }
}
