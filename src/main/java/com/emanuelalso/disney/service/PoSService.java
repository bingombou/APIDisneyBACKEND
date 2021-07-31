package com.emanuelalso.disney.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.entity.PoS;

@Service
public interface PoSService {
	
	public List<PoS> findAll();
	
	public PoS save(PoS poS);
	
	public Optional<PoS> findById(Long id);
	
	public void deleteById(Long id);
	
	public List<PoS> findByName(String poSTitle);
	

}
