package dev.domain;

public enum StatutVehicule {

	N_SERVICE("en_service"), EN_REPARATION("en_reparation"), HORS_SERVICE("hors_service");

	private String nom;

	private StatutVehicule(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

}
