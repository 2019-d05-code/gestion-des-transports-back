package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.vm.CollegueVM;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
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
	public CollegueVM modifierRole(long matricule) {
		Collegue collegue = rechercherParMatricule(matricule);
		List<RoleCollegue> roles = collegue.getRoles();
		roles.add(new RoleCollegue(collegue, Role.ROLE_CHAUFFEUR));
		collegue.setRoles(roles);
		CollegueVM collegueVM = new CollegueVM(collegue);
		return collegueVM;
	}

	public List<CollegueVM> recupColleChauffeur() {
		List<CollegueVM> listChauffeur = new ArrayList<>();
		List<Collegue> listCollegue = collegueRepo.findAll();
		for (Collegue coll : listCollegue) {
			for (RoleCollegue role : coll.getRoles()) {
				if (role.getRole().equals(Role.ROLE_CHAUFFEUR)) {
					CollegueVM collegueVM = new CollegueVM(coll);
					listChauffeur.add(collegueVM);
				}
			}
		}
		return listChauffeur;
	}
}
