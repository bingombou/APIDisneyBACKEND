package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "personajes") 
public class Personaje implements Serializable{			
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personajeId;
	
	private String imagen;
	
	@Column(length = 50)
	private String nombre;
	
	private int edad;
	
	private float peso;
	
	@Column(length = 1200)	
	private String historia;
	
	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL)
	private Collection<PersonajePoS> personajePoSs = new ArrayList<>(); 

	public Personaje(String imagen, String nombre, int edad, float peso, String historia) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}


	public Personaje() {
	}		

	public Long getPersonajeId() {
		return personajeId;
	}

	public void setPersonajeId(Long personajeId) {
		this.personajeId = personajeId;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public float getPeso() {
		return peso;
	}



	public void setPeso(float peso) {
		this.peso = peso;
	}



	public String getHistoria() {
		return historia;
	}



	public void setHistoria(String historia) {
		this.historia = historia;
	}

	@JsonManagedReference(value = "personaje")
	public Collection<PersonajePoS> getPersonajePoSs() {
		return personajePoSs;
	}

	public void setPersonajePoSs(Collection<PersonajePoS> personajePoSs) {
		this.personajePoSs = personajePoSs;
	}


	private static final long serialVersionUID = 6646313909540413842L;
}
