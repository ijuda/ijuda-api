package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Categoria;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServicoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private Categoria categoria;
}
