package br.com.ijuda.api.controller.dto;

import br.com.ijuda.api.model.Cliente;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PagamentoDTO {
    private Long id;
    private LocalDateTime dataPagamento;
    private Cliente cliente;
    private Double valor;
}
