package com.emanuelalso.disney.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuelalso.disney.entity.PersonajePoS;
import com.emanuelalso.disney.entity.PersonajePoSId;

@Repository
public interface PersonajePoSRepository extends JpaRepository<PersonajePoS, PersonajePoSId>{

}
