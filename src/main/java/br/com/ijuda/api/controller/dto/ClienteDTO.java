package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Endereco;
import br.com.ijuda.api.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private Usuario usuario;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;

}
