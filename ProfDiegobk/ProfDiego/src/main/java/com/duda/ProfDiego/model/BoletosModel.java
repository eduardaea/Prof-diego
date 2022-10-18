package com.duda.ProfDiego.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_boletos")
public class BoletosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O campo de número do boleto não pode estar vazio")
	@Size(min = 47, max = 48, message = "o código do boleto deve ter entre 47 e 48 digitos")
	private String codigo;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Type(type="date")
	@NotNull(message="O campo de vencimento do boleto não pode estar vazio")
	private Date vencimento;
	
	
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


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Date getVencimento() {
		return vencimento;
	}


	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}


	public String getLinkboleto() {
		return linkboleto;
	}


	public void setLinkboleto(String linkboleto) {
		this.linkboleto = linkboleto;
	}
	
	
	
	
}
