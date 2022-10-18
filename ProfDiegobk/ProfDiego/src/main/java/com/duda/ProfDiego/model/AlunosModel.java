package com.duda.ProfDiego.model;

import java.util.Date;
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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name="tb_alunos")
public class AlunosModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message= "o atributo Nome é obrigatório")
	private String nome;
	

	@JsonFormat(pattern="dd-MM-yyyy")
	@Type(type="date")
	private Date nascimento;
	
	private String observacao;
	
	private String imguser;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getImguser() {
		return imguser;
	}

	public void setImguser(String imguser) {
		this.imguser = imguser;
	}
	
	
	
	
}