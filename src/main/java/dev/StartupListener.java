package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.CategorieVehicule;
import dev.domain.Collegue;
import dev.domain.Reservation;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.StatutVehicule;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.CollegueRepo;
import dev.repository.ReservationRepository;
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
	private ReservationRepository reservationRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, VehiculeRepo vehiculeRepo,
			ReservationRepository reservationRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.reservationRepo = reservationRepo;
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
				"https://static3.car.gr/14598250_0_z.jpg", 4, StatutVehicule.EN_SERVICE);
		Vehicule auto2 = new Vehicule("Peugeot", "806", CategorieVehicule.BERLINES_TAILLE_L, "CR-456-UU",
				"https://ouicar.s3-eu-west-1.amazonaws.com/uploads/product/16516/1651459.jpg", 7, StatutVehicule.HORS_SERVICE);

		Collegue col3 = new Collegue();
		col3.setNom("Chauffeur");
		col3.setPrenom("CHAUFF");
		col3.setEmail("chauffeur@dev.fr");

		col3.setPermis("16546FEFGGG666");
		col3.setTelephone("0633445566");
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(Arrays.asList(new RoleCollegue(col3, Role.ROLE_CHAUFFEUR),
				new RoleCollegue(col3, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col3);

		this.vehiculeRepo.save(auto1);
		this.vehiculeRepo.save(auto2);
		

		Reservation uneReservation = new Reservation(LocalDateTime.now(), LocalDateTime.now(),new Vehicule(1),col3, true); 
		Reservation uneReservation2 = new Reservation(LocalDateTime.now(), LocalDateTime.now(),new Vehicule(2), null, false); 
		Reservation uneReservation3 = new Reservation(LocalDateTime.now(), LocalDateTime.of(2019, 06, 11, 15, 30),new Vehicule(1),null, true); 
		this.reservationRepo.save(uneReservation);
		this.reservationRepo.save(uneReservation2);
		this.reservationRepo.save(uneReservation3); 
		

		
	}


    }

