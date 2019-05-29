package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceDTO;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;
import dev.repository.VehiculeRepo;

@Service
public class AnnonceService {

	@Autowired
	AnnonceRepo annonceRepo;
	@Autowired
	CollegueRepo collegueRepo;
	@Autowired
	VehiculeRepo vehiculeRepo;

	public AnnonceService() {
	}

	public AnnonceService(AnnonceRepo annonceRepo, CollegueRepo collegueRepo) {
		this.annonceRepo = annonceRepo;
		this.collegueRepo = collegueRepo;
	}

	public AnnonceDTO creerAnnonce(AnnonceDTO dto) {
		String emailAnnonceur = dto.getAnnonceurEmail();
		Collegue annonceur = collegueRepo.findByEmail(emailAnnonceur)
				.orElseThrow(() -> new CollegueNonTrouveException("L'annonceur n'a pas été retrouvé"));
		Annonce annonceCree = new Annonce(annonceur, dto.getAdressDepart(), dto.getAdressArrivee(), null, null,
				dto.getDateTimeDepart(), dto.getImmatriculationVehicule(), dto.getMarque(), dto.getModele(),
				dto.getPlace());
		annonceRepo.save(annonceCree);

		// TODO: quand géolocalisation fonctionnelle => annonce et dto renvoyée
		// devront être valorisés (distance, durée)
		return dto;
	}
	

	
	

}
