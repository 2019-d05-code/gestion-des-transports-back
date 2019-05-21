package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;

@Service
public class AnnonceService {

	@Autowired
	AnnonceRepo annonceRepo;
	@Autowired
	CollegueRepo collegueRepo;

	public AnnonceService() {
	}

	public AnnonceService(AnnonceRepo annonceRepo, CollegueRepo collegueRepo) {
		this.annonceRepo = annonceRepo;
		this.collegueRepo = collegueRepo;
	}

	@Transactional
	public Annonce creerAnnonce(Annonce annonce) {
		Long idAnnonceur = annonce.getAnnonceur().getId();
		Collegue annonceur = collegueRepo.findById(idAnnonceur).orElseThrow(() -> new UsernameNotFoundException(
				"L'annonceur n°" + idAnnonceur + " n'a pas été retrouvé"));
		List<Annonce> annonces = annonceur.getAnnonces();
		annonces.add(annonce);
		annonceur.setAnnnonces(annonces);
		annonce.setAnnonceur(annonceur);
		return annonceRepo.save(annonce);
	}

}
