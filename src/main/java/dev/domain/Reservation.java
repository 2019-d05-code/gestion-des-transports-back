package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(name = "dateDeReservation")
	private LocalDateTime dateDeReservation; 
	@Column(name = "dateDeRetour")
	private LocalDateTime dateDeRetour; 
	@Column(name = "photoUrl")
	private String photoUrl; 
	@Column(name = "immatriculation")
	private String immatriculation; 
	@Column(name = "marque")
	private String marque; 
	@Column(name = "modele")
	private String modele; 
	@Column(name = "categorie")
	private String categorie;
	
	public Reservation() {
		super();	
	}

	public Reservation(int id, LocalDateTime dateDeReservation, LocalDateTime dateDeRetour, String photoUrl,
			String immatriculation, String marque, String modele, String categorie) {
		super();
		this.id = id;
		this.dateDeReservation = dateDeReservation;
		this.dateDeRetour = dateDeRetour;
		this.photoUrl = photoUrl;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
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
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	} 
	
	
	
	
	

}
