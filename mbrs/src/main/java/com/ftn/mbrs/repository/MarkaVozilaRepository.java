//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: repository.ftl
//Element modela: GremoNaElektriko::MarkaVozila


package com.ftn.mbrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.mbrs.model.MarkaVozila;

public interface MarkaVozilaRepository extends JpaRepository<MarkaVozila, Long> {


}