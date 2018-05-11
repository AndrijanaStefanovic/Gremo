//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: controller.ftl
//Element modela: GremoNaElektriko::Vozilo

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

import com.ftn.mbrs.model.Vozilo;
import com.ftn.mbrs.service.VoziloService;

@RestController
@RequestMapping("vozilo")
public class VoziloController {

	@Autowired
	private VoziloService voziloService;
	
	@RequestMapping(value = "/{modelVozilaId}/{karticaId}", method = RequestMethod.POST)
	public ResponseEntity<Vozilo> save(@Valid @RequestBody Vozilo vozilo, @PathVariable Long modelVozilaId, @PathVariable Long karticaId) {
		try
		{
			Vozilo savedVozilo = voziloService.save(vozilo, modelVozilaId, karticaId);
			return new ResponseEntity<Vozilo>(savedVozilo, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Vozilo>(vozilo, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Vozilo> update(@Valid @RequestBody Vozilo vozilo) {
		try
		{
			Vozilo updatedVozilo = voziloService.update(vozilo);
			return new ResponseEntity<Vozilo>(updatedVozilo, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Vozilo>(vozilo, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = voziloService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vozilo> findOne(@PathVariable Long id) {
		try
		{
			Vozilo vozilo = voziloService.findOne(id);
			return new ResponseEntity<Vozilo>(vozilo, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Vozilo>(new Vozilo(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vozilo>> findAll() {
		try{
		List<Vozilo> vozilos = voziloService.findAll();
		return new ResponseEntity<List<Vozilo>>(vozilos, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<Vozilo>>(new ArrayList<Vozilo>(), HttpStatus.FORBIDDEN);
		}
		
	}
}