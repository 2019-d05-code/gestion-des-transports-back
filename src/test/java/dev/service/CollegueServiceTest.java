package dev.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.controller.dto.ChauffeurDTO;
import dev.domain.Collegue;
import dev.exception.CollegueNonTrouveException;
import dev.repository.CollegueRepo;

public class CollegueServiceTest {

	CollegueRepo mockedRepo = Mockito.mock(CollegueRepo.class);
	private static final Logger LOG = LoggerFactory.getLogger(CollegueService.class);
	private Collegue collegue = new Collegue();
	private ChauffeurDTO chauffeurVM = new ChauffeurDTO();
	CollegueService collegueService;

	@Before
	public void init() {
		collegueService = new CollegueService(mockedRepo);
		chauffeurVM.setMatricule(1);
		chauffeurVM.setNom("Admin");
		chauffeurVM.setPrenom("DEV");
	}

	@Test(expected = CollegueNonTrouveException.class)
	public void modifierRole_KO_mauvais_matricule() {
		LOG.info("Losr d'une recherche d'un collegue avec un mauvais matricule");
		LOG.info("Alors une exception Collegue non trouvé est lancée");
		collegueService.modifierRole(1000);
	}
}
