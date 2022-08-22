package br.com.ijuda.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private LocalDateTime dataPagamento;
}
