package com.duda.ProfDiego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.DiplomaModel;

@Repository
public interface DiplomaRepository extends JpaRepository<DiplomaModel, Long> {
	
	public List<DiplomaModel>findAllByAlunosNome(String nome);

}
