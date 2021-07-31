package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import com.emanuelalso.disney.entity.Personaje;

public interface PersonajeService {
	
	public List<Personaje> findAll();
	
	public Personaje save(Personaje personaje);
	
	public Optional<Personaje> findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Personaje> findByName(String characterName);
	
	public List<Personaje> findByAge(int characterAge);
	
	public List<Personaje> findByWeight(float characterWeight);
}
