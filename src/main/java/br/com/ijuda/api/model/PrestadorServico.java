package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "prestador_servico")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "prestador_servico_id_seq", allocationSize = 1)
public class PrestadorServico  extends BaseEntity{

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo")
    private Boolean ativo;

    @NotNull
    @JoinColumn(name = "usuario")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name="servico_prestadores_servicos",
            joinColumns=@JoinColumn(name="prestador_servico_id"),
            inverseJoinColumns=@JoinColumn(name="servico_id")
    )
    private List<Servico> servicos;

}
