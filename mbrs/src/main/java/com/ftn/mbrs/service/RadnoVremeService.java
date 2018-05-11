//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::RadnoVreme


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.RadnoVreme;

public interface RadnoVremeService {

	public RadnoVreme save(RadnoVreme radnoVreme, Long stanicaId);
	
	public RadnoVreme update(RadnoVreme radnoVreme);

	public String delete(Long id);
	
	public RadnoVreme findOne(Long id);
	
	public List<RadnoVreme> findAll();
}
