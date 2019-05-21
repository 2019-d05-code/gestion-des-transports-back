package dev.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marque;
	private String modele;
	private String categorie;
	private String immatriculation;
	private String photoUrl;
	
	@OneToMany(mappedBy = "uneVoiture")
	List<Reservation> listeDeReservations; 
	
	
	//me permet de récupérer la voiture dans ma classe réservation
	public Vehicule(Integer id) {
		super();
		this.id = id;
	}

	public Vehicule() {}
	
	public Vehicule(String marque, String modele, String categorie, String immatriculation) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.immatriculation = immatriculation;
	}


	public List<Reservation> getListeDeReservations() {
		return listeDeReservations;
	}

	public void setListeDeReservations(List<Reservation> listeDeReservations) {
		this.listeDeReservations = listeDeReservations;
	}

	public Vehicule(String marque, String modele, String categorie, String immatriculation, String photoUrl) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.immatriculation = immatriculation;
		this.photoUrl = photoUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
}
}
