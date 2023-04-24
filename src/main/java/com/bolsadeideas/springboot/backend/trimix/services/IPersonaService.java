package com.bolsadeideas.springboot.backend.trimix.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.trimix.model.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public Persona save (Persona persona);
	
	public void delete (Long id);

	public List<Persona> findByperNombre(String nombre);

	public List<Persona> findByTipoDocumento(String tipoDocumento);
	
	public Persona findByperId(Long perId);
	
}
