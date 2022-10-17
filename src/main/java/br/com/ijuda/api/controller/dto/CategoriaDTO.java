package br.com.ijuda.api.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CategoriaDTO implements Serializable {
    private Long id;
    private String nome;
}
