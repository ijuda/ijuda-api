package br.com.ijuda.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private String nome;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "prestador_servico_id")
    private PrestadorServico prestadorServico;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
