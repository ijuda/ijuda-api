package br.com.ijuda.api.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "solicitacao_servico")
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private String descricao;

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
    private Boolean ativo; //todo: mapear no esquema


}
