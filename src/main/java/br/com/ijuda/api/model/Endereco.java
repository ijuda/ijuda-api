package br.com.ijuda.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Endereco {

    private String rua;

    private Long numero;

    private String complemento; //TODO: add no diagrama do banco

    private String cidade;

    private String pais;

    private String cep;



}
