//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::Vozilo


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Vozilo;

public interface VoziloService {

	public Vozilo save(Vozilo vozilo, Long modelVozilaId, Long karticaId);
	
	public Vozilo update(Vozilo vozilo);

	public String delete(Long id);
	
	public Vozilo findOne(Long id);
	
	public List<Vozilo> findAll();
}
