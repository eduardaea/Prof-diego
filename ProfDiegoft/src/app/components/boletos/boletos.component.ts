import { Component, OnInit } from '@angular/core';
import { Alunos } from 'src/app/model/alunos';
import { Boletos } from 'src/app/model/boletos';
import { AlunosService } from 'src/app/service/alunos.service';
import { BoletosService } from 'src/app/service/boletos.service';

@Component({
  selector: 'app-boletos',
  templateUrl: './boletos.component.html',
  styleUrls: ['./boletos.component.css']
})
export class BoletosComponent implements OnInit {
  
  listaBoletos: Boletos[];
  listaAlunos: Alunos[];
  alunosSelecionado: Alunos;
  boleto : Boletos = {};
  statusBoleto: boolean;
  boletoFile: Blob;

  atualDate = (new Date());

  constructor(
    private boletosService: BoletosService,
    private alunosService: AlunosService
  ) { }

  ngOnInit(): void {
    this.getAllBoletos();
    this.getAllAlunos();
  }

  getAllBoletos(){
    this.boletosService.getAllBoletos().subscribe(resp=>{
      this.listaBoletos = resp;
    })
  }

  getAllAlunos(){
    this.alunosService.getAllAlunos().subscribe(resp=>{
      this.listaAlunos = resp;
    })
  }

  postBoleto(){
    //console.log(this.boleto.linkboleto);
    // if (this.boleto.linkboleto) {
      // console.log(typeof this.boletoFile);
      // const reader = new FileReader()
      // reader.readAsDataURL(this.boletoFile); 
      // reader.onloadend = function() {
      //   var base64data = reader.result;                
      //   console.log(base64data);
      // }
    // }
    
    console.log(JSON.stringify(this.boleto))
     this.boletosService.postBoletos(this.boleto).subscribe(resp=>{
       console.log("Cadastrou")
       this.getAllBoletos()
     })
  }

  transform(event: any): void {
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
        this.boleto.linkboleto = String(reader.result);
       
    };
  }

  verificarData(){
    if(this.boleto.vencimento){

      if(this.boleto.vencimento.getFullYear() >= this.atualDate.getFullYear() && 
        this.boleto.vencimento.getDay() >=  this.atualDate.getDay() &&
        this.boleto.vencimento.getMonth() >= this.atualDate.getMonth()){

        this.statusBoleto = true
      }
      else {
        this.statusBoleto = false
      }

    }
    console.log("Erro não sei de quê, investigar!")
    
  }

 
}
