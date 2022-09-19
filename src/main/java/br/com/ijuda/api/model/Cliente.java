package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cliente")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "cliente_id_seq", allocationSize = 1)
public class Cliente extends BaseEntity {

    @NotNull
    @JoinColumn(name = "usuario")
    @OneToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;

    @Column
    private byte[] imagem;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo")
    private Boolean ativo;


}
