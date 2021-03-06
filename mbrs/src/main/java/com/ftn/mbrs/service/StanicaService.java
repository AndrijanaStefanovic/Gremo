//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::Stanica


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Stanica;

public interface StanicaService {

	public Stanica save(Stanica stanica, Long gradId);
	
	public Stanica update(Stanica stanica);

	public String delete(Long id);
	
	public Stanica findOne(Long id);
	
	public List<Stanica> findAll();
}
