package com.emanuelalso.disney.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.entity.PoS;
import com.emanuelalso.disney.respository.PoSRepository;

@Service
public class PoSServiceImpl implements PoSService{

	@Autowired
	private PoSRepository poSRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<PoS> findAll() {
		return poSRepository.findAll();
	}

	@Override
	public PoS save(PoS poS) {
		return poSRepository.save(poS);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PoS> findById(Long id){
		return poSRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		poSRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<PoS> findByName(String poSTitle) {
		List<PoS> poSByName = new ArrayList<>();
		List<PoS> poSs= poSRepository.findAll();
		for(int i=0; i<poSs.size(); i++) {
			if(poSs.get(i).getTitulo().equals(poSTitle) || poSs.get(i).getTitulo().toLowerCase().equals(poSTitle)) {
				poSByName.add(poSs.get(i));
			}
		}
		return poSByName;
	}

}
