//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: ejbclass.ftl
//Element modela: GremoNaElektriko::TipPrikljucka

package com.ftn.mbrs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipPrikljucka implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String nazivTipaPrikljucka;
    
	@Column
    private float kw;
    

	public TipPrikljucka() {}
	
	public TipPrikljucka(String nazivTipaPrikljucka, float kw){
		this.nazivTipaPrikljucka = nazivTipaPrikljucka;
		this.kw = kw;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getNazivTipaPrikljucka(){
           return nazivTipaPrikljucka;
      }
      
      public void setNazivTipaPrikljucka(String nazivTipaPrikljucka){
           this.nazivTipaPrikljucka = nazivTipaPrikljucka;
      }
      
      public float getKw(){
           return kw;
      }
      
      public void setKw(float kw){
           this.kw = kw;
      }
      

}
