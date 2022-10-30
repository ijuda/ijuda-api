package br.com.ijuda.api.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnderecoDTO {
    private String rua;
    private String bairro;
    private Long numero;
    private String complemento;
    private String cidade;
    private String pais;
    private String cep;
}
