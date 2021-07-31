package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import com.emanuelalso.disney.entity.Genero;

public interface GeneroService {
	
	public List<Genero> findAll();
	
	public Genero save(Genero genero);
	
	public Optional<Genero> findById(Long id);
	
	public void deleteById(Long id);
}
