package dev.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.domain.Collegue;
import dev.domain.Role;

/**
 * Structure modèlisant un collègue servant à communiquer avec l'extérieur (WEB
 * API).
 */
public class CollegueDTO {

	private long id;
	private String email;
	private String nom;
	private String prenom;
	private String permis;
	private String telephone;
	private String photoUrl;
	private List<Role> roles = new ArrayList<>();

	public CollegueDTO(String email, String nom, String prenom, String telephone, String photoUrl) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.photoUrl = photoUrl;
	}

	public CollegueDTO(Collegue col) {
		this.id = col.getId();
		this.email = col.getEmail();
		this.nom = col.getNom();
		this.prenom = col.getPrenom();
		this.permis = col.getPermis();
		this.telephone = col.getTelephone();
		this.photoUrl = col.getPhotoUrl();
		this.roles = col.getRoles().stream().map(roleCollegue -> roleCollegue.getRole()).collect(Collectors.toList());
	}

	public CollegueDTO(long id, String nom, String prenom) {
		this.id = id; 
		this.nom=nom; 
		this.prenom=prenom; 
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the permis
	 */
	public String getPermis() {
		return permis;
	}

	/**
	 * @param permis the permis to set
	 */
	public void setPermis(String permis) {
		this.permis = permis;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
