package dev.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue annonceur;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	@OneToOne
	@JoinColumn(name = "voiture_id")
	private Vehicule voiture;
	private LocalDateTime dateTimeDepart;
	private Integer place;

	public Annonce() {
	}

	public Annonce(Collegue annonceur, String adressDepart, String adressArrivee, Duration duree, Float distance,
			Vehicule voiture, LocalDateTime dateTimeDepart, Integer place) {
		super();
		this.annonceur = annonceur;
		this.adressDepart = adressDepart;
		this.adressArrivee = adressArrivee;
		this.duree = duree;
		this.distance = distance;
		this.voiture = voiture;
		this.dateTimeDepart = dateTimeDepart;
		this.place = place;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Collegue getAnnonceur() {
		return annonceur;
	}

	public void setAnnonceur(Collegue annonceur) {
		this.annonceur = annonceur;
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

	public Vehicule getVoiture() {
		return voiture;
	}

	public void setVoiture(Vehicule voiture) {
		this.voiture = voiture;
	}

	public LocalDateTime getDateTimeDepart() {
		return dateTimeDepart;
	}

	public void setDateTimeDepart(LocalDateTime dateTimeDepart) {
		this.dateTimeDepart = dateTimeDepart;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressArrivee == null) ? 0 : adressArrivee.hashCode());
		result = prime * result + ((adressDepart == null) ? 0 : adressDepart.hashCode());
		result = prime * result + ((annonceur == null) ? 0 : annonceur.hashCode());
		result = prime * result + ((dateTimeDepart == null) ? 0 : dateTimeDepart.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((voiture == null) ? 0 : voiture.hashCode());
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
		Annonce other = (Annonce) obj;
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
		if (annonceur == null) {
			if (other.annonceur != null)
				return false;
		} else if (!annonceur.equals(other.annonceur))
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
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (voiture == null) {
			if (other.voiture != null)
				return false;
		} else if (!voiture.equals(other.voiture))
			return false;
		return true;
	}

}
