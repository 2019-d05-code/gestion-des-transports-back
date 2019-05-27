package dev.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import dev.domain.CategorieVehicule;
import dev.domain.Vehicule;

import dev.exception.BadArgumentsException;
import dev.exception.VehiculeNonTrouverException;
import dev.repository.VehiculeRepo;
import dev.service.VehiculeService;

public class VehiculeServiceTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private VehiculeRepo mock;
	private VehiculeService service;

	@Before
	public void init() {
		service = new VehiculeService();
		mock = Mockito.mock(VehiculeRepo.class);
		service.setRepo(mock);
	}

	@Test
	public void testEnregistrerVehiculeAvecMarqueVide() throws BadArgumentsException {

		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ de la marque ne doit pas être vide");

		Vehicule vehicule = new Vehicule("", "806", CategorieVehicule.BERLINES_TAILLE_L, "CA-456-CA", "http://ghj.jpg",
				3);

		service.ajouterVehicule(vehicule);

	}

	@Test
	public void testEnregistrerVehiculeAvecModeleVide() throws BadArgumentsException {

		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ du modèle ne doit pas être vide");

		Vehicule vehicule = new Vehicule("Peugeot", "", CategorieVehicule.BERLINES_TAILLE_L, "CA-456-CA",
				"http://ghj.jpg", 3);

		service.ajouterVehicule(vehicule);

	}

	@Test
	public void testEnregistrerVehiculeAvecImmatriculationVide() throws BadArgumentsException {

		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ de l'immatriculation ne doit pas être vide");

		Vehicule vehicule = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "", "http://ghj.jpg",
				3);

		service.ajouterVehicule(vehicule);

	}

	@Test
	public void testEnregistrerVehiculeAvecPhotoUrlVide() throws BadArgumentsException {

		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Le champ photo ne doit pas être vide");

		Vehicule vehicule = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "CA-123-CA", "", 3);

		service.ajouterVehicule(vehicule);

	}

	@Test
	public void testEnregistrerVehiculeAvecNbPlacesVide() throws BadArgumentsException {

		exception.expect(BadArgumentsException.class);
		exception.expectMessage("Veuillez entrer un nombre de places");

		Vehicule vehicule = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "CA-123-CA",
				"http://hjkhjk.jpg", 0);

		service.ajouterVehicule(vehicule);

	}

	@Test
	public void testEnregistrerVehiculeOK() throws BadArgumentsException {

		Vehicule vehicule = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "CA-123-CA",
				"http://hjkhjk.jpg", 4);
		service.ajouterVehicule(vehicule);

		Mockito.verify(mock).save(vehicule);

	}

	@Test
	public void testtrouverVehiculeMatricule() throws VehiculeNonTrouverException {
		exception.expect(VehiculeNonTrouverException.class);
		exception.expectMessage("Le vehicule n'a pas été trouvé !");
		String immatriculation = "bhdbdsk";
		service.trouverVehiculeImmatriculation(immatriculation);
	}

}
