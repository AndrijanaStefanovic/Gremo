//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: controller.ftl
//Element modela: GremoNaElektriko::Stanica

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

import com.ftn.mbrs.model.Stanica;
import com.ftn.mbrs.service.StanicaService;

@RestController
@RequestMapping("stanica")
public class StanicaController {

	@Autowired
	private StanicaService stanicaService;
	
	@RequestMapping(value = "/{gradId}", method = RequestMethod.POST)
	public ResponseEntity<Stanica> save(@Valid @RequestBody Stanica stanica, @PathVariable Long gradId) {
		try
		{
			Stanica savedStanica = stanicaService.save(stanica, gradId);
			return new ResponseEntity<Stanica>(savedStanica, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Stanica>(stanica, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Stanica> update(@Valid @RequestBody Stanica stanica) {
		try
		{
			Stanica updatedStanica = stanicaService.update(stanica);
			return new ResponseEntity<Stanica>(updatedStanica, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Stanica>(stanica, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = stanicaService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Stanica> findOne(@PathVariable Long id) {
		try
		{
			Stanica stanica = stanicaService.findOne(id);
			return new ResponseEntity<Stanica>(stanica, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Stanica>(new Stanica(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Stanica>> findAll() {
		try{
		List<Stanica> stanicas = stanicaService.findAll();
		return new ResponseEntity<List<Stanica>>(stanicas, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<Stanica>>(new ArrayList<Stanica>(), HttpStatus.FORBIDDEN);
		}
		
	}
}