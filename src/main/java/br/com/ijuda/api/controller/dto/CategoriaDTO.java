package br.com.ijuda.api.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoriaDTO {
    private Long id;
    private String nome;
}
