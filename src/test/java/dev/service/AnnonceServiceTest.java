package dev.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dev.controller.dto.AnnonceDTO;
import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;

//TODO: Quand Geolocation OK => Verifier valorisations
public class AnnonceServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	private CollegueRepo collegueRepo;
	private AnnonceService annonceService;
	private AnnonceRepo annonceRepo;
	private Collegue utilisateur;
	private Collegue admin;
	private Annonce annonce;
	private AnnonceDTO annonceDto;

	@Before
	public void setUp() {
		collegueRepo = Mockito.mock(CollegueRepo.class);
		annonceRepo = Mockito.mock(AnnonceRepo.class);
		annonceService = new AnnonceService(annonceRepo, collegueRepo);

		utilisateur = new Collegue("nomU", "prenomU", "password", "utilisateur@utilisateur.com", new ArrayList<>(),
				new ArrayList<>(), "https://vignette.wikia.nocookie.net/kaamelott-officiel/images/5/55/Visage_Yvain2.jpg/revision/latest?cb=20150102045252&path-prefix=fr");

		utilisateur.setId(42L);
		utilisateur.getRoles().add(new RoleCollegue(utilisateur, Role.ROLE_UTILISATEUR));

		admin = new Collegue("nomA", "prenomA", "12345", "admin@admin.com", new ArrayList<>(), new ArrayList<>(), "https://vignette.wikia.nocookie.net/kaamelott-officiel/images/5/55/Visage_Yvain2.jpg/revision/latest?cb=20150102045252&path-prefix=fr");
		admin.setId(43L);
		admin.getRoles().add(new RoleCollegue(utilisateur, Role.ROLE_ADMINISTRATEUR));

		annonce = new Annonce(null, "42 rue des utilisateurs", "10 rue des arrivee", null, null,
				LocalDateTime.of(2019, 01, 01, 14, 00), "FF-666-FF", "Peugeot", "Twingo", 3);
		annonce.setId(42L);
		annonceDto = new AnnonceDTO(utilisateur.getEmail(), "42 rue des utilisateurs", "10 rue des arrivee", null, null,
				LocalDateTime.of(2019, 1, 1, 14, 0), "FF-666-FF", "Peugeot", "Twingo", 3);
	}

	@Test
	public void test_creer_annonce_OK() throws EmptyRepositoryException {

		annonce.setAnnonceur(utilisateur);
		Mockito.when(collegueRepo.findByEmail(annonce.getAnnonceur().getEmail())).thenReturn(Optional.of(utilisateur));
		Mockito.when(annonceRepo.save(annonce)).thenReturn(annonce);

		AnnonceDTO actual = annonceService.creerAnnonce(annonceDto);
		AnnonceDTO expected = new AnnonceDTO(utilisateur.getEmail(), "42 rue des utilisateurs", "10 rue des arrivee",
				null, null, LocalDateTime.of(2019, 01, 01, 14, 00), "FF-666-FF", "Peugeot", "Twingo", 3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_creer_annonce_KO_annonceur_nexiste_pas() throws EmptyRepositoryException {
		expectedException.expect(CollegueNonTrouveException.class);
		Collegue annonceur = new Collegue();
		annonceur.setId(-666L);
		annonce.setAnnonceur(annonceur);

		annonceService.creerAnnonce(annonceDto);

		expectedException.expect(UsernameNotFoundException.class);
		expectedException.expectMessage("L'annonceur n'a pas été retrouvé");
	}

	@Test
	public void test_lister_ses_annonces_OK() throws EmptyRepositoryException {

		String emailAnnonceur = annonceDto.getAnnonceurEmail();
		Annonce annonceALister = annonceDto.dtoToObject();
		annonceALister.setAnnonceur(utilisateur);

		Mockito.when(annonceRepo.findByAnnonceurEmail(emailAnnonceur))
				.thenReturn(Optional.of(Arrays.asList(annonceALister)));
		List<AnnonceDTO> actual = annonceService.listerSesAnnonces(emailAnnonceur);
		List<AnnonceDTO> expected = Arrays.asList(annonceDto);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_lister_ses_annonces_KO_car_aucune_annonce_de_ce_collegue() throws EmptyRepositoryException {

		expectedException.expect(EmptyRepositoryException.class);
		expectedException.expectMessage("Aucune annonce n'a été retrouvée");

		String emailAnnonceur = annonceDto.getAnnonceurEmail();
		Annonce annonceALister = annonceDto.dtoToObject();
		annonceALister.setAnnonceur(utilisateur);

		List<AnnonceDTO> actual = annonceService.listerSesAnnonces(emailAnnonceur);
		List<AnnonceDTO> expected = Arrays.asList(annonceDto);

		Assert.assertEquals(expected, actual);
	}

}