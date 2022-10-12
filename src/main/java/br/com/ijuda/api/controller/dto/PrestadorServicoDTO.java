package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Endereco;
import br.com.ijuda.api.model.Servico;
import br.com.ijuda.api.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PrestadorServicoDTO {
    private Long id;
    private String telefone;
    private String cpf;
    private Endereco endereco;
    private Boolean ativo;
    private List<Servico> servicos;
    private Usuario usuario;
}
