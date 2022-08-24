package br.com.ijuda.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "servico")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "servico_id_seq", allocationSize = 1)
public class Servico extends BaseEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "prestador_servico_id")
    private PrestadorServico prestadorServico;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
