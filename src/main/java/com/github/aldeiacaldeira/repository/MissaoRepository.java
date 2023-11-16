package com.github.aldeiacaldeira.repository;

import com.github.aldeiacaldeira.model.Missao;
import com.github.aldeiacaldeira.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
    List<Missao> findByNinja(Ninja ninja);
    List<Missao> findByClassificacao(String classificacao);
    List<Missao> findByStatus(String status);
}
