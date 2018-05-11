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

import com.ftn.mbrs.model.ModelVozila;
import com.ftn.mbrs.service.ModelVozilaService;

@RestController
@RequestMapping("modelVozila")
public class ModelVozilaController {

	@Autowired
	private ModelVozilaService modelVozilaService;
	
	@RequestMapping(value = "/{tipPrikljuckaId}/{markaVozilaId}", method = RequestMethod.POST)
	public ResponseEntity<ModelVozila> save(@Valid @RequestBody ModelVozila modelVozila, @PathVariable Long tipPrikljuckaId, @PathVariable Long markaVozilaId) {
		try
		{
			ModelVozila savedModelVozila = modelVozilaService.save(modelVozila, tipPrikljuckaId, markaVozilaId);
			return new ResponseEntity<ModelVozila>(savedModelVozila, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<ModelVozila>(modelVozila, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ModelVozila> update(@Valid @RequestBody ModelVozila modelVozila) {
		try
		{
			ModelVozila updatedModelVozila = modelVozilaService.update(modelVozila);
			return new ResponseEntity<ModelVozila>(updatedModelVozila, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<ModelVozila>(modelVozila, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = modelVozilaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ModelVozila> findOne(@PathVariable Long id) {
		try
		{
			ModelVozila modelVozila = modelVozilaService.findOne(id);
			return new ResponseEntity<ModelVozila>(modelVozila, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<ModelVozila>(new ModelVozila(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ModelVozila>> findAll() {
		try{
		List<ModelVozila> modelVozilas = modelVozilaService.findAll();
		return new ResponseEntity<List<ModelVozila>>(modelVozilas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<ModelVozila>>(new ArrayList<ModelVozila>(), HttpStatus.FORBIDDEN);
		}
		
	}
}