package dev.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.CollegueDTO;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.exception.CollegueDejaChauffeurException;
import dev.exception.CollegueNonTrouveException;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {


	public CollegueService(CollegueRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}


	@Autowired
	private CollegueRepo collegueRepo;

	public Collegue rechercherParMatricule(long matriculeRecherche) {
		return collegueRepo.findById(matriculeRecherche).orElseThrow(CollegueNonTrouveException::new);
	}

	@Transactional
	public CollegueDTO modifierRole(long matricule) throws CollegueDejaChauffeurException {
		Collegue collegue = rechercherParMatricule(matricule);
		List<RoleCollegue> roles = collegue.getRoles();
		for (RoleCollegue role : roles) {
			if (role.getRole().equals(Role.ROLE_CHAUFFEUR)) {
				throw new CollegueDejaChauffeurException();
			}
		}
		roles.add(new RoleCollegue(collegue, Role.ROLE_CHAUFFEUR));
		collegue.setRoles(roles);
		CollegueDTO collegueDTO = new CollegueDTO(collegue);
		return collegueDTO;
	}

	public List<CollegueDTO> recupColleChauffeur() {
		List<CollegueDTO> listChauffeur = new ArrayList<>();
		List<Collegue> listCollegue = collegueRepo.findAll();
		for (Collegue coll : listCollegue) {
			for (RoleCollegue role : coll.getRoles()) {
				if (role.getRole().equals(Role.ROLE_CHAUFFEUR)) {
					CollegueDTO collegueDTO = new CollegueDTO(coll);
					listChauffeur.add(collegueDTO);
				}
			}
		}
		return listChauffeur;
	}
}
