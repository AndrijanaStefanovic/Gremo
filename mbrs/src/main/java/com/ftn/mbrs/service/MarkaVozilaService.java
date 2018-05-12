//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::MarkaVozila


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.MarkaVozila;

public interface MarkaVozilaService {

	public MarkaVozila save(MarkaVozila markaVozila);
	
	public MarkaVozila update(MarkaVozila markaVozila);

	public String delete(Long id);
	
	public MarkaVozila findOne(Long id);
	
	public List<MarkaVozila> findAll();
}
