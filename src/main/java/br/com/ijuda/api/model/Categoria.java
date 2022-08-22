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
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQUENCE")
    private Long id;

    private String categoriaNome;

}
