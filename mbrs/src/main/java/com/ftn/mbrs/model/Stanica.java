//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: ejbclass.ftl
//Element modela: GremoNaElektriko::Stanica

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
public class Stanica implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private String adresaStanice;
    
	@ManyToOne(fetch = FetchType.EAGER)
    private Grad grad;
    

	public Stanica() {}
	
	public Stanica(String adresaStanice, Grad grad){
		this.adresaStanice = adresaStanice;
		this.grad = grad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public String getAdresaStanice(){
           return adresaStanice;
      }
      
      public void setAdresaStanice(String adresaStanice){
           this.adresaStanice = adresaStanice;
      }
      
      public Grad getGrad(){
           return grad;
      }
      
      public void setGrad(Grad grad){
           this.grad = grad;
      }
      

}
