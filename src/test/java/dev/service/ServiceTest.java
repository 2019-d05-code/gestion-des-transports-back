package dev.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import dev.domain.Annonce;
import dev.domain.Collegue;

public class ServiceTest {
	
	private CollegueService collegueService;

	@BeforeClass
	public void init() {
		collegueService = new CollegueService();
	}
	
	@Before
	public void setUp() {

		Collegue collegue = new Collegue();
        collegueService.sauvegarderCollegue(collegue);
	}
	
	@Test
	@Ignore("Pas encore implemente")
	public void testCreerAnnonceOK() {
		Annonce annonce = new Annonce();
		collegueService.creerAnnonce(annonce);
	}

}
