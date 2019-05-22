import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import dev.domain.Reservation;
import dev.domain.ReservationService;
import dev.domain.Vehicule;
import dev.exception.ReservationInvalideException;
import dev.repository.ReservationRepository;

public class ReservationServiceTest {
	
	//le cas ok
	@Test
	public void ajouterReserva() throws Exception{
		
		ReservationRepository reRepo = Mockito.mock(ReservationRepository.class); 
		
		ReservationService srv = new ReservationService(reRepo); 
		
		Reservation res = new Reservation(new Vehicule(1),LocalDateTime.now(), LocalDateTime.now()); 
		
		srv.ajouterReservation(res); 
		
		Mockito.verify(reRepo).save(res); 
		
	}
	
	//le cas ko
	
	@Test(expected = ReservationInvalideException.class)
	public void ajouterReservationInvalide() throws Exception {
		
		ReservationRepository reRepo = Mockito.mock(ReservationRepository.class); 
		
		ReservationService srv = new ReservationService(reRepo); 
		
		Reservation res = new Reservation(new Vehicule(1),null, null ); 
		
		srv.ajouterReservation(res); 
		
		Mockito.verify(reRepo).save(res); 
		
	}
	
	

}
