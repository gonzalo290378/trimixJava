package com.bolsadeideas.springboot.backend.trimix.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bolsadeideas.springboot.backend.trimix.model.entity.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long>{
	
	public List<Persona> findByperNombre(String perNombre);
	
	public List<Persona> findByTipoDocumento(String TipoDocumento);
	
	public Persona findByperId(Long perId);

}
