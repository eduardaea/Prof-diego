package com.duda.ProfDiego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.BoletosModel;

@Repository
public interface BoletosRepository extends JpaRepository<BoletosModel,Long> {

	
	public List<BoletosModel> findAllByCodigoContainingIgnoreCase(String codigo);
	
	
	@Query(nativeQuery=true, value="SELECT * from tb_boletos b LEFT JOIN tb_alunos a ON b.alunos_id = a.id WHERE b.alunos_id = :alunos")
    public List<BoletosModel> findAllByAlunosContainingIgnoreCase(@Param("alunos") Long id);
}
