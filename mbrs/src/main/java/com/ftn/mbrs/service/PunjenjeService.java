//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::Punjenje


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Punjenje;

public interface PunjenjeService {

	public Punjenje save(Punjenje punjenje, Long voziloId, Long tipPrikljuckaId, Long stanicaId);
	
	public Punjenje update(Punjenje punjenje);

	public String delete(Long id);
	
	public Punjenje findOne(Long id);
	
	public List<Punjenje> findAll();
}
