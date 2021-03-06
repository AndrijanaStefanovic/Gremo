//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: repository.ftl
//Element modela: GremoNaElektriko::Punjenje


package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.Punjenje;
import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.model.Stanica;

public interface PunjenjeRepository extends JpaRepository<Punjenje, Long> {

	public List<Punjenje> findByVozilo(Vozilo vozilo);
	public List<Punjenje> findByTipPrikljucka(TipPrikljucka tipPrikljucka);
	public List<Punjenje> findByStanica(Stanica stanica);

}