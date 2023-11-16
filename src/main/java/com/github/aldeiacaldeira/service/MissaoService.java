package com.github.aldeiacaldeira.service;

import com.github.aldeiacaldeira.model.Missao;
import com.github.aldeiacaldeira.repository.MissaoRepository;
import com.github.aldeiacaldeira.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    @Autowired
    private NinjaRepository ninjaRepository;

    public List<Missao> getAllMissoes() {
        return missaoRepository.findAll();
    }

    public Missao getMissaoById(Long id) {
        return missaoRepository.findById(id).orElse(null);
    }

    public Missao createMissao(Missao missao) {
        // Adicione validações aqui, por exemplo, não permitir cadastro sem dados necessários
        return missaoRepository.save(missao);
    }

    public Missao updateMissao(Long id, Missao updatedMissao) {
        Missao missao = missaoRepository.findById(id).orElse(null);
        if (missao != null) {
            // ATT CAMPOS
            missao.setClassificacao(updatedMissao.getClassificacao());
            missao.setTipoMissao(updatedMissao.getTipoMissao());
            missao.setStatus(updatedMissao.getStatus());

            return missaoRepository.save(missao);
        } else {
            return null;
        }
    }

    public List<Missao> getMissaoByDifficulty(String difficulty) {
        return missaoRepository.findByClassificacao(difficulty);
    }

    public List<Missao> getMissaoByStatus(String status) {
        return missaoRepository.findByStatus(status);
    }
}
