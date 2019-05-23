package dev.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceDto;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {

	@Autowired
	private CollegueRepo collegueRepo;

	public CollegueService() {
	}

	public CollegueService(CollegueRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

	public void sauvegarderCollegue(Collegue collegue) {
		collegueRepo.save(collegue);
	}

	@Transactional
	public void sauvegarderAnnonce(AnnonceDto annonceDto) {

		Collegue annonceur = collegueRepo.findById(annonceDto.getAnnonceurId())
				.orElseThrow(() -> new UsernameNotFoundException("L'annonceur n'a pas été retrouvé"));
		Annonce annonce = annonceDto.dtoToObject();

	}

}
