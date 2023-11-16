package com.github.aldeiacaldeira.service;

import com.github.aldeiacaldeira.model.Missao;
import com.github.aldeiacaldeira.model.Ninja;
import com.github.aldeiacaldeira.repository.MissaoRepository;
import com.github.aldeiacaldeira.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    @Autowired
    private MissaoRepository missaoRepository;

    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public Ninja createNinja(Ninja ninja) {
        // Adicione validações aqui, por exemplo, não permitir cadastro sem dados necessários
        return ninjaRepository.save(ninja);
    }

    public Ninja updateNinja(Long id, Ninja updatedNinja) {
        Ninja ninja = ninjaRepository.findById(id).orElse(null);
        if (ninja != null) {
            // ATUALIZAR AMPOS
            ninja.setNome(updatedNinja.getNome());
            ninja.setVila(updatedNinja.getVila());
            ninja.setStatus(updatedNinja.getStatus());
            ninja.setNivelExperiencia(updatedNinja.getNivelExperiencia());

            return ninjaRepository.save(ninja);
        } else {
            return null;
        }
    }

    public List<Missao> getMissoesByNinja(Long ninjaId) {
        Ninja ninja = ninjaRepository.findById(ninjaId).orElse(null);
        if (ninja != null) {
            return missaoRepository.findByNinja(ninja);
        } else {
            return null;
        }
    }

}
