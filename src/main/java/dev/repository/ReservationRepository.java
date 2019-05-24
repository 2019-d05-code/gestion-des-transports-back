package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

	void save(ReservationDTO reservation);

	
	
}
