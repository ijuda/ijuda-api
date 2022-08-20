package br.com.ijuda.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @Embedded
    private Endereco endereco;


}
