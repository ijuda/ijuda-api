package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Categoria;
import br.com.ijuda.api.model.PrestadorServico;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ServicoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private Categoria categoria;
}
