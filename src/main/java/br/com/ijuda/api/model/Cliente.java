package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.*;

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


    public Cliente(Long id, Usuario usuario, byte[] imagem, String cpf, String telefone, Endereco endereco, Boolean ativo) {
        super();
    }
}
