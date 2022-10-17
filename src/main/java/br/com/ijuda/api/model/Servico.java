package br.com.ijuda.api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
/*
    @ManyToMany
    @JoinTable(
            name = "servico_prestadoresServicos",
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "prestador_servico_id")
    )
    private List<PrestadorServico> prestadoresServicos;
*/
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
