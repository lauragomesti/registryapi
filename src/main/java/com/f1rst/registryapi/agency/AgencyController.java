package com.f1rst.registryapi.agency;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid AgencyRegisterRecord record){
        service.save(record);
        return ResponseEntity.ok("Agency successfully registered");
    }

    @GetMapping
    public ResponseEntity<Page<AgencyRecord>>
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
