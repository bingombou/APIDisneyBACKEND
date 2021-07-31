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

import com.emanuelalso.disney.entity.Personaje;
import com.emanuelalso.disney.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;
		
	//List of characters
	@GetMapping
	public ResponseEntity<List<Personaje>> show(){
		return ResponseEntity.ok(personajeService.findAll());
	}
	
	//Show details by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Personaje>> details(@PathVariable(value="id") Long personajeId){
		return ResponseEntity.ok(personajeService.findById(personajeId));
	}
	
	//Sort by name
	@GetMapping("/names/{name}")
	public ResponseEntity<List<Personaje>> getByName(@PathVariable(value="name") String characterName){
		return ResponseEntity.ok(personajeService.findByName(characterName));
	}
	
	//Sort by age
	@GetMapping("/ages/{age}")
	public ResponseEntity<List<Personaje>> getByName(@PathVariable(value="age") int characterAge){
		return ResponseEntity.ok(personajeService.findByAge(characterAge));
	}
	
	//Sort by weight
	@GetMapping("/pesos/{weight}")
	public ResponseEntity<List<Personaje>> getByWeight(@PathVariable(value="weight") float characterWeight){
		return ResponseEntity.ok(personajeService.findByWeight(characterWeight));
	}

	//Create a new character
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Personaje personaje){
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.save(personaje));
	}		 
	
	//Update a character
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Personaje personajeDetails, @PathVariable(value = "id") Long personajeId){
		Optional<Personaje> personaje = personajeService.findById(personajeId);
		
		if(!personaje.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		
		personaje.get().setImagen(personajeDetails.getImagen());
		personaje.get().setNombre(personajeDetails.getNombre());
		personaje.get().setEdad(personajeDetails.getEdad());
		personaje.get().setPeso(personajeDetails.getPeso());
		personaje.get().setHistoria(personajeDetails.getHistoria());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.save(personaje.get()));
	}
	
	//Delete a character
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long personajeId){
		if(!personajeService.findById(personajeId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		personajeService.deleteById(personajeId);
		return ResponseEntity.ok().build();
	}
	

		
}
