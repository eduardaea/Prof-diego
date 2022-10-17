package com.duda.ProfDiego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.AlunosModel;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {

	
	public List<AlunosModel>findAllByNomeContainingIgnoreCase(String nome);
	
}
