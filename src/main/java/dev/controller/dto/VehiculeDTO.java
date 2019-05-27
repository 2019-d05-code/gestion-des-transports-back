package dev.controller.dto;

import dev.domain.CategorieVehicule;
import dev.domain.Vehicule;

public class VehiculeDTO {

	private int id;
	private String marque;
	private String modele;
	private String immatriculation;
	private CategorieVehicule categorie;
	private String photoUrl;
	private Integer nbPlaces;
	
	
	public VehiculeDTO() {
		super();
	}
	
	
	public VehiculeDTO(Vehicule vehicule) {
		super();
		this.id = vehicule.getId(); 
		this.marque = vehicule.getMarque();
		this.modele = vehicule.getModele();
		this.immatriculation = vehicule.getImmatriculation(); 
		this.categorie=vehicule.getCategorie(); 
		this.photoUrl = vehicule.getPhotoUrl(); 
		this.nbPlaces = vehicule.getNbPlaces(); 
	}


	public CategorieVehicule getCategorie() {
		return categorie;
	}


	public void setCategorie(CategorieVehicule categorie) {
		this.categorie = categorie;
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
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	
}
