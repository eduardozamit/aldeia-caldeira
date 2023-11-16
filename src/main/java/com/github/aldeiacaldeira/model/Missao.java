package com.github.aldeiacaldeira.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classificacao;
    private String tipoMissao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "ninja_id")
    private Ninja ninja;
}
