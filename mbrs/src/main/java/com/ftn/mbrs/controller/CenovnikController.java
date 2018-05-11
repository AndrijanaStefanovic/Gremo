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

import com.ftn.mbrs.model.Cenovnik;
import com.ftn.mbrs.service.CenovnikService;

@RestController
@RequestMapping("cenovnik")
public class CenovnikController {

	@Autowired
	private CenovnikService cenovnikService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cenovnik> save(@Valid @RequestBody Cenovnik cenovnik) {
		try
		{
			Cenovnik savedCenovnik = cenovnikService.save(cenovnik);
			return new ResponseEntity<Cenovnik>(savedCenovnik, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Cenovnik>(cenovnik, HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Cenovnik> update(@Valid @RequestBody Cenovnik cenovnik) {
		try
		{
			Cenovnik updatedCenovnik = cenovnikService.update(cenovnik);
			return new ResponseEntity<Cenovnik>(updatedCenovnik, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Cenovnik>(cenovnik, HttpStatus.FORBIDDEN);
		}
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/plain")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try
		{
			String response = cenovnikService.delete(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(id.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cenovnik> findOne(@PathVariable Long id) {
		try
		{
			Cenovnik cenovnik = cenovnikService.findOne(id);
			return new ResponseEntity<Cenovnik>(cenovnik, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Cenovnik>(new Cenovnik(), HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cenovnik>> findAll() {
		try{
		List<Cenovnik> cenovniks = cenovnikService.findAll();
		return new ResponseEntity<List<Cenovnik>>(cenovniks, HttpStatus.OK);
		}
		catch(Exception e)
		{		
		return new ResponseEntity<List<Cenovnik>>(new ArrayList<Cenovnik>(), HttpStatus.FORBIDDEN);
		}
		
	}
}