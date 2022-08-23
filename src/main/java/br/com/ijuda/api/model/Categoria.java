package br.com.ijuda.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @SequenceGenerator(name="categoria_idcategoria_seq",
            sequenceName="categoria_idcategoria_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="categoria_idcategoria_seq")
    private Long id;

    private String categoriaNome;

}
