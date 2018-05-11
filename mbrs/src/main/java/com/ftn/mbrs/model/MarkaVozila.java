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
public class MarkaVozila implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String nazivMarkeVozila;
    

	public MarkaVozila() {}
	
	public MarkaVozila(String nazivMarkeVozila){
		this.nazivMarkeVozila = nazivMarkeVozila;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getNazivMarkeVozila(){
           return nazivMarkeVozila;
      }
      
      public void setNazivMarkeVozila(String nazivMarkeVozila){
           this.nazivMarkeVozila = nazivMarkeVozila;
      }
      

}
