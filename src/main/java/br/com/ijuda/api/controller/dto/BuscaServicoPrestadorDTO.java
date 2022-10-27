package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.util.StringUtil;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Tuple;

@Getter
@Builder
public class BuscaServicoPrestadorDTO {

    private String prestadorServicoId;

    private String prestadorServico;

    private String servicoId;

    private String servico;

    private String categoriaId;

    private String categoria;

    private String imagem;

    public static BuscaServicoPrestadorDTO tupleToDTO(Tuple tuple) {
        return BuscaServicoPrestadorDTO.builder()
                .prestadorServicoId(StringUtil.numberFromObject(tuple.get("prestadorServicoId")))
                .prestadorServico(StringUtil.fromObject(tuple.get("prestadorServico")))
                .servicoId(StringUtil.numberFromObject(tuple.get("servicoId")))
                .servico(StringUtil.fromObject(tuple.get("servico")))
                .categoriaId(StringUtil.numberFromObject(tuple.get("categoriaId")))
                .categoria(StringUtil.fromObject(tuple.get("categoria")))
                .imagem(StringUtil.fromObject(tuple.get("imagem")))
                .build();
    }

}
