package com.duda.ProfDiego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_boletos")
public class BoletosModel {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="O campo de número do boleto não pode estar vazio")
	@Size(min = 47, max = 48, message = "o código do boleto deve ter entre 47 e 48 digitos")
	private Long codigo;
	
	@NotNull(message="O campo de vencimento do boleto não pode estar vazio")
	private String vencimento;
	
	
	private String linkboleto;
	
	@ManyToOne
	@JsonIgnoreProperties("boletos")
	private AlunosModel alunos;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getVencimento() {
		return vencimento;
	}


	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}


	public String getLinkboleto() {
		return linkboleto;
	}


	public void setLinkboleto(String linkboleto) {
		this.linkboleto = linkboleto;
	}
	
	
	
	
}
