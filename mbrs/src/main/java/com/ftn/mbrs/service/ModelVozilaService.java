//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::ModelVozila


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.ModelVozila;

public interface ModelVozilaService {

	public ModelVozila save(ModelVozila modelVozila, Long tipPrikljuckaId, Long markaVozilaId);
	
	public ModelVozila update(ModelVozila modelVozila);

	public String delete(Long id);
	
	public ModelVozila findOne(Long id);
	
	public List<ModelVozila> findAll();
}
