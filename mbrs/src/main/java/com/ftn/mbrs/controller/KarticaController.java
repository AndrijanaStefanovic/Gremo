//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: controller.ftl
//Element modela: GremoNaElektriko::Kartica

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

import com.ftn.mbrs.model.Kartica;
import com.ftn.mbrs.service.KarticaService;

@RestController
@RequestMapping("kartica")
public class KarticaController {

	@Autowired
	private KarticaService karticaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Kartica> save(@Valid @RequestBody Kartica kartica) {
		try
		{
			Kartica savedKartica = karticaService.save(kartica);
			return new ResponseEntity<Kartica>(savedKartica, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Kartica>(kartica, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Kartica> update(@Valid @RequestBody Kartica kartica) {
		try
		{
			Kartica updatedKartica = karticaService.update(kartica);
			return new ResponseEntity<Kartica>(updatedKartica, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Kartica>(kartica, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = karticaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Kartica> findOne(@PathVariable Long id) {
		try
		{
			Kartica kartica = karticaService.findOne(id);
			return new ResponseEntity<Kartica>(kartica, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Kartica>(new Kartica(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Kartica>> findAll() {
		try{
		List<Kartica> karticas = karticaService.findAll();
		return new ResponseEntity<List<Kartica>>(karticas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<Kartica>>(new ArrayList<Kartica>(), HttpStatus.FORBIDDEN);
		}
		
	}
}