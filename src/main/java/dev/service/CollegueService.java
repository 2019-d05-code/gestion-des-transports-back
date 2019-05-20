package dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dev.domain.Collegue;
import dev.domain.Role;
import dev.exception.CollegueNonTrouveException;
import dev.repository.CollegueRepo;

public class CollegueService {

	@Autowired
	CollegueRepo collegueRepo;

	public Collegue rechercherParMatricule(long matriculeRecherche) throws CollegueNonTrouveException {
		Optional<Collegue> optColl = collegueRepo.findById(matriculeRecherche);
		if (optColl.isPresent()) {
			return optColl.get();
		} else {
			throw new CollegueNonTrouveException();
		}
	}

	public Collegue modifierRole(Collegue collegue) {
		List roles = collegue.getRoles();
		roles.add(Role.ROLE_ADMINISTRATEUR);
		collegue.setRoles(roles);
		return collegue;
	}
}
