package dev.domain;

public enum StatutVehicule {

	EN_SERVICE("En Service"), EN_REPARATION("En Reparation"), HORS_SERVICE("Hors-service");

	private String nom;

	private StatutVehicule(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

}
