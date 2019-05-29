package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;
import dev.exception.EmptyRepositoryException;
import dev.exception.ReservationInvalideException;
import dev.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	private ReservationService reservationServ; 
	
	//afficher toutes les réservations
	@GetMapping(value="/collaborateur/reservations")
	public List<ReservationDTO> afficherReservation(){
		
		return reservationServ.afficherToutesLesReservations(); 
	}
	
	
	//ajout d'une réservation 
	
	@PostMapping(value = "/collaborateur/reservations/creer")
	public Reservation create(@RequestBody Reservation reservation) throws ReservationInvalideException {

		Reservation nouvelle = reservationServ.ajouterReservation(reservation);
		
		return nouvelle; 
	}
	
	@GetMapping(value="/collaborateur/reservations/{immatriculation}")
	public ResponseEntity<?> afficherReservationsVehicule(@PathVariable String immatriculation) throws EmptyRepositoryException {
		
		return ResponseEntity.ok(reservationServ.afficherListeReservationVehicule(immatriculation));
		
	}
	
	@ExceptionHandler(value = { EmptyRepositoryException.class, ReservationInvalideException.class })
	public ResponseEntity<String> handleEmptyRepositoryException(Exception e) {

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
	}

	
	
	
}
