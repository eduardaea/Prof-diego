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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duda.ProfDiego.model.AlunosModel;
import com.duda.ProfDiego.repository.AlunosRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunosController {

	
	@Autowired
	private AlunosRepository alunosRepository;
	
	@GetMapping
	public ResponseEntity<List<AlunosModel>>getAll(){
		return ResponseEntity.ok(alunosRepository.findAll());
	}
	
	 @GetMapping("/nome/{nome}")
	 public ResponseEntity<List<AlunosModel>>getById(@PathVariable String nome){
		 return ResponseEntity.ok(alunosRepository.findAllByNomeContainingIgnoreCase(nome));
	 }
	 @PostMapping
	 public ResponseEntity<AlunosModel>post(@Valid @RequestBody AlunosModel aluno){
		 System.out.printf("o aluno",aluno); 
		 AlunosModel createdAluno = alunosRepository.save(aluno);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdAluno);
	 } 
	 
	 @PutMapping
	 public ResponseEntity<AlunosModel>put(@Valid @RequestBody AlunosModel aluno){
		 AlunosModel updatedAluno = alunosRepository.save(aluno);
		 return ResponseEntity.status(HttpStatus.OK).body(updatedAluno);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> delete(@RequestParam String id){
//		 Long idConv = (Long) id;
		 Long idConv=Long.parseLong(id);
		 return alunosRepository.findById(idConv).map(resposta->{
			 alunosRepository.deleteById(idConv);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
		 
	 }
	 
}
