package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "personajes") 
public class Personaje implements Serializable{			
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imagen;
	
	@Column(length = 50)
	private String nombre;
	
	private int edad;
	
	private float peso;
	
	@Column(length = 1200)	
	private String historia;
	

	@ManyToMany(mappedBy = "personajesL", fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	private List<PoS> poSL = new ArrayList<>();	
		

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
	

	public List<PoS> getPoSL() {
		return poSL;
	}


	public void setPoSL(List<PoS> poSL) {
		this.poSL = poSL;
	}










	private static final long serialVersionUID = 6646313909540413842L;
}
