//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: serviceimpl.ftl
//Element modela: GremoNaElektriko::MarkaVozila


package com.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.repository.ModelVozilaRepository;

import com.ftn.mbrs.service.MarkaVozilaService;
import com.ftn.mbrs.model.MarkaVozila;
import com.ftn.mbrs.repository.MarkaVozilaRepository;

@Service
public class MarkaVozilaServiceImpl implements MarkaVozilaService{

	@Autowired
	private MarkaVozilaRepository markaVozilaRepository;

	@Autowired
	private ModelVozilaRepository modelVozilaRepository;
	
			
	
	@Override
	public MarkaVozila save(MarkaVozila markaVozila) {
		return markaVozilaRepository.save(markaVozila);
	}

	//
	@Override
	public MarkaVozila update(MarkaVozila markaVozila) {		
		MarkaVozila tempMarkaVozila = markaVozilaRepository.getOne(markaVozila.getId());
		
		tempMarkaVozila.setNazivMarkeVozila(markaVozila.getNazivMarkeVozila());    	
    	 	
		
		return markaVozilaRepository.save(tempMarkaVozila);
	}

	//
	@Override
	public String delete(Long id) {
		MarkaVozila markaVozila = markaVozilaRepository.getOne(id);
		
		List<ModelVozila> modelVozilas = modelVozilaRepository.findByMarkaVozila(markaVozila);
		if(!modelVozilas.isEmpty()) {
			return "ERROR";
		}    	
		
		markaVozilaRepository.deleteById(id);
		return "OK";
	}

	@Override
	public MarkaVozila findOne(Long id) {
		return markaVozilaRepository.getOne(id);
	}

	@Override
	public List<MarkaVozila> findAll() {
		return markaVozilaRepository.findAll();
	}

}
