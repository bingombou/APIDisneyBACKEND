package com.emanuelalso.disney.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PersonajePoSId implements Serializable{
		
	private Long personajeId;
	private Long poSId;
	 
	public Long getPersonajeId() {
		return personajeId;
	}
	public void setPersonajeId(Long personajeId) {
		this.personajeId = personajeId;
	}
	public Long getPoSId() {
		return poSId;
	}
	public void setPoSId(Long poSId) {
		this.poSId = poSId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(personajeId, poSId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonajePoSId other = (PersonajePoSId) obj;
		return Objects.equals(personajeId, other.personajeId) && Objects.equals(poSId, other.poSId);
	}
	public PersonajePoSId(Long personajeId, Long poSId) {
		this.personajeId = personajeId;
		this.poSId = poSId;
	}
	public PersonajePoSId() {
	}

	private static final long serialVersionUID = -3932797680055736775L;
	
	
}
