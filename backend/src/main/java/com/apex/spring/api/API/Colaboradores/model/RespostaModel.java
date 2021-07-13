package com.apex.spring.api.API.Colaboradores.model;

public class RespostaModel {
	
	private String mensagem;
	
	public RespostaModel() {
		
	}
	
	public RespostaModel(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
