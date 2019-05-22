package dev.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Long annonceurId;
	private String adressDepart;
	private String adressArrivee;
	private Duration duree;
	private Float distance;
	private LocalDateTime dateTimeDepart;
	private Integer place;

	public Annonce() {
	}

	public Annonce(Long annonceurId, String adressDepart, String adressArrivee, Duration duree, Float distance,
			LocalDateTime dateTimeDepart, Integer place) {
		super();
		this.annonceurId = annonceurId;
		this.adressDepart = adressDepart;
		this.adressArrivee = adressArrivee;
		this.duree = duree;
		this.distance = distance;
		this.dateTimeDepart = dateTimeDepart;
		this.place = place;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
