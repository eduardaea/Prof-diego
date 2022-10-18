package com.duda.ProfDiego.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@PostMapping
	public ResponseEntity<UsuariosModel>post(@Valid @RequestBody UsuariosModel usuario){
	System.out.println(usuario);
	UsuariosModel createdUsuario = usuarioRepository.save(usuario);
	return	ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
	}
}
