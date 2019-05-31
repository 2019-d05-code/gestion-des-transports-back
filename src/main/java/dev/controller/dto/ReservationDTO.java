package dev.controller.dto;

import java.time.LocalDateTime;

import dev.domain.Reservation;

public class ReservationDTO {

	private int id; 
	private LocalDateTime dateDeReservation; 
	private LocalDateTime dateDeRetour;
	private VehiculeDTO uneVoiture;
	private ChauffeurDTO unChauffeur; 
	private boolean avecOuSansChauffeur;
	
	
	
	public ReservationDTO(Reservation reservation) {
		this.id=reservation.getUneVoiture().getId(); 
		this.dateDeReservation = reservation.getDateDeReservation(); 
		this.dateDeRetour = reservation.getDateDeRetour();
		this.avecOuSansChauffeur=reservation.isAvecOuSansChauffeur(); 
		this.uneVoiture = new VehiculeDTO();
		this.uneVoiture.setImmatriculation(reservation.getUneVoiture().getImmatriculation());
		this.uneVoiture.setMarque(reservation.getUneVoiture().getMarque());
		this.uneVoiture.setModele(reservation.getUneVoiture().getModele());
		if(reservation.getUnChauffeur() != null) {
			this.unChauffeur = new ChauffeurDTO(); 
			this.unChauffeur.setNom(reservation.getUnChauffeur().getNom());
			this.unChauffeur.setPrenom(reservation.getUnChauffeur().getPrenom());
			
		}
		
		this.uneVoiture.setNbPlaces(reservation.getUneVoiture().getNbPlaces());
		this.uneVoiture.setPhotoUrl(reservation.getUneVoiture().getPhotoUrl());
		this.uneVoiture.setCategorie(reservation.getUneVoiture().getCategorie());
		this.uneVoiture.setStatutVehicule(reservation.getUneVoiture().getStatutVehicule());

		}
	

	public ReservationDTO() {
		// TODO Auto-generated constructor stub
	}


	public ChauffeurDTO getUnChauffeur() {
		return unChauffeur;
	}


	public void setUnChauffeur(ChauffeurDTO unChauffeur) {
		this.unChauffeur = unChauffeur;
	}


	public boolean isAvecOuSansChauffeur() {
		return avecOuSansChauffeur;
	}


	public void setAvecOuSansChauffeur(boolean avecOuSansChauffeur) {
		this.avecOuSansChauffeur = avecOuSansChauffeur;
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
