package com.duda.ProfDiego.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public ResponseEntity<BoletosModel>post(@Valid @RequestBody BoletosModel boleto){
		BoletosModel newBoleto = boletosRepository.save(boleto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBoleto);
	}
	
}
