package dev.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@ManyToOne
	@JoinColumn(name = "collegue_id")
	private Collegue annonceur;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	private Voiture voiture;
	private LocalDateTime dateTimeDepart;
	private Integer place;

	public Annonce() {
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
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

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
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

}
