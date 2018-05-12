//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: serviceimpl.ftl
//Element modela: GremoNaElektriko::TipPrikljucka


package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.repository.StavkaCenovnikaRepository;
import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.repository.PunjenjeRepository;
import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.repository.ModelVozilaRepository;

import com.ftn.mbrs.service.TipPrikljuckaService;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.repository.TipPrikljuckaRepository;

@Service
public class TipPrikljuckaServiceImpl implements TipPrikljuckaService{

	@Autowired
	private TipPrikljuckaRepository tipPrikljuckaRepository;

	@Autowired
	private StavkaCenovnikaRepository stavkaCenovnikaRepository;
	
	@Autowired
	private PunjenjeRepository punjenjeRepository;
	
	@Autowired
	private ModelVozilaRepository modelVozilaRepository;
	
			
	
	@Override
	public TipPrikljucka save(TipPrikljucka tipPrikljucka) {
		return tipPrikljuckaRepository.save(tipPrikljucka);
	}

	//
	@Override
	public TipPrikljucka update(TipPrikljucka tipPrikljucka) {		
		TipPrikljucka tempTipPrikljucka = tipPrikljuckaRepository.getOne(tipPrikljucka.getId());
		
		tempTipPrikljucka.setNazivTipaPrikljucka(tipPrikljucka.getNazivTipaPrikljucka());    	
		tempTipPrikljucka.setKw(tipPrikljucka.getKw());    	
    	 	
		
		return tipPrikljuckaRepository.save(tempTipPrikljucka);
	}

	//
	@Override
	public String delete(Long id) {
		TipPrikljucka tipPrikljucka = tipPrikljuckaRepository.getOne(id);
		
		List<StavkaCenovnika> stavkaCenovnikas = stavkaCenovnikaRepository.findByTipPrikljucka(tipPrikljucka);
		if(!stavkaCenovnikas.isEmpty()) {
			return "ERROR";
		}    	
		List<Punjenje> punjenjes = punjenjeRepository.findByTipPrikljucka(tipPrikljucka);
		if(!punjenjes.isEmpty()) {
			return "ERROR";
		}    	
		List<ModelVozila> modelVozilas = modelVozilaRepository.findByTipPrikljucka(tipPrikljucka);
		if(!modelVozilas.isEmpty()) {
			return "ERROR";
		}    	
		
		tipPrikljuckaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public TipPrikljucka findOne(Long id) {
		return tipPrikljuckaRepository.getOne(id);
	}

	@Override
	public List<TipPrikljucka> findAll() {
		return tipPrikljuckaRepository.findAll();
	}

}
