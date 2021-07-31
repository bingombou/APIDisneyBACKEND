package com.emanuelalso.disney.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.respository.PersonajeRepository;

@Service
public class PersonajeServiceImpl implements PersonajeService{

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Override
	@Transactional (readOnly = true)
	public List<Personaje> findAll() {
		return personajeRepository.findAll();
	}

	@Override
	@Transactional
	public Personaje save(Personaje personaje) {
		return personajeRepository.save(personaje);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Personaje> findById(Long id){
		return personajeRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		personajeRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Personaje> findByName(String characterName){
		List<Personaje> personajesByName = new ArrayList<>();
		List<Personaje> personajes = personajeRepository.findAll();
		for(int i=0; i<personajes.size(); i++) {
			if(personajes.get(i).getNombre().equals(characterName) || personajes.get(i).getNombre().toLowerCase().equals(characterName)) {
				personajesByName.add(personajes.get(i));
			}
		}
		return personajesByName;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personaje> findByAge(int characterAge){
		List<Personaje> personajesByAge = new ArrayList<>();
		List<Personaje> personajes = personajeRepository.findAll();
		for(int i=0; i<personajes.size(); i++) {
			if(personajes.get(i).getEdad() == characterAge ) {
				personajesByAge.add(personajes.get(i));
			}
		}
		return personajesByAge;	
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Personaje> findByWeight(float characterWeight){
		List<Personaje> personajesByWeight = new ArrayList<>();
		List<Personaje> personajes = personajeRepository.findAll();
		for(int i=0; i<personajes.size(); i++) {
			if(personajes.get(i).getPeso() == characterWeight ) {
				personajesByWeight.add(personajes.get(i));
			}
		}
		return personajesByWeight;	
	}
}
