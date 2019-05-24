package dev.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatutVehicule {
	EN_SERVICE("En Service"), 
	EN_REPARATION("En Reparation"), 
	HORS_SERVICE("Hors-Service");
	
	private String nom = "";
	
	StatutVehicule(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}

	@JsonValue
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
