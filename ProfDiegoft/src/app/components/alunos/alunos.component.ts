import { Alunos } from './../../model/alunos';
import { AlunosService } from './../../service/alunos.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alunos',
  templateUrl: './alunos.component.html',
  styleUrls: ['./alunos.component.css']
})
export class AlunosComponent implements OnInit {

  alunos:Alunos = {};
  listaAlunos:Alunos[]

  constructor(
    private alunosService:AlunosService
    ) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll(){
    this.alunosService.getAllAlunos().subscribe((resp:Alunos[])=>{
      this.listaAlunos = resp
    })
  }

  novoAluno(){
    this.alunosService.postAluno(this.alunos).subscribe(()=>{
      console.log("aluno cadastrado com sucesso")
      this.getAll()
    })
  }

  deletarAluno(id: number | undefined){
    this.alunosService.deleteAluno(Number(id)).subscribe(()=>{
      console.log("Aluno Cadastrado com sucesso!")
      this.getAll()
    })

  }

  alunoSelecionado(aluno: AlunosComponent){
    nome =
  }


}
