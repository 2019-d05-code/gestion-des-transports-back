package dev.controller.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.domain.Annonce;

public class AnnonceDTO {

	private String annonceurNom;
	private String annonceurPrenom;
	private String annonceurEmail;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	private LocalDateTime dateTimeDepart;
	private String immatriculationVehicule;
	private String marque;
	private String modele;
	private Integer place;
	

	public AnnonceDTO() {
	}

	public AnnonceDTO(String nom, String prenom, String annonceurEmail, String adressDepart, String adressArrivee, Duration duree,
			Float distance, LocalDateTime dateTimeDepart, String immatriculationVehicule, String marque, String modele,
			Integer place) {
		super();
		this.annonceurNom = nom;
		this.annonceurPrenom = prenom;
		this.annonceurEmail = annonceurEmail;
		this.adressDepart = adressDepart;
		this.adressArrivee = adressArrivee;
		this.duree = duree;
		this.distance = distance;
		this.dateTimeDepart = dateTimeDepart;
		this.immatriculationVehicule = immatriculationVehicule;
		this.marque = marque;
		this.modele = modele;
		this.place = place;
	}
	
	

	public String getAnnonceurNom() {
		return annonceurNom;
	}

	public void setAnnonceurNom(String annonceurNom) {
		this.annonceurNom = annonceurNom;
	}
	
	public String getAnnonceurPrenom() {
		return annonceurPrenom;
	}

	public void setAnnonceurPrenom(String annonceurPrenom) {
		this.annonceurPrenom = annonceurPrenom;
	}

	public String getAnnonceurEmail() {
		return annonceurEmail;
	}

	public void setAnnonceurEmail(String annonceurEmail) {
		this.annonceurEmail = annonceurEmail;
	}

	public String getAdressDepart() {
		return adressDepart;
	}

	public void setAdressDepart(String adressDepart) {
		this.adressDepart = adressDepart;
	}

	public String getAdressArrivee() {
		return adressArrivee;
	}

	public void setAdressArrivee(String adressArrivee) {
		this.adressArrivee = adressArrivee;
	}

	public Duration getDuree() {
		return duree;
	}

	public void setDuree(Duration duree) {
		this.duree = duree;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public LocalDateTime getDateTimeDepart() {
		return dateTimeDepart;
	}

	public void setDateTimeDepart(LocalDateTime dateTimeDepart) {
		this.dateTimeDepart = dateTimeDepart;
	}

	public String getImmatriculationVehicule() {
		return immatriculationVehicule;
	}

	public void setImmatriculationVehicule(String immatriculationVehicule) {
		this.immatriculationVehicule = immatriculationVehicule;
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

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Annonce dtoToObject() {
		Annonce annonce = new Annonce(null, adressDepart, adressArrivee, duree, distance, dateTimeDepart,
				immatriculationVehicule, marque, modele, place);
		return annonce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressArrivee == null) ? 0 : adressArrivee.hashCode());
		result = prime * result + ((adressDepart == null) ? 0 : adressDepart.hashCode());
		result = prime * result + ((annonceurEmail == null) ? 0 : annonceurEmail.hashCode());
		result = prime * result + ((annonceurNom == null) ? 0 : annonceurNom.hashCode());
		result = prime * result + ((annonceurPrenom == null) ? 0 : annonceurPrenom.hashCode());
		result = prime * result + ((dateTimeDepart == null) ? 0 : dateTimeDepart.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
		result = prime * result + ((immatriculationVehicule == null) ? 0 : immatriculationVehicule.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		result = prime * result + ((modele == null) ? 0 : modele.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnnonceDTO other = (AnnonceDTO) obj;
		if (adressArrivee == null) {
			if (other.adressArrivee != null)
				return false;
		} else if (!adressArrivee.equals(other.adressArrivee))
			return false;
		if (adressDepart == null) {
			if (other.adressDepart != null)
				return false;
		} else if (!adressDepart.equals(other.adressDepart))
			return false;
		if (annonceurEmail == null) {
			if (other.annonceurEmail != null)
				return false;
		} else if (!annonceurEmail.equals(other.annonceurEmail))
			return false;
		if (annonceurNom == null) {
			if (other.annonceurNom != null)
				return false;
		} else if (!annonceurNom.equals(other.annonceurNom))
			return false;
		if (annonceurPrenom == null) {
			if (other.annonceurPrenom != null)
				return false;
		} else if (!annonceurPrenom.equals(other.annonceurPrenom))
			return false;
		if (dateTimeDepart == null) {
			if (other.dateTimeDepart != null)
				return false;
		} else if (!dateTimeDepart.equals(other.dateTimeDepart))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (duree == null) {
			if (other.duree != null)
				return false;
		} else if (!duree.equals(other.duree))
			return false;
		if (immatriculationVehicule == null) {
			if (other.immatriculationVehicule != null)
				return false;
		} else if (!immatriculationVehicule.equals(other.immatriculationVehicule))
			return false;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		if (modele == null) {
			if (other.modele != null)
				return false;
		} else if (!modele.equals(other.modele))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	

}