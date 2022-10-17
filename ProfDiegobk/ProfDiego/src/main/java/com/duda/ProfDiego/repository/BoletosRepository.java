package com.duda.ProfDiego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.BoletosModel;

@Repository
public interface BoletosRepository extends JpaRepository<BoletosModel,Long> {

	
	public List<BoletosModel> findAllByCodigoContainingIgnoreCase(String codigo);
}
