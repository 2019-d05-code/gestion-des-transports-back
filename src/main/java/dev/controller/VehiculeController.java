package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.exception.EmptyRepositoryException;
import dev.service.ServiceVehicule;

@RestController
@RequestMapping
public class VehiculeController {

	@Autowired
	ServiceVehicule service;
	
	@GetMapping(value = "/admin/vehicules")
	public ResponseEntity<?> listeVehicules() throws EmptyRepositoryException {
			return ResponseEntity.ok(service.listerVehicules());
		
	}
	
	@ExceptionHandler(value = {EmptyRepositoryException.class})
	public ResponseEntity<String> handleEmptyException(EmptyRepositoryException e){
		return ResponseEntity.status(404).body(e.getMessage());
	}
	
}
