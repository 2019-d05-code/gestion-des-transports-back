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
	@Enumerated(EnumType.STRING)
	private StatutVehicule statutVehicule;
  
  @OneToMany(mappedBy = "uneVoiture")
	List<Reservation> listeDeReservations; 

	public Vehicule() {
		this.statutVehicule = StatutVehicule.EN_SERVICE;
	}
  
  public Vehicule(int id) {
		super();
		this.id = id;
	}

	public Vehicule(String marque, String modele, CategorieVehicule categorie, String immatriculation, String photoUrl,
			Integer nbPlaces) {
		super();
		this.marque = marque.toUpperCase();
		this.modele = modele.toLowerCase();
		this.categorie = categorie;
		this.immatriculation = immatriculation.toUpperCase();
		this.photoUrl = photoUrl;
		this.nbPlaces = nbPlaces;
		this.statutVehicule = StatutVehicule.EN_SERVICE;
	}

	public Vehicule(String marque, String modele, CategorieVehicule categorie, String immatriculation, String photoUrl,
			Integer nbPlaces, StatutVehicule statutVehicule) {
		super();
		this.marque = marque.toUpperCase();
		this.modele = modele.toLowerCase();
		this.categorie = categorie;
		this.immatriculation = immatriculation.toUpperCase();
		this.photoUrl = photoUrl;
		this.nbPlaces = nbPlaces;
		this.statutVehicule = statutVehicule;
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

	/**
	 * @return the categorie
	 */
	public CategorieVehicule getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategorieVehicule categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the statutVehicule
	 */
	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}

	/**
	 * @param statutVehicule the statutVehicule to set
	 */
	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

  public List<Reservation> getListeDeReservations() {
		return listeDeReservations;
	}

	public void setListeDeReservations(List<Reservation> listeDeReservations) {
		this.listeDeReservations = listeDeReservations;
	}

}
