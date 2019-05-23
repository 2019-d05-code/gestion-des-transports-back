package dev.controller.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import dev.domain.StatutVehicule;
import dev.domain.Vehicule;

public class ModifierStatutVehiculeDTO {

	private String immatriculation;
	@Enumerated(EnumType.STRING)
	private StatutVehicule statutVehicule;

	public ModifierStatutVehiculeDTO() {
	}

	public ModifierStatutVehiculeDTO(Vehicule vehicule) {
		this.immatriculation = vehicule.getImmatriculation();
		this.statutVehicule = vehicule.getStatutVehicule();
	}

	/**
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
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
}
