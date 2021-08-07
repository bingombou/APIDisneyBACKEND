package com.emanuelalso.disney.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class PersonajePoS {
	@EmbeddedId
	PersonajePoSId personajePoSId;
	
	@ManyToOne
	@MapsId("personajeId")
	@JoinColumn(name = "personaje_id") 
	Personaje personaje;
	
	@ManyToOne
	@MapsId("poSId")
	@JoinColumn(name = "pos_id")
	PoS poS;
	
	@Column (name = "nombre_personaje")
	private String nameP;
	
	@Column (name = "titulo_peliculaoserie")
	private String nombrePS;
			
	public PersonajePoS(Personaje personaje, PoS poS, String nameP, String nombrePS) {
		this.personaje = personaje;
		this.poS = poS;
		this.nameP = nameP;
		this.nombrePS = nombrePS;
	}
	
	public PersonajePoS() {
	}
	
	public PersonajePoSId getPersonajePoSId() {
		return personajePoSId;
	}
	public void setPersonajePoSId(PersonajePoSId personajePoSId) {
		this.personajePoSId = personajePoSId;
	}
	
	@JsonBackReference(value = "personaje")
	public Personaje getPersonaje() {
		return personaje;
	}
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	@JsonBackReference (value = "pos")
	public PoS getPoS() {
		return poS;
	}
	public void setPoS(PoS poS) {
		this.poS = poS;
	}
	public String getNameP() {
		return nameP;
	}
	public void setNameP(String nameP) {
		this.nameP = nameP;
	}
	public String getNombrePS() {
		return nombrePS;
	}
	public void setNombrePS(String nombrePS) {
		this.nombrePS = nombrePS;
	}
	
	
}
