package com.apex.spring.api.API.Colaboradores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apex.spring.api.API.Colaboradores.model.ColaboradorModel;
import com.apex.spring.api.API.Colaboradores.model.RespostaModel;
import com.apex.spring.api.API.Colaboradores.repository.ColaboradorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@RequestMapping(value = "/colaborador", method = RequestMethod.GET)
	public @ResponseBody List<ColaboradorModel> consultar() {
		return this.colaboradorRepository.findAll();
	}

	@RequestMapping(value = "/colaborador/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ColaboradorModel buscar(@PathVariable("codigo") Integer codigo) {
		return this.colaboradorRepository.findByCodigo(codigo);
	}

	@RequestMapping(value = "/colaborador", method = RequestMethod.POST)
	public @ResponseBody RespostaModel salvar(@RequestBody ColaboradorModel colaborador) {
		try {
			this.colaboradorRepository.save(colaborador);
			return new RespostaModel("Salvo com sucesso");
		} catch (Exception e) {
			return new RespostaModel("Falha ao salvar/n" + e.getMessage());
		}
	}

	@RequestMapping(value="colaborador/{codigo}", method = RequestMethod.PUT)
	public @ResponseBody RespostaModel alterar(@PathVariable("codigo") Integer codigo,@RequestBody ColaboradorModel colaborador) {
		ColaboradorModel colaboradorModel = colaboradorRepository.findByCodigo(codigo);
		try {
			colaboradorModel.setNome(colaborador.getNome());
			colaboradorModel.setSobrenome(colaborador.getSobrenome());
			colaboradorModel.setEmail(colaborador.getEmail());
			this.colaboradorRepository.save(colaboradorModel);
			return new RespostaModel("Alterado com sucesso");
		} catch (Exception e) {
			return new RespostaModel("Erro ao alterar"+ e.getMessage());
		}
	}
	
	@RequestMapping(value="colaborador/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModel excluir(@PathVariable("codigo") Integer codigo,@RequestBody ColaboradorModel colaborador) {
		ColaboradorModel colaboradorModel = colaboradorRepository.findByCodigo(codigo);
		try {
			this.colaboradorRepository.delete(colaboradorModel);
			return new RespostaModel("Excluido com sucesso");
		} catch (Exception e) {
			return new RespostaModel("Erro ao excluir"+ e.getMessage());
		}
	}
	
	
	
	
	
	
}
