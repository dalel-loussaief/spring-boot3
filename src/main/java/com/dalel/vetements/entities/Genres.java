package com.dalel.vetements.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idG;
	private String sexe;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "genres")
	private List<Vetement> vetements;
	
	public Genres(String sexe, String description, List<Vetement> vetements) {
		super();
		this.sexe = sexe;
		this.description = description;
		this.vetements = vetements;
	}
	public Genres() {
		super();

	}
	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Vetement> getVetements() {
		return vetements;
	}
	public void setVetements(List<Vetement> vetements) {
		this.vetements = vetements;
	}
	
	
	
	
}
