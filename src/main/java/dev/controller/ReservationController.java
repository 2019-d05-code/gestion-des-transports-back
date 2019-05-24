package dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;
import dev.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	private ReservationService res_ser; 
	
	//afficher toutes les réservations
	@GetMapping(value="/collaborateur/reservations/")
	public List<ReservationDTO> afficherReservation(){
		
		return res_ser.afficherToutesLesReservations(); 
	}
	
	
	//ajout d'une réservation 
	
	@PostMapping(value = "/collaborateur/reservations/creer")
	public Reservation create(@RequestBody Reservation reservation) throws Exception {

		Reservation nouvelle = res_ser.ajouterReservation(reservation);
		
		return nouvelle; 
	}
	
	
	
}
