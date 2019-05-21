package dev;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Collegue;
import dev.domain.Reservation;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.repository.CollegueRepo;
import dev.repository.ReservationRepository;
import dev.repository.VehiculeRepo;

/**
 * Code de démarrage de l'application.
 * Insertion de jeux de données.
 */
@Component
public class StartupListener {

	@Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CollegueRepo collegueRepo;
    @Autowired
    private VehiculeRepo vehiculeRepo;
    @Autowired
    ReservationRepository reservationRepo; 

  

    @EventListener(ContextRefreshedEvent.class)
    public void onStart() {
       

        // Création de deux utilisateurs

        Collegue col1 = new Collegue();
        col1.setNom("Admin");
        col1.setPrenom("DEV");
        col1.setEmail("admin@dev.fr");
        col1.setMotDePasse(passwordEncoder.encode("superpass"));
        col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR), new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
        collegueRepo.save(col1);

        Collegue col2 = new Collegue();
        col2.setNom("User");
        col2.setPrenom("DEV");
        col2.setEmail("user@dev.fr");
        col2.setMotDePasse(passwordEncoder.encode("superpass"));
        col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
        collegueRepo.save(col2);
        
        Vehicule auto1 = new Vehicule("Opel", "kadettE", "Berlines Taille S", "JS-123-GH", "https://static3.car.gr/14598250_0_z.jpg");
        Vehicule auto2 = new Vehicule("Peugeot", "806", "Berlines Taille L", "CR-456-UU", "https://ouicar.s3-eu-west-1.amazonaws.com/uploads/product/16516/1651459.jpg");
        
        Reservation uneReservation = new Reservation(LocalDateTime.now(), LocalDateTime.now(), "https://static3.car.gr/14598250_0_z.jpg", "JS-123-GH", "Opel", "kadettE","Berlines Taille S"); 
        
        this.vehiculeRepo.save(auto1);
        this.vehiculeRepo.save(auto2);
        
    }

}
