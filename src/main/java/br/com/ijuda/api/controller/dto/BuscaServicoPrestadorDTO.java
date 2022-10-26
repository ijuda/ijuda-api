package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.util.StringUtil;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Tuple;

@Getter
@Builder
public class BuscaServicoPrestadorDTO {
    private String prestadorServico;

    private String servico;

    private String imagem;

    public static BuscaServicoPrestadorDTO tupleToDTO(Tuple tuple) {
        return BuscaServicoPrestadorDTO.builder()
                .prestadorServico(StringUtil.fromObject(tuple.get("prestadorServico")))
                .servico(StringUtil.fromObject(tuple.get("servico")))
                .imagem(StringUtil.fromObject(tuple.get("imagem")))
                .build();
    }

}
