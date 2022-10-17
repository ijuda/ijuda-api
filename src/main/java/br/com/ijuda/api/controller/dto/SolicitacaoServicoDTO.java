package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.*;
import br.com.ijuda.api.model.enumeration.StatusSolicitacao;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SolicitacaoServicoDTO {
    private Long id;
    private String descricao;
    private Double total;
    private Cliente cliente;
    private PrestadorServico prestadorServico;
    private Pagamento pagamento;
    private Servico servico;
    private StatusSolicitacao statusSolicitacao;
    private Endereco endereco;
    private Boolean ativo;
}
