package com.emanuelalso.disney.respository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuelalso.disney.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Serializable> {

}
