package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emanuelalso.disney.entity.PersonajePoS;

@Service
public interface PersonajePoSService {
	
	public List<PersonajePoS> findAll();
	
	public PersonajePoS save(Long personajeId, Long poSId);
	
	public Optional<PersonajePoS> findById(Long id);
	
	public void deleteById(Long personajeId, long poSId);
	
}
