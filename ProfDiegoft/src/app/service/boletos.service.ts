import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boletos } from '../model/boletos';

@Injectable({
  providedIn: 'root'
})
export class BoletosService {

  baseUrl= "http://localhost:8080/boletos";

  constructor(private http: HttpClient) { }


  getAllBoletos():Observable<Boletos[]>{
    return this.http.get<Boletos[]>(this.baseUrl)
  }

  postBoletos(boleto: Boletos):Observable<Boletos>{
    return this.http.post<Boletos>(this.baseUrl,boleto)
  }

  putBoletos(boleto:Boletos):Observable<Boletos>{
    return this.http.put<Boletos>(this.baseUrl,boleto)
  }

  deleteBoletos(id:number):Observable<Boletos>{
    return this.http.delete<Boletos>(this.baseUrl+id)
  }

  getByUser(id:number):Observable<Boletos[]>{
    return this.http.get<Boletos[]>(this.baseUrl+id)
  }



}
