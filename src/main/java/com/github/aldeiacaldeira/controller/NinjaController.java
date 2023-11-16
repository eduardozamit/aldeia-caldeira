package com.github.aldeiacaldeira.controller;

import com.github.aldeiacaldeira.model.Ninja;
import com.github.aldeiacaldeira.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping
    public ResponseEntity<List<Ninja>> getAllNinjas() {
        List<Ninja> ninjas = ninjaService.getAllNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ninja> getNinjaById(@PathVariable Long id) {
        Ninja ninja = ninjaService.getNinjaById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ninja> createNinja(@RequestBody Ninja ninja) {
        Ninja createdNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNinja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ninja> updateNinja(@PathVariable Long id, @RequestBody Ninja ninja) {
        Ninja updatedNinja = ninjaService.updateNinja(id, ninja);
        if (updatedNinja != null) {
            return ResponseEntity.ok(updatedNinja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

