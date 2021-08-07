package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "peliculasoseries")
public class PoS implements Serializable{		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long poSId;	
	
	private String imagen;
	
	@Column(length = 50)
	private String titulo;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion = new Date();
	
	private int calificacion;	
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;	
	
	@OneToMany(mappedBy = "poS", cascade = CascadeType.ALL)
	private Collection<PersonajePoS> personajePoSs = new ArrayList<>();
		
	public PoS(String imagen, String titulo, int calificacion, Genero genero) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.calificacion = calificacion;
		this.genero = genero;
	}

	public PoS() {
		
	}
	

	public Long getPoSId() {
		return poSId;
	}

	public void setPoSId(Long poSId) {
		this.poSId = poSId;
	}

	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}			
		
	
	@JsonBackReference (value = "genero")
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}	
 
	@JsonManagedReference(value = "pos")
	public Collection<PersonajePoS> getPersonajePoSs() {
		return personajePoSs;
	}

	public void setPersonajePoSs(Collection<PersonajePoS> personajePoSs) {
		this.personajePoSs = personajePoSs;
	}



	private static final long serialVersionUID = 2629690442266164730L;
	
}
