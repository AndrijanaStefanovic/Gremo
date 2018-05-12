//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: ejbclass.ftl
//Element modela: GremoNaElektriko::ModelVozila

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
public class ModelVozila implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String nazivModelaVozila;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private TipPrikljucka tipPrikljucka;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private MarkaVozila markaVozila;
    

	public ModelVozila() {}
	
	public ModelVozila(String nazivModelaVozila, TipPrikljucka tipPrikljucka, MarkaVozila markaVozila){
		this.nazivModelaVozila = nazivModelaVozila;
		this.tipPrikljucka = tipPrikljucka;
		this.markaVozila = markaVozila;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getNazivModelaVozila(){
           return nazivModelaVozila;
      }
      
      public void setNazivModelaVozila(String nazivModelaVozila){
           this.nazivModelaVozila = nazivModelaVozila;
      }
      
      public TipPrikljucka getTipPrikljucka(){
           return tipPrikljucka;
      }
      
      public void setTipPrikljucka(TipPrikljucka tipPrikljucka){
           this.tipPrikljucka = tipPrikljucka;
      }
      
      public MarkaVozila getMarkaVozila(){
           return markaVozila;
      }
      
      public void setMarkaVozila(MarkaVozila markaVozila){
           this.markaVozila = markaVozila;
      }
      

}
