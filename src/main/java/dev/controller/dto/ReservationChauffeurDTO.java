package dev.controller.dto;

import java.time.LocalDateTime;

import dev.domain.Reservation;

public class ReservationChauffeurDTO {

	private int id;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private String nomChauffeur;
	private String prenomChauffeur;
	private long idChauffeur;
	private Boolean avecChauffeur;

	public ReservationChauffeurDTO(Reservation reservation) {
		this.id = reservation.getId();
		this.dateDebut = reservation.getDateDeReservation();
		this.dateFin = reservation.getDateDeRetour();
		this.nomChauffeur = reservation.getUnChauffeur().getNom();
		this.prenomChauffeur = reservation.getUnChauffeur().getPrenom();
		this.avecChauffeur = reservation.isAvecOuSansChauffeur();
		this.idChauffeur = reservation.getUnChauffeur().getId();
	}

	public ReservationChauffeurDTO(Reservation reservation, String nom, String prenom) {
		this.id = reservation.getId();
		this.dateDebut = reservation.getDateDeReservation();
		this.dateFin = reservation.getDateDeRetour();
		this.nomChauffeur = nom;
		this.prenomChauffeur = prenom;
		this.avecChauffeur = reservation.isAvecOuSansChauffeur();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the nomChauffeur
	 */
	public String getNomChauffeur() {
		return nomChauffeur;
	}

	/**
	 * @param nomChauffeur the nomChauffeur to set
	 */
	public void setNomChauffeur(String nomChauffeur) {
		this.nomChauffeur = nomChauffeur;
	}

	/**
	 * @return the prenomChauffeur
	 */
	public String getPrenomChauffeur() {
		return prenomChauffeur;
	}

	/**
	 * @param prenomChauffeur the prenomChauffeur to set
	 */
	public void setPrenomChauffeur(String prenomChauffeur) {
		this.prenomChauffeur = prenomChauffeur;
	}

	/**
	 * @return the avecChauffeur
	 */
	public Boolean getAvecChauffeur() {
		return avecChauffeur;
	}

	/**
	 * @param avecChauffeur the avecChauffeur to set
	 */
	public void setAvecChauffeur(Boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}

	/**
	 * @return the idChauffeur
	 */
	public long getIdChauffeur() {
		return idChauffeur;
	}

	/**
	 * @param idChauffeur the idChauffeur to set
	 */
	public void setIdChauffeur(long idChauffeur) {
		this.idChauffeur = idChauffeur;
	}
}
