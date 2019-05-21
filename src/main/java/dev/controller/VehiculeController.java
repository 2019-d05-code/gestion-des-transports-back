package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Vehicule;
import dev.service.ServiceVehicule;

@RestController
@RequestMapping
public class VehiculeController {

	@Autowired
	ServiceVehicule service;
	
	@GetMapping(value = "/admin/vehicules")
	public List<Vehicule> listeVehicules() throws RuntimeException {
			return service.listerVehicules();
		
	}
	

	
}