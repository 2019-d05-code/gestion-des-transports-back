package dev.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;
import dev.domain.Vehicule;
import dev.exception.ReservationInvalideException;
import dev.repository.ReservationRepository;
import dev.service.ReservationService;

public class ReservationServiceTest {
	

	@Test
	public void ajouterReserva() throws ReservationInvalideException{
		
		ReservationRepository reRepo = Mockito.mock(ReservationRepository.class); 
		
		ReservationService srv = new ReservationService(reRepo); 
		
		Reservation res = new Reservation(LocalDateTime.now(), LocalDateTime.now(),new Vehicule(1)); 
		
		srv.ajouterReservation(res); 
		
		Mockito.verify(reRepo).save(res); 
		
	}
	

	
	@Test(expected = ReservationInvalideException.class)
	public void ajouterReservationInvalide() throws ReservationInvalideException {
		
		ReservationRepository reRepo = Mockito.mock(ReservationRepository.class); 
		
		ReservationService srv = new ReservationService(reRepo); 
		
		Reservation res = new Reservation(null, null, new Vehicule(1)); 
		
		srv.ajouterReservation(res); 
		
		Mockito.verify(reRepo).save(res); 
		
	}
	

	
	@Test
	public void voirToutesLesReservations() {
		
		ReservationRepository reRepo = Mockito.mock(ReservationRepository.class);
		
		ReservationService srv = new ReservationService(reRepo); 
		
		List<Reservation> uneListeReservation = new ArrayList<>(); 
		Reservation reservation1 = new Reservation(LocalDateTime.of(2019, 11, 11, 15, 30), LocalDateTime.of(2019, 12, 12, 15, 30), new Vehicule(1));
		
		uneListeReservation.add(reservation1); 
		
		Mockito.when(reRepo.findAll()).thenReturn(uneListeReservation);
		
		List<ReservationDTO> resultats = srv.afficherToutesLesReservations();
		
		assertTrue(!resultats.isEmpty());
		
	}
	

	
	

}
