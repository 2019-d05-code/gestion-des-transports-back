package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.domain.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule, Integer> {

	Optional<Vehicule> findByImmatriculation(String immatriculation);

}
