package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name = "peliculaoseries")
public class PoS implements Serializable{		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String imagen;
	
	@Column(length = 50)
	private String titulo;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	private int calificacion;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_genero")
	private Genero genero;	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Personaje> personajesL = new ArrayList<>();	
				
	
	public PoS(String imagen, String titulo, Date fechaCreacion, int calificacion, Genero genero) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.genero = genero;
	}

	public PoS() {
		
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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
		
	

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Personaje> getPersonajesL() {
		return personajesL;
	}

	public void setPersonajesL(List<Personaje> personajesL) {
		this.personajesL = personajesL;
	}

	private static final long serialVersionUID = 2629690442266164730L;
	
}
