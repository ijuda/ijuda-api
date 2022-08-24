package br.com.ijuda.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "categoria_id_seq", allocationSize = 1)
public class Categoria  extends BaseEntity{

    @Column(name = "nome")
    private String nome;

}
