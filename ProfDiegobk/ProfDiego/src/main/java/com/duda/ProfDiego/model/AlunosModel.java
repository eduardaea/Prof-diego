package com.duda.ProfDiego.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="tb_alunos")
public class AlunosModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message= "o atributo Nome é obrigatório")
	private long nome;
	
	private long nascimento;
	
	private long observacao;
	
	private long imguser;
	
	@ManyToOne
	@JsonIgnoreProperties("alunos")
	private UsuariosModel usuario;
	
	
	@OneToMany(mappedBy="alunos", cascade= CascadeType.REMOVE)
	@JsonIgnoreProperties("alunos")
	private List<BoletosModel> boletos;
	
	
	@OneToMany(mappedBy="alunos", cascade= CascadeType.REMOVE)
	@JsonIgnoreProperties("alunos")
	private List<DiplomaModel> diplomas;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNome() {
		return nome;
	}

	public void setNome(long nome) {
		this.nome = nome;
	}

	public long getNascimento() {
		return nascimento;
	}

	public void setNascimento(long nascimento) {
		this.nascimento = nascimento;
	}

	public long getObservacao() {
		return observacao;
	}

	public void setObservacao(long observacao) {
		this.observacao = observacao;
	}

	public long getImguser() {
		return imguser;
	}

	public void setImguser(long imguser) {
		this.imguser = imguser;
	}
	
	
	
	
}