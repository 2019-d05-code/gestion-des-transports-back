package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceDto;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.Vehicule;
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

	@Transactional
	public AnnonceDto creerAnnonce(AnnonceDto dto) throws EmptyRepositoryException {
		Long idAnnonceur = dto.getAnnonceurId();
		Collegue annonceur = collegueRepo.findById(idAnnonceur)
				.orElseThrow(() -> new UsernameNotFoundException("L'annonceur n'a pas été retrouvé"));
		Annonce annonceCree = new Annonce(idAnnonceur, dto.getAdressDepart(), dto.getAdressArrivee(), null, null,
				dto.getDateTimeDepart(), dto.getPlace());
		annonceRepo.save(annonceCree);
		List<Annonce> annonces = annonceur.getAnnonces();
		annonces.add(annonceCree);
		annonceur.setAnnnonces(annonces);

		// TODO: quand géolocalisation fonctionnelle => annonce et dto renvoyée
		// devront être valorisés (distance, durée)
		return dto;
	}

}
