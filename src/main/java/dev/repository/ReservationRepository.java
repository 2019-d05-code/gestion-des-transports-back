package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {


	List<Reservation> findByVehiculeImmatriculation(String immatriculation);

}
