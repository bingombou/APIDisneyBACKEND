package com.emanuelalso.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emanuelalso.disney.entity.PersonajePoS;
import com.emanuelalso.disney.service.PersonajePoSService;

@Controller
@RequestMapping("/charactersmovies")
public class PersonajePoSController {
	
	@Autowired
	private PersonajePoSService personajePoSService;
			
	//List of movies
	@GetMapping
	public ResponseEntity<List<PersonajePoS>> getAllPPS(){
		return ResponseEntity.ok(personajePoSService.findAll());
	} 
		
	//Create new movie or serie			
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> create(@RequestParam Long personajeId, @RequestParam Long poSId){
		return ResponseEntity.status(HttpStatus.CREATED).body(personajePoSService.save(personajeId, poSId)); 
	}
}
