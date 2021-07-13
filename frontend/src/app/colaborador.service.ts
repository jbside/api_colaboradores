import { Injectable } from '@angular/core';
import { Colaborador } from './colaborador/colaborador';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  // Url
  private url = 'http://localhost:8085/api/colaborador';

  // Vetor de postagens
  vetor: Colaborador[];

  // Construtor
  constructor(private http: HttpClient) { }

  // Listar postagens
  listar(): Observable<Colaborador[]> {
    return this.http.get<Colaborador[]>(this.url);
  }

  // Adicionar postagem
  adicionar(colaborador: Colaborador): Observable<any> {
    return this.http.post<any>(this.url, colaborador);
  }

  // Alterar postagem
  alterar(colaborador: Colaborador): Observable<Colaborador> {
    return this.http.put<Colaborador>(this.url + '/' + colaborador.codigo, colaborador);
  }

  // Remover postagem
  remover(id: number): Observable<any> {
    return this.http.delete<Colaborador>(this.url + '/' + id);
  }

}
