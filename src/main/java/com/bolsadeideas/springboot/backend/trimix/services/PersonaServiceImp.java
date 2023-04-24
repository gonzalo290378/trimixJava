package com.bolsadeideas.springboot.backend.trimix.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.trimix.dao.IPersonaDao;
import com.bolsadeideas.springboot.backend.trimix.model.entity.Persona;

@Service
public class PersonaServiceImp implements IPersonaService{
	
	@Autowired
	private IPersonaDao iPersonaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		List<Persona> listaPersonas = (List<Persona>) iPersonaDao.findAll();
		return listaPersonas;
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return iPersonaDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iPersonaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByperNombre(String perNombre) {
		List<Persona> findByperNombre = iPersonaDao.findByperNombre(perNombre);
		return findByperNombre;
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findByTipoDocumento(String TipoDocumento) {
		List<Persona> findByperTipoDocumento = iPersonaDao.findByTipoDocumento(TipoDocumento);
		return findByperTipoDocumento;
		
	}

	@Override
	public Persona findByperId(Long perId) {
		Persona persona = iPersonaDao.findByperId(perId);
		return persona;
	}
	
	

}
