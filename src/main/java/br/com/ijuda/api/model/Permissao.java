package br.com.ijuda.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "permissao")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "permissao_id_seq", allocationSize = 1)
public class Permissao extends BaseEntity {

	private String descricao;

}
