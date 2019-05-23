package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.domain.Vehicule;
import dev.exception.BadArgumentsException;
import dev.exception.EmptyRepositoryException;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {

	@Autowired
	VehiculeRepo repo;

	
	public List<Vehicule> listerVehicules() throws EmptyRepositoryException {
		
		List<Vehicule> resultat = new ArrayList<>();
		
		if(repo.findAll().isEmpty() || repo.findAll() == null) {
			throw new EmptyRepositoryException("Il n'y a aucun véhicule enregistré dans la base de données");
		}else {
			for(Vehicule vehicule:repo.findAll()) {
				resultat.add(vehicule);
			}
			return resultat;
		}

		
	}
	
	
	public Vehicule ajouterVehicule(Vehicule vehicule) throws BadArgumentsException {
		
		
		for(Vehicule v:repo.findAll()) {
			if (v.getImmatriculation().equalsIgnoreCase(vehicule.getImmatriculation())) {
				throw new BadArgumentsException("Cette voiture est déjà enregistrée dans la base de données");
			}
		}
		if(vehicule.getMarque().isEmpty() || vehicule.getMarque() == null) {
			throw new BadArgumentsException("Le champ de la marque ne doit pas être vide");
		}else if(vehicule.getModele().isEmpty() || vehicule.getModele() == null) {
			throw new BadArgumentsException("Le champ du modèle ne doit pas être vide");
		}else if(vehicule.getImmatriculation().isEmpty() || vehicule.getImmatriculation() == null) {
			throw new BadArgumentsException("Le champ de l'immatriculation ne doit pas être vide");
		}else if(vehicule.getPhotoUrl().isEmpty() || vehicule.getPhotoUrl() == null) {
			throw new BadArgumentsException("Le champ photo ne doit pas être vide");
		}else if(!vehicule.getPhotoUrl().contains("http") || vehicule.getPhotoUrl().length() < 8) {
			throw new BadArgumentsException("Veuillez entrer un lien URL correct pour le champ photo (http://...)");
		}else if(vehicule.getNbPlaces() < 1 || vehicule.getNbPlaces() == null) {
			throw new BadArgumentsException("Veuillez entrer un nombre de places");
		}else {
		
			repo.save(vehicule);
			return vehicule;
			
		}
		
	}
	
	public void setRepo(VehiculeRepo repo) {
		this.repo = repo;
	}
	
}
