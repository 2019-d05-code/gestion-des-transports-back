package dev.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicule {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String modele;
	@Enumerated(EnumType.STRING)
	private CategorieVehicule categorie;
	private String immatriculation;
	private String photoUrl;
	private Integer nbPlaces;
	
	@OneToMany(mappedBy = "uneVoiture")
	List<Reservation> listeDeReservations; 
	
	public Vehicule(int id) {
		super();
		this.id = id;
	}

	public Vehicule() {}
	
	public Vehicule(String marque, String modele, Categorie categorie, String immatriculation) {
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

	public Vehicule(String marque, String modele, Categorie categorie, String immatriculation, String photoUrl) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.immatriculation = immatriculation;
		this.photoUrl = photoUrl;
	}
	

	public Vehicule(String marque, String modele, CategorieVehicule categorie, String immatriculation, String photoUrl, Integer nbPlaces) {
		super();
		this.marque = marque.toUpperCase();
		this.modele = modele.toLowerCase();
		this.categorie = categorie;
		this.immatriculation = immatriculation.toUpperCase();
		this.photoUrl = photoUrl;
		this.nbPlaces = nbPlaces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {

		this.marque = marque;

		this.marque = marque.toUpperCase();
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}


	public void setCategorie(String categorie) {
		this.modele = modele.toLowerCase();
	}

	public String getCategorieVehicule() {
		return categorie.toString();
	}

	public void setCategorieVehicule(CategorieVehicule categorie) {
		this.categorie = categorie;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {

		this.immatriculation = immatriculation.toUpperCase();
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;

}

	

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

}
