package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(length = 50)
	private String nombre;
	private String imagen;
	
	@OneToMany(cascade = CascadeType.ALL)	
	@JoinColumn(name = "id_genero")
	private List<PoS> poSL = new ArrayList<>();				
				

	public Genero(String nombre, String imagen, List<PoS> poSL) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.poSL = poSL;
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

	

	public List<PoS> getPoSL() {
		return poSL;
	}

	public void setPoSL(List<PoS> poSL) {
		this.poSL = poSL;
	}



	private static final long serialVersionUID = -6572970440851277252L;
}
