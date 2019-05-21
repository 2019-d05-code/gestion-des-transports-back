package dev.controller.dto;

import java.time.Duration;
import java.time.LocalDateTime;

import dev.domain.Annonce;
import dev.domain.Collegue;
import dev.domain.Vehicule;

public class AnnonceDto {

	private Long annonceurId;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	private Vehicule voiture;
	private LocalDateTime dateTimeDepart;
	private Integer place;

	public AnnonceDto() {
	}

	public Long getAnnonceurId() {
		return annonceurId;
	}

	public void setAnnonceurId(Long annonceurId) {
		this.annonceurId = annonceurId;
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

	public Annonce dtoToObject(Collegue collegue) {
		return new Annonce(collegue, adressDepart, adressArrivee, duree, distance, voiture, dateTimeDepart, place);
	}

}
