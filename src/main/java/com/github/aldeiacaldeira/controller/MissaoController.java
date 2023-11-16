package com.github.aldeiacaldeira.controller;

import com.github.aldeiacaldeira.model.Missao;
import com.github.aldeiacaldeira.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @GetMapping
    public ResponseEntity<List<Missao>> getAllMissoes() {
        List<Missao> missoes = missaoService.getAllMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Missao> getMissaoById(@PathVariable Long id) {
        Missao missao = missaoService.getMissaoById(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Missao> createMissao(@RequestBody Missao missao) {
        Missao createdMissao = missaoService.createMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMissao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> updateMissao(@PathVariable Long id, @RequestBody Missao missao) {
        Missao updatedMissao = missaoService.updateMissao(id, missao);
        if (updatedMissao != null) {
            return ResponseEntity.ok(updatedMissao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byDifficulty/{difficulty}")
    public ResponseEntity<List<Missao>> getMissoesByDifficulty(@PathVariable String difficulty) {
        List<Missao> missoes = missaoService.getMissaoByDifficulty(difficulty);
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/byStatus/{status}")
    public ResponseEntity<List<Missao>> getMissoesByStatus(@PathVariable String status) {
        List<Missao> missoes = missaoService.getMissaoByStatus(status);
        return ResponseEntity.ok(missoes);
    }

}
