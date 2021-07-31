package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelalso.disney.entity.Genero;
import com.emanuelalso.disney.respository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}

	@Override
	@Transactional
	public Genero save(Genero genero) {
		return generoRepository.save(genero);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Genero> findById(Long id){
		return generoRepository.findById(id);
	}

	@Override
	@Transactional	
	public void deleteById(Long id) {
		generoRepository.deleteById(id);		
	}
	
}
