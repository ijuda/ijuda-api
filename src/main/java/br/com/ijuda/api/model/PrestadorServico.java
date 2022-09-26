package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
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
@Table(name = "prestador_servico")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "prestador_servico_id_seq", allocationSize = 1)
public class PrestadorServico  extends BaseEntity{

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo")
    private Boolean ativo; //todo: mapear no esquema

    @ManyToMany(mappedBy ="prestadoresServicos")
    private List<Servico> servicos;

    @NotNull
    @JoinColumn(name = "usuario")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;


}
