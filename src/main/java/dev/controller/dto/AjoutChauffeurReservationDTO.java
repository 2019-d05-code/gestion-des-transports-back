package dev.controller.dto;

public class AjoutChauffeurReservationDTO {

	public AjoutChauffeurReservationDTO() {

	}

	public int idResa;
	public long idChauffeur;

	/**
	 * @return the idResa
	 */
	public int getIdResa() {
		return idResa;
	}

	/**
	 * @param idResa the idResa to set
	 */
	public void setIdResa(int idResa) {
		this.idResa = idResa;
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
