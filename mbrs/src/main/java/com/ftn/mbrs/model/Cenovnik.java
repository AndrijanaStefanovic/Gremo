//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: ejbclass.ftl
//Element modela: GremoNaElektriko::Cenovnik

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
public class Cenovnik implements Serializable {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
    private Date datum;
    

	public Cenovnik() {}
	
	public Cenovnik(Date datum){
		this.datum = datum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

      public Date getDatum(){
           return datum;
      }
      
      public void setDatum(Date datum){
           this.datum = datum;
      }
      

}
