package com.duda.ProfDiego.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duda.ProfDiego.model.DiplomaModel;
import com.duda.ProfDiego.repository.DiplomaRepository;

@RestController
@RequestMapping("/diplomas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiplomaController {

	
	@Autowired 
	private DiplomaRepository diplomaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<DiplomaModel>> getAll() {
		return ResponseEntity.ok(diplomaRepository.findAll());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<DiplomaModel>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(diplomaRepository.findAllByAlunosNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<DiplomaModel>post(@Valid @RequestBody DiplomaModel diploma){
		DiplomaModel newDiploma = diplomaRepository.save(diploma);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDiploma);
		
	}
}
