package com.dalel.vetements.dto;

import java.util.Date;

import com.dalel.vetements.entities.Genres;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetementDTO {
	private Long idvetement;
	private String nomvetement;
	private String taille;
	private Double prixvetement;
	private Date dateprod;
	private Genres genres;
	//private String description;
	
	public VetementDTO() {
		super();
		
	}


	public VetementDTO(String nomvetement, String taille, Double prixvetement, Date dateprod, Genres genres) {
		super();
		this.nomvetement = nomvetement;
		this.taille = taille;
		this.prixvetement = prixvetement;
		this.dateprod = dateprod;
		this.genres = genres;
	}


	public Long getIdvetement() {
		return idvetement;
	}


	public void setIdvetement(Long idvetement) {
		this.idvetement = idvetement;
	}


	public String getNomvetement() {
		return nomvetement;
	}


	public void setNomvetement(String nomvetement) {
		this.nomvetement = nomvetement;
	}


	public String getTaille() {
		return taille;
	}


	public void setTaille(String taille) {
		this.taille = taille;
	}


	public Double getPrixvetement() {
		return prixvetement;
	}


	public void setPrixvetement(Double prixvetement) {
		this.prixvetement = prixvetement;
	}


	public Date getDateprod() {
		return dateprod;
	}


	public void setDateprod(Date dateprod) {
		this.dateprod = dateprod;
	}


	public Genres getGenres() {
		return genres;
	}


	public void setGenres(Genres genres) {
		this.genres = genres;
	}


	
	
	
	
	
}
