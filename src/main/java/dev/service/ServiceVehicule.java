package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.exception.EmptyRepositoryException;
import dev.repository.VehiculeRepo;

@Service
public class ServiceVehicule {

	@Autowired
	VehiculeRepo repo;
	
	public List<Vehicule> listerVehicules() throws EmptyRepositoryException {
		
		List<Vehicule> resultat = new ArrayList<>();
		for(Vehicule vehicule:repo.findAll()) {
			resultat.add(vehicule);
		}
		
		if(resultat.isEmpty()) {
			throw new EmptyRepositoryException("Il n'y a aucun véhicule enregistré dans la base de données");
		}else {return resultat;}
	}
	
}
