package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "prestador_servico")
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private String nome;

    private String telefone;

    private String cpf;

    private String email;

    @Embedded
    private Endereco endereco;

    @NotNull
    private Boolean ativo; //todo: mapear no esquema


}
