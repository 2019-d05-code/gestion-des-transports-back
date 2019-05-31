package dev.service;

import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<AnnonceDTO> listerSesAnnonces(String emailAnnonceur) throws EmptyRepositoryException {
		List<Annonce> annonces = annonceRepo.findByAnnonceurEmail(emailAnnonceur)
				.orElseThrow(() -> new EmptyRepositoryException("Aucune annonce n'a été retrouvée"));
		return annonces.stream()
				.map(annonce -> new AnnonceDTO(annonce.getAnnonceur().getNom(), annonce.getAnnonceur().getPrenom(),
						annonce.getAnnonceur().getEmail(), annonce.getAdressDepart(), annonce.getAdressArrivee(),
						annonce.getDuree(), annonce.getDistance(), annonce.getDateTimeDepart(),
						annonce.getImmatriculationVehicule(), annonce.getMarque(), annonce.getModele(),
						annonce.getPlace()))
				.collect(Collectors.toList());
	}

	public List<AnnonceDTO> listerToutesAnnoncesEnCours() throws EmptyRepositoryException {
		List<Annonce> annoncesEnCours = annonceRepo.findAllCurrent(LocalDateTime.now())
				.orElseThrow(() -> new EmptyRepositoryException("Aucune annonce en cours n'a été retrouvée"));
		return annoncesEnCours.stream()
				.map(a -> new AnnonceDTO(a.getAnnonceur().getNom(), a.getAnnonceur().getPrenom(),
						a.getAnnonceur().getEmail(), a.getAdressDepart(), a.getAdressArrivee(), a.getDuree(),
						a.getDistance(), a.getDateTimeDepart(), a.getImmatriculationVehicule(), a.getMarque(),
						a.getModele(), a.getPlace()))
				.collect(Collectors.toList());
	}

}