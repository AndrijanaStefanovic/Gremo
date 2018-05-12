//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: service.ftl
//Element modela: GremoNaElektriko::Cenovnik


package com.ftn.mbrs.service;

import java.util.List;

import com.ftn.mbrs.model.Cenovnik;

public interface CenovnikService {

	public Cenovnik save(Cenovnik cenovnik);
	
	public Cenovnik update(Cenovnik cenovnik);

	public String delete(Long id);
	
	public Cenovnik findOne(Long id);
	
	public List<Cenovnik> findAll();
}
