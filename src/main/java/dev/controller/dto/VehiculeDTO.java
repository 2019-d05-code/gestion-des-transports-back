package dev.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dev.domain.CategorieVehicule;
import dev.domain.Reservation;
import dev.domain.StatutVehicule;
import dev.domain.Vehicule;
import dev.exception.EmptyRepositoryException;
import dev.service.ReservationService;

public class VehiculeDTO {

	private int id;
	private String marque;
	private String modele;
	private String immatriculation;
	private CategorieVehicule categorie;
	private String photoUrl;
	private Integer nbPlaces;
	private StatutVehicule statutVehicule;
	
	private List<ReservationDTO> resaVehicule = new ArrayList<ReservationDTO>(); 
	
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
		this.statutVehicule = vehicule.getStatutVehicule();
		
		List<ReservationDTO> tmp = new ArrayList<ReservationDTO>();
		
		for(Reservation res:vehicule.getListeDeReservations()) {
			tmp.add(new ReservationDTO(res));
		}
		this.resaVehicule = tmp;
		
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


	public List<ReservationDTO> getResaVehicule() {
		return resaVehicule;
	}


	public void setResaVehicule(List<ReservationDTO> resaVehicule) {
		this.resaVehicule = resaVehicule;
	}


	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}


	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	
}
