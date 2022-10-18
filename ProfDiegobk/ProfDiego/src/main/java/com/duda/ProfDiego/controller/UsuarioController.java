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

import com.duda.ProfDiego.model.UsuariosModel;
import com.duda.ProfDiego.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<UsuariosModel>>getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UsuariosModel>post(@Valid @RequestBody UsuariosModel usuario){
	UsuariosModel createdUsuario = usuarioRepository.save(usuario);
	return	ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
	}
}
