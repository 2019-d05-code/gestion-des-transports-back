package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

@Service
public class ServiceVehicule {

	@Autowired
	VehiculeRepo repo;
	
	public List<Vehicule> listerVehicules() throws RuntimeException {
		
		 List<Vehicule> veh = repo.findAll();
		
		 return veh; 
		
	}
}