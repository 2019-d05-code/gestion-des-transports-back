package dev.domain;

import java.time.LocalDateTime;

public class ReservationDTO {

	public int id; 
	public LocalDateTime dateDeReservation; 
	public LocalDateTime dateDeRetour;
	public VehiculeDTO uneVoiture;
	
	
	
	public ReservationDTO(Reservation reservation) {
		this.id=reservation.getUneVoiture().getId(); 
		this.dateDeReservation = reservation.getDateDeReservation(); 
		this.dateDeRetour = reservation.getDateDeRetour();
		this.uneVoiture = new VehiculeDTO();
		this.uneVoiture.setImmatriculation(reservation.getUneVoiture().getImmatriculation());
		this.uneVoiture.setMarque(reservation.getUneVoiture().getMarque());
		this.uneVoiture.setModele(reservation.getUneVoiture().getModele());
		
		}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDateDeReservation() {
		return dateDeReservation;
	}
	public void setDateDeReservation(LocalDateTime dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
	}
	public LocalDateTime getDateDeRetour() {
		return dateDeRetour;
	}
	public void setDateDeRetour(LocalDateTime dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}



	public VehiculeDTO getUneVoiture() {
		return uneVoiture;
	}



	public void setUneVoiture(VehiculeDTO uneVoiture) {
		this.uneVoiture = uneVoiture;
	}
 
	
	
	
	
}
