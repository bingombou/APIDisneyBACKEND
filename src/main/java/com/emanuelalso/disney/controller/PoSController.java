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
import com.emanuelalso.disney.entity.PoS;
import com.emanuelalso.disney.service.PoSService;

@RestController
@RequestMapping("/movies")
public class PoSController {

	@Autowired
	private PoSService poSService;
	
	//List of movies
	@GetMapping
	public ResponseEntity<List<PoS>> getAllPoS(){
		return ResponseEntity.ok(poSService.findAll());
	} 
	
	//Show details by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<PoS>> details(@PathVariable(value="id") Long poSId){
		return ResponseEntity.ok(poSService.findById(poSId));
	}
			
	//Create new movie or serie			
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PoS poS){
		return ResponseEntity.status(HttpStatus.CREATED).body(poSService.save(poS));
	}
	
	//Update a movie
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PoS poSDetails, @PathVariable(value = "id") Long poSId){
		Optional<PoS> poS = poSService.findById(poSId);
		
		if(!poS.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		
		poS.get().setImagen(poSDetails.getImagen());
		poS.get().setTitulo(poSDetails.getTitulo());
		poS.get().setFechaCreacion(poSDetails.getFechaCreacion());
		poS.get().setCalificacion(poSDetails.getCalificacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(poSService.save(poS.get()));
	}
	
	//Delete a character
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") Long poSId){
			if(!poSService.findById(poSId).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			poSService.deleteById(poSId);
			return ResponseEntity.ok().build();
		}
		
	//Sort by name
		@GetMapping("/titles/{title}")
		public ResponseEntity<List<PoS>> getByTitle(@PathVariable(value="title") String poSTitle){
			return ResponseEntity.ok(poSService.findByName(poSTitle));
		}
			
}
