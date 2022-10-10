package com.duda.ProfDiego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.AlunosModel;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {

}
