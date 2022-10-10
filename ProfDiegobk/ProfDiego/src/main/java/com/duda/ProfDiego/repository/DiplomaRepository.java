package com.duda.ProfDiego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duda.ProfDiego.model.DiplomaModel;

@Repository
public interface DiplomaRepository extends JpaRepository<DiplomaModel, Long> {

}
