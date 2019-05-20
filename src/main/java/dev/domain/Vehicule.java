package dev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
	public Vehicule() {}
	
	public Vehicule(String marque, String modele, String categorie, String immatriculation) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.immatriculation = immatriculation;
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
