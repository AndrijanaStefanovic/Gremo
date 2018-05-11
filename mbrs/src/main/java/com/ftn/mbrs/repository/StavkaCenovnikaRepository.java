//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: repository.ftl
//Element modela: GremoNaElektriko::StavkaCenovnika


package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.model.Cenovnik;

public interface StavkaCenovnikaRepository extends JpaRepository<StavkaCenovnika, Long> {

	public List<StavkaCenovnika> findByTipPrikljucka(TipPrikljucka tipPrikljucka);
	public List<StavkaCenovnika> findByCenovnik(Cenovnik cenovnik);

}