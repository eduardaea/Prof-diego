package com.duda.ProfDiego.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duda.ProfDiego.model.BoletosModel;
import com.duda.ProfDiego.repository.BoletosRepository;

@RestController
@RequestMapping("/boletos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoletosController {

	@Autowired
	private BoletosRepository boletosRepository;
	
	
	@GetMapping
	public ResponseEntity<List<BoletosModel>> getAllBoletos(){
		return ResponseEntity.ok(boletosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<BoletosModel>>getByAlunos(@PathVariable String id){
		Long idConv=Long.parseLong(id);
		return ResponseEntity.ok(boletosRepository.findAllByAlunosContainingIgnoreCase(idConv));
	}
	
	@PostMapping
	public ResponseEntity<BoletosModel>post(@Valid @RequestBody BoletosModel boleto){
		BoletosModel newBoleto = boletosRepository.save(boleto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBoleto);
	}
	
	@PutMapping
	 public ResponseEntity<BoletosModel>put(@Valid @RequestBody BoletosModel boleto){
		 BoletosModel updatedBoleto = boletosRepository.save(boleto);
		 return ResponseEntity.status(HttpStatus.OK).body(updatedBoleto);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> delete(@PathVariable String id){
		 Long idConv=Long.parseLong(id);
		 return boletosRepository.findById(idConv).map(resposta->{
			 boletosRepository.deleteById(idConv);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
		 
	 }
	 
	
	
}
