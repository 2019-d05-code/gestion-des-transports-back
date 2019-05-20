package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {

	@Autowired
	private CollegueRepo collegueRepo;

	public CollegueService() {
	}
	
	@Transactional
	public void sauvegarderCollegue(Collegue collegue) {
		collegueRepo.save(collegue);
	}

	@Transactional
	public void creerAnnonce(Annonce annonce) {
		Collegue annonceur = collegueRepo.findById(annonce.getAnnonceur().getId())
				.orElseThrow(() -> new UsernameNotFoundException("L'annonceur n'a pas été retrouvé"));
		List<Annonce> annonces = annonceur.getAnnonces();
		annonces.add(annonce);
		annonceur.setAnnnonces(annonces);
	}
	
	

}
