package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Reservation;
import dev.domain.ReservationDTO;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

	void save(ReservationDTO reservation);

	
	
}
