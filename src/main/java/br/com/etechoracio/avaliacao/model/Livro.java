package br.com.etechoracio.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.etechoracio.common.model.BaseORM;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="LIVRO")
public class Livro extends BaseORM{

	@Id
	@GeneratedValue
	@Column(name="ID_LVR")
	private Long id;
	
	@Column(name="NM_LVR")
	private String nome;
	
	@Column(name="NM_AUTOR")
	private String autor;
	
	@Column(name="NM_EDITORA")
	private String editora;
	
	@Column(name="CTGR")
	private String categoria;
	
	@Column(name="QNTD")
	private Double quantidade;
}
