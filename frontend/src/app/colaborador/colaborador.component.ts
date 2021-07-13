import { Component, OnInit } from '@angular/core';
import { Colaborador } from './colaborador';
import { ColaboradorService } from '../colaborador.service';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  // Vetor
  private colaboradores:Colaborador[];

  // Objeto da classe Postagem
  objetoColaborador = new Colaborador;

  // Construtor
  constructor(private servico:ColaboradorService) { }

  // Iniciar aplicação
  ngOnInit() {
    this.selecionar();
  }

  // Listar postagens
  selecionar() {
    this.servico.listar()
      .subscribe( colaborador => {this.colaboradores = colaborador})
  }

  // Cadastrar
  cadastrar(){
    this.servico.adicionar(this.objetoColaborador)
    .subscribe(retorno => {alert(retorno.mensagem); this.selecionar();})

    
  }

  // Excluir
  excluir(codigo:number){
    
    //Realizar a exclusão
    this.servico.remover(codigo)
    .subscribe(retorno => {
      this.selecionar();
      alert(retorno.mensagem);
    })

   
  }

}
