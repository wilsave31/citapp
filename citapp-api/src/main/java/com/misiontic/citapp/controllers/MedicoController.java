package com.misiontic.citapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.citapp.entity.Medico;
import com.misiontic.citapp.services.MedicoService;



@RestController
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping(value="/medicos")  
	public ResponseEntity<List<Medico>>  findAll(){
		List<Medico> arregloMedicos = medicoService.findAll();
		return new ResponseEntity<List<Medico>>(arregloMedicos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/medicos/{medicoId}")
	public ResponseEntity<Medico> finById(@PathVariable("medicoId") Long medicoId){
		Medico objMedico = medicoService.finById(medicoId);
		return new ResponseEntity<Medico>(objMedico, HttpStatus.OK);
	}
	
	@PostMapping(value = "/medicos")
	public ResponseEntity<Medico> create(@RequestBody Medico medico) {
		Medico nuevoMedico = medicoService.create(medico);
		return new ResponseEntity<Medico>(nuevoMedico, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value= "/medicos")
	public  ResponseEntity<Medico> update(@RequestBody Medico medico){
		Medico objMedico = medicoService.update(medico);
				
		return new ResponseEntity<Medico>(objMedico, HttpStatus.OK);

	}
	
	@DeleteMapping(value= "/medicos/{medicoId}")
	public ResponseEntity<Medico> delete(@PathVariable("medicoId") Long medicoId) {
		 medicoService.delete(medicoId);
		 return new ResponseEntity<Medico>(HttpStatus.OK);
	}
	

}

