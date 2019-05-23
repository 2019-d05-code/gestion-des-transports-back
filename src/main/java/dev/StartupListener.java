package dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.CategorieVehicule;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.CollegueRepo;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private VehiculeRepo vehiculeRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, VehiculeRepo vehiculeRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setPermis("16546FEFGGG155");
		col1.setTelephone("0645582546");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");

		col2.setPermis("16546FEFGGG155");
		col2.setTelephone("0645583484");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

		Vehicule auto1 = new Vehicule("Opel", "kadettE", CategorieVehicule.BERLINES_TAILLE_S, "JS-123-GH",
				"https://static3.car.gr/14598250_0_z.jpg", 4);
		Vehicule auto2 = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "CR-456-UU",
				"https://ouicar.s3-eu-west-1.amazonaws.com/uploads/product/16516/1651459.jpg", 7);

		Collegue col3 = new Collegue();
		col3.setNom("User");
		col3.setPrenom("DEV");
		col3.setEmail("user@dev.fr");

		col3.setPermis("16546FEFGGG155");
		col3.setTelephone("0645583484");
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(Arrays.asList(new RoleCollegue(col3, Role.ROLE_CHAUFFEUR),
				new RoleCollegue(col3, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col3);

		this.vehiculeRepo.save(auto1);
		this.vehiculeRepo.save(auto2);
	}

}
