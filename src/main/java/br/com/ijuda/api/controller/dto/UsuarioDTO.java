package br.com.ijuda.api.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
