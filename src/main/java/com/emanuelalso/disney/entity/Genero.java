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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "generos")
public class Genero implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(length = 50)
	private String nombre;
	private String imagen;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genero", fetch = FetchType.LAZY)	
	private List<PoS> poSList = new ArrayList<>();				
				

	public Genero(String nombre, String imagen, List<PoS> poSL) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.poSList = poSL;
	}

	public Genero() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	@JsonManagedReference(value = "genero")
	public List<PoS> getPoSL() {
		return poSList;
	}

	public void setPoSL(List<PoS> poSL) {
		this.poSList = poSL;
	}



	private static final long serialVersionUID = -6572970440851277252L;
}
