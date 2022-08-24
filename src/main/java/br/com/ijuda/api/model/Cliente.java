package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @Embedded
    private Endereco endereco;

    @NotNull
    private Boolean ativo; //todo: mapear no esquema


}
