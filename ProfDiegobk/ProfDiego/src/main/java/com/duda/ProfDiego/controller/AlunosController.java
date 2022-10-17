package com.duda.ProfDiego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duda.ProfDiego.model.AlunosModel;
import com.duda.ProfDiego.repository.AlunosRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunosController {

	
	@Autowired
	private AlunosRepository alunosRepository;
	
	 @GetMapping("/nome/{nome}")
	 public ResponseEntity<List<AlunosModel>>getById(@PathVariable String nome){
		 return ResponseEntity.ok(alunosRepository.findAllByNomeContainingIgnoreCase(nome));
	 }
}
