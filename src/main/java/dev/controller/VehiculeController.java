package dev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Vehicule;
import dev.exception.BadArgumentsException;
import dev.exception.EmptyRepositoryException;
import dev.service.VehiculeService;

@RestController
@RequestMapping
public class VehiculeController {

	@Autowired
	VehiculeService service;
	
	@GetMapping(value = "/admin/vehicules")
	public ResponseEntity<?> listeVehicules() throws EmptyRepositoryException {
		
			return ResponseEntity.ok(service.listerVehicules());
		
	}
	
	@PostMapping(value = "/admin/vehicules")
	public ResponseEntity<?> enregistrerVehicule(@RequestBody Vehicule vehicule) throws BadArgumentsException {
		
		return ResponseEntity.ok(service.ajouterVehicule(vehicule));
		
	}
	
	@ExceptionHandler(value = {EmptyRepositoryException.class, BadArgumentsException.class})
	public ResponseEntity<String> handleEmptyRepositoryException(Exception e){
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
	}
	
	
}
