import { Alunos } from './../model/alunos';
import { AlunosComponent } from './../components/alunos/alunos.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  constructor(private http: HttpClient) { }

  getAllAlunos():Observable<Alunos[]> {
    return this.http.get<Alunos[]>('http://localhost:8080/alunos')
  }

  postAluno(aluno:Alunos): Observable<Alunos>{
    return this.http.post<Alunos>('http://localhost:8080/alunos',aluno)
  }

  deleteAluno(id:number) :Observable<Alunos>{
    return this.http.delete<Alunos>(`http://localhost:8080/alunos/${id}`);
  }

}
