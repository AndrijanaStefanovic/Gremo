//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::Grad


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Grad;

public interface GradService {

	public Grad save(Grad grad);
	
	public Grad update(Grad grad);

	public String delete(Long id);
	
	public Grad findOne(Long id);
	
	public List<Grad> findAll();
}
