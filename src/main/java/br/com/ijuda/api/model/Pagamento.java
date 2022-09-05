package br.com.ijuda.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pagamento")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "pagamento_id_seq", allocationSize = 1)
public class Pagamento extends BaseEntity{

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "valor")
    private Double valor;
}
