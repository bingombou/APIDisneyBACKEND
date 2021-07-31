package com.emanuelalso.disney.respository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuelalso.disney.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Serializable>{

}
