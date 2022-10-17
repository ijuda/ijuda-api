package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Endereco;
import br.com.ijuda.api.model.Usuario;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteDTO {
    private Long id;
    private Usuario usuario;
    private byte[] imagem;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;

}
