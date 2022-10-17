package com.duda.ProfDiego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_diplomas")
public class DiplomaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@NotNull(message="O campo de diploma não pode estar Vazio")
	@Size(min=10,max=100, message="O link deve ter pelo menos 10 caracteres")
	private String linkdiploma;

	
	
	@ManyToOne
	@JsonIgnoreProperties("diplomas")
	private AlunosModel alunos;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return descricao;
	}

	public void setDesc(String desc) {
		this.descricao = desc;
	}

	public String getLinkdiploma() {
		return linkdiploma;
	}

	public void setLinkdiploma(String linkdiploma) {
		this.linkdiploma = linkdiploma;
	}
	
	
	
	

}
