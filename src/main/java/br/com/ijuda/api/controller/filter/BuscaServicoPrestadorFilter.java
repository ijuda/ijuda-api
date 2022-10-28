package br.com.ijuda.api.controller.filter;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BuscaServicoPrestadorFilter {

    private List<Long> servicos;

    private List<Long> categorias;

}
