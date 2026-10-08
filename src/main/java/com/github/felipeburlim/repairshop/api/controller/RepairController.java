package com.github.felipeburlim.repairshop.api.controller;

import com.github.felipeburlim.repairshop.api.dto.CreateRepairData;
import com.github.felipeburlim.repairshop.api.dto.RepairDetailsData;
import com.github.felipeburlim.repairshop.api.dto.RepairListData;
import com.github.felipeburlim.repairshop.api.dto.UpdateRepairData;
import com.github.felipeburlim.repairshop.api.model.*;
import com.github.felipeburlim.repairshop.api.repository.RepairRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("repairs")
public class RepairController {

    @Autowired
    private RepairRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<RepairDetailsData> create(@RequestBody @Valid CreateRepairData data, UriComponentsBuilder uriBuilder) {
        var repair = new Repair(data);
        repository.save(repair);

        var uri = uriBuilder.path("/repairs/{id}").buildAndExpand(repair.getId()).toUri();
        return ResponseEntity.created(uri).body(new RepairDetailsData(repair));
    }

    @GetMapping
    public ResponseEntity<Page<Repair>> listAll(Pageable pagination) {
        var page = repository.findAll(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<RepairListData>> listSummary() {
        var list = repository.findAllByActiveTrue().stream()
                .map(RepairListData::new)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairDetailsData> getById(@PathVariable Long id) {
        Optional<Repair> repairOptional = repository.findById(id);
        if (repairOptional.isPresent()) {
            Repair repair = repairOptional.get();
            return ResponseEntity.ok(new RepairDetailsData(repair));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<RepairDetailsData> update(@RequestBody @Valid UpdateRepairData data) {
        Repair repair = repository.getReferenceById(data.id());
        repair.updateInformation(data);
        return ResponseEntity.ok(new RepairDetailsData(repair));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Repair repair = repository.getReferenceById(id);
        repair.delete();
        return ResponseEntity.noContent().build();
    }
}