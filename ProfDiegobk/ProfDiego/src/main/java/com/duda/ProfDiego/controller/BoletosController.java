package com.duda.ProfDiego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
