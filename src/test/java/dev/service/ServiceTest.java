package dev.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dev.controller.dto.AnnonceDto;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.exception.EmptyRepositoryException;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;

//TODO: Quand Geolocation OK => Verifier valorisations
public class ServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	private CollegueRepo collegueRepo;
	private AnnonceService annonceService;
	private AnnonceRepo annonceRepo;
	private Collegue utilisateur;
	private Collegue admin;
	private Annonce annonce;
	private AnnonceDto annonceDto;

	@Before
	public void setUp() {
		collegueRepo = Mockito.mock(CollegueRepo.class);
		annonceRepo = Mockito.mock(AnnonceRepo.class);
		annonceService = new AnnonceService(annonceRepo, collegueRepo);

		utilisateur = new Collegue("nomU", "prenomU", "password", "utilisateur@utilisateur.com", new ArrayList<>(),
				new ArrayList<>());
		utilisateur.setId(42L);
		utilisateur.getRoles().add(new RoleCollegue(utilisateur, Role.ROLE_UTILISATEUR));

		admin = new Collegue("nomA", "prenomA", "12345", "admin@admin.com", new ArrayList<>(), new ArrayList<>());
		admin.setId(43L);
		admin.getRoles().add(new RoleCollegue(utilisateur, Role.ROLE_ADMINISTRATEUR));

		annonce = new Annonce(null, "42 rue des utilisateurs", "10 rue des arrivee", null, null,
				LocalDateTime.of(2019, 01, 01, 14, 00), 3);
		annonce.setId(42L);
		annonceDto = new AnnonceDto(annonce.getId(), utilisateur, "42 rue des utilisateurs", "10 rue des arrivee", null,
				null, LocalDateTime.of(2019, 1, 1, 14, 0), 3);
	}

	@Test
	public void testCreerAnnonceOK() throws EmptyRepositoryException {

		annonce.setAnnonceur(utilisateur);
		Mockito.when(collegueRepo.findById(annonce.getAnnonceur().getId())).thenReturn(Optional.of(utilisateur));
		Mockito.when(annonceRepo.save(annonce)).thenReturn(annonce);

		AnnonceDto actual = annonceService.creerAnnonce(annonceDto);
		AnnonceDto expected = new AnnonceDto(annonce.getId(), utilisateur, "42 rue des utilisateurs",
				"10 rue des arrivee", null, null, LocalDateTime.of(2019, 01, 01, 14, 00), 3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCreerAnnonceValoriseLesAnnoncesDuCollegueOK() throws EmptyRepositoryException {

		annonce.setAnnonceur(utilisateur);
		Mockito.when(collegueRepo.findById(annonce.getAnnonceur().getId())).thenReturn(Optional.of(utilisateur));
		Mockito.when(annonceRepo.save(annonce)).thenReturn(annonce);

		annonceService.creerAnnonce(annonceDto);
		List<Annonce> actual = utilisateur.getAnnonces();
		List<Annonce> expected = new ArrayList<>();
		expected.add(annonce);
		Assert.assertTrue(actual.contains(annonce));
	}

	@Test
	public void testCreerAnnonceKOCarAnnonceurNexistePas() throws EmptyRepositoryException {
		expectedException.expect(UsernameNotFoundException.class);
		Collegue annonceur = new Collegue();
		annonceur.setId(-666L);
		annonce.setAnnonceur(annonceur);

		annonceService.creerAnnonce(annonceDto);

		expectedException.expect(UsernameNotFoundException.class);
		expectedException.expectMessage("L'annonceur n'a pas été retrouvé");
	}

}
