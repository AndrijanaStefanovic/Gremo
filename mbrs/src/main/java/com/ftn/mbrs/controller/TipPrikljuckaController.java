//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: controller.ftl
//Element modela: GremoNaElektriko::TipPrikljucka

package com.ftn.mbrs.controller;

import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.mbrs.model.TipPrikljucka;
import com.ftn.mbrs.service.TipPrikljuckaService;

@RestController
@RequestMapping("tipPrikljucka")
public class TipPrikljuckaController {

	@Autowired
	private TipPrikljuckaService tipPrikljuckaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TipPrikljucka> save(@Valid @RequestBody TipPrikljucka tipPrikljucka) {
		try
		{
			TipPrikljucka savedTipPrikljucka = tipPrikljuckaService.save(tipPrikljucka);
			return new ResponseEntity<TipPrikljucka>(savedTipPrikljucka, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<TipPrikljucka>(tipPrikljucka, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<TipPrikljucka> update(@Valid @RequestBody TipPrikljucka tipPrikljucka) {
		try
		{
			TipPrikljucka updatedTipPrikljucka = tipPrikljuckaService.update(tipPrikljucka);
			return new ResponseEntity<TipPrikljucka>(updatedTipPrikljucka, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<TipPrikljucka>(tipPrikljucka, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = tipPrikljuckaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipPrikljucka> findOne(@PathVariable Long id) {
		try
		{
			TipPrikljucka tipPrikljucka = tipPrikljuckaService.findOne(id);
			return new ResponseEntity<TipPrikljucka>(tipPrikljucka, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<TipPrikljucka>(new TipPrikljucka(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipPrikljucka>> findAll() {
		try{
		List<TipPrikljucka> tipPrikljuckas = tipPrikljuckaService.findAll();
		return new ResponseEntity<List<TipPrikljucka>>(tipPrikljuckas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<TipPrikljucka>>(new ArrayList<TipPrikljucka>(), HttpStatus.FORBIDDEN);
		}
		
	}
}