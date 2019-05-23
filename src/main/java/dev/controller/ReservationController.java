package dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Reservation;
import dev.domain.ReservationDTO;
import dev.domain.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	private ReservationService res_ser; 
	
	//ajout d'une réservation 
	
	@PostMapping(value = "/collaborateur/reservations/creer")
	public Reservation create(@RequestBody Reservation reservation) throws Exception {

		Reservation nouvelle = res_ser.ajouterReservation(reservation);
		
		return nouvelle; 
	}
	
	
	
}
