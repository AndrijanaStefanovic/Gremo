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

import com.ftn.mbrs.model.StavkaCenovnika;
import com.ftn.mbrs.service.StavkaCenovnikaService;

@RestController
@RequestMapping("stavkaCenovnika")
public class StavkaCenovnikaController {

	@Autowired
	private StavkaCenovnikaService stavkaCenovnikaService;
	
	@RequestMapping(value = "/{tipPrikljuckaId}/{cenovnikId}", method = RequestMethod.POST)
	public ResponseEntity<StavkaCenovnika> save(@Valid @RequestBody StavkaCenovnika stavkaCenovnika, @PathVariable Long tipPrikljuckaId, @PathVariable Long cenovnikId) {
		try
		{
			StavkaCenovnika savedStavkaCenovnika = stavkaCenovnikaService.save(stavkaCenovnika, tipPrikljuckaId, cenovnikId);
			return new ResponseEntity<StavkaCenovnika>(savedStavkaCenovnika, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<StavkaCenovnika>(stavkaCenovnika, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<StavkaCenovnika> update(@Valid @RequestBody StavkaCenovnika stavkaCenovnika) {
		try
		{
			StavkaCenovnika updatedStavkaCenovnika = stavkaCenovnikaService.update(stavkaCenovnika);
			return new ResponseEntity<StavkaCenovnika>(updatedStavkaCenovnika, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<StavkaCenovnika>(stavkaCenovnika, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = stavkaCenovnikaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StavkaCenovnika> findOne(@PathVariable Long id) {
		try
		{
			StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.findOne(id);
			return new ResponseEntity<StavkaCenovnika>(stavkaCenovnika, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<StavkaCenovnika>(new StavkaCenovnika(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StavkaCenovnika>> findAll() {
		try{
		List<StavkaCenovnika> stavkaCenovnikas = stavkaCenovnikaService.findAll();
		return new ResponseEntity<List<StavkaCenovnika>>(stavkaCenovnikas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<StavkaCenovnika>>(new ArrayList<StavkaCenovnika>(), HttpStatus.FORBIDDEN);
		}
		
	}
}