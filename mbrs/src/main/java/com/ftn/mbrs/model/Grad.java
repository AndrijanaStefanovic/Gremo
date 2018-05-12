//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: ejbclass.ftl
//Element modela: GremoNaElektriko::Grad

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
public class Grad implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String nazivGrada;
    

	public Grad() {}
	
	public Grad(String nazivGrada){
		this.nazivGrada = nazivGrada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getNazivGrada(){
           return nazivGrada;
      }
      
      public void setNazivGrada(String nazivGrada){
           this.nazivGrada = nazivGrada;
      }
      

}
