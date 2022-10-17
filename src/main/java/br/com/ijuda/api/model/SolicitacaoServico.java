package br.com.ijuda.api.model;

import br.com.ijuda.api.model.enumeration.StatusSolicitacao;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "solicitacao_servico")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "solicitacao_servico_id_seq", allocationSize = 1)
public class SolicitacaoServico extends BaseEntity{

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "prestador_servico_id")
    private PrestadorServico prestadorServico;

    @ManyToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusSolicitacao statusSolicitacao;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo")
    private Boolean ativo;


}
