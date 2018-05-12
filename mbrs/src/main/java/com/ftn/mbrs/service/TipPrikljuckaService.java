//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::TipPrikljucka


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.TipPrikljucka;

public interface TipPrikljuckaService {

	public TipPrikljucka save(TipPrikljucka tipPrikljucka);
	
	public TipPrikljucka update(TipPrikljucka tipPrikljucka);

	public String delete(Long id);
	
	public TipPrikljucka findOne(Long id);
	
	public List<TipPrikljucka> findAll();
}
