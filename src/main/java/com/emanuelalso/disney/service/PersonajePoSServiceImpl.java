package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.entity.PersonajePoS;
import com.emanuelalso.disney.entity.PersonajePoSId;
import com.emanuelalso.disney.entity.PoS;
import com.emanuelalso.disney.respository.PersonajePoSRepository;
import com.emanuelalso.disney.respository.PersonajeRepository;
import com.emanuelalso.disney.respository.PoSRepository;

@Service
public class PersonajePoSServiceImpl implements PersonajePoSService{
	
	@Autowired
	private PersonajePoSRepository personajePoSRepository;
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private PoSRepository poSRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonajePoS> findAll() {
		return personajePoSRepository.findAll();
	}

	@Override
	@Transactional
	public PersonajePoS save(Long personajeId, Long poSId) {
		Personaje personaje = personajeRepository.findById(personajeId).get();
		PoS poS = poSRepository.findById(poSId).get();
		PersonajePoS pps = new PersonajePoS();
		pps.setPersonaje(personaje);
		pps.setPoS(poS);
		pps.setNameP(personaje.getNombre());
		pps.setNombrePS(poS.getTitulo());
		pps.setPersonajePoSId(new PersonajePoSId(personaje.getPersonajeId(), poS.getPoSId()));
		return personajePoSRepository.save(pps);		
	}

	@Override
	public Optional<PersonajePoS> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long personajeId, long poSId) {
		// TODO Auto-generated method stub
		
	}

}
