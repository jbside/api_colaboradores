package com.apex.spring.api.API.Colaboradores.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.apex.spring.api.API.Colaboradores.model.ColaboradorModel;

public interface ColaboradorRepository extends Repository<ColaboradorModel, Integer> {
	
	void save(ColaboradorModel colaborador);
	
	List<ColaboradorModel> findAll();
	
	ColaboradorModel findByCodigo(Integer codigo);
	
	void delete(ColaboradorModel colaborador);
	
	
}
