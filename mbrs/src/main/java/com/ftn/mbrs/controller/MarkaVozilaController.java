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

import com.ftn.mbrs.model.MarkaVozila;
import com.ftn.mbrs.service.MarkaVozilaService;

@RestController
@RequestMapping("markaVozila")
public class MarkaVozilaController {

	@Autowired
	private MarkaVozilaService markaVozilaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MarkaVozila> save(@Valid @RequestBody MarkaVozila markaVozila) {
		try
		{
			MarkaVozila savedMarkaVozila = markaVozilaService.save(markaVozila);
			return new ResponseEntity<MarkaVozila>(savedMarkaVozila, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<MarkaVozila>(markaVozila, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<MarkaVozila> update(@Valid @RequestBody MarkaVozila markaVozila) {
		try
		{
			MarkaVozila updatedMarkaVozila = markaVozilaService.update(markaVozila);
			return new ResponseEntity<MarkaVozila>(updatedMarkaVozila, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<MarkaVozila>(markaVozila, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = markaVozilaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MarkaVozila> findOne(@PathVariable Long id) {
		try
		{
			MarkaVozila markaVozila = markaVozilaService.findOne(id);
			return new ResponseEntity<MarkaVozila>(markaVozila, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<MarkaVozila>(new MarkaVozila(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MarkaVozila>> findAll() {
		try{
		List<MarkaVozila> markaVozilas = markaVozilaService.findAll();
		return new ResponseEntity<List<MarkaVozila>>(markaVozilas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<MarkaVozila>>(new ArrayList<MarkaVozila>(), HttpStatus.FORBIDDEN);
		}
		
	}
}