//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: controller.ftl
//Element modela: GremoNaElektriko::RadnoVreme

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

import com.ftn.mbrs.model.RadnoVreme;
import com.ftn.mbrs.service.RadnoVremeService;

@RestController
@RequestMapping("radnoVreme")
public class RadnoVremeController {

	@Autowired
	private RadnoVremeService radnoVremeService;
	
	@RequestMapping(value = "/{stanicaId}", method = RequestMethod.POST)
	public ResponseEntity<RadnoVreme> save(@Valid @RequestBody RadnoVreme radnoVreme, @PathVariable Long stanicaId) {
		try
		{
			RadnoVreme savedRadnoVreme = radnoVremeService.save(radnoVreme, stanicaId);
			return new ResponseEntity<RadnoVreme>(savedRadnoVreme, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<RadnoVreme>(radnoVreme, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<RadnoVreme> update(@Valid @RequestBody RadnoVreme radnoVreme) {
		try
		{
			RadnoVreme updatedRadnoVreme = radnoVremeService.update(radnoVreme);
			return new ResponseEntity<RadnoVreme>(updatedRadnoVreme, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<RadnoVreme>(radnoVreme, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = radnoVremeService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RadnoVreme> findOne(@PathVariable Long id) {
		try
		{
			RadnoVreme radnoVreme = radnoVremeService.findOne(id);
			return new ResponseEntity<RadnoVreme>(radnoVreme, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<RadnoVreme>(new RadnoVreme(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RadnoVreme>> findAll() {
		try{
		List<RadnoVreme> radnoVremes = radnoVremeService.findAll();
		return new ResponseEntity<List<RadnoVreme>>(radnoVremes, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<RadnoVreme>>(new ArrayList<RadnoVreme>(), HttpStatus.FORBIDDEN);
		}
		
	}
}