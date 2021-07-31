package com.emanuelalso.disney.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuelalso.disney.entity.Genero;
import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.service.GeneroService;

@RestController
@RequestMapping("/genres")
public class GeneroController {

	@Autowired
	private GeneroService generoService;
	
	//Get List of characters
	@GetMapping
	public ResponseEntity<List<Genero>> read(){
		return ResponseEntity.ok(generoService.findAll());
	}
	
	//Create a genre
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Genero genero){
		return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(genero));
	}
	
	//Update a genre
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Personaje generoDetails, @PathVariable(value = "id") Long generoId){
		Optional<Genero> genero = generoService.findById(generoId);
		
		if(!genero.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		
		genero.get().setNombre(generoDetails.getNombre());
		genero.get().setImagen(generoDetails.getImagen());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generoService.save(genero.get()));
	}
	
	//Delete a genre
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long generoId){
		if(!generoService.findById(generoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		generoService.deleteById(generoId);
		return ResponseEntity.ok().build();
	}
	
}
