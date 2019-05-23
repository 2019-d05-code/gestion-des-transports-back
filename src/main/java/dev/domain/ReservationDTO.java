package dev.domain;

import java.time.LocalDateTime;

public class ReservationDTO {

	public Vehicule uneVoiture; 
	public LocalDateTime dateDeReservation; 
	public LocalDateTime dateDeRetour;
	
	public ReservationDTO(int i, LocalDateTime now, LocalDateTime now2, int j) {

	}
	
	public Vehicule getUneVoiture() {
		return uneVoiture;
	}
	public void setUneVoiture(Vehicule uneVoiture) {
		this.uneVoiture = uneVoiture;
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
	
	
	
}
