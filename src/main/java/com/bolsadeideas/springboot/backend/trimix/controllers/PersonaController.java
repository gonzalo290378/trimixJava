package com.bolsadeideas.springboot.backend.trimix.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.trimix.model.entity.Persona;
import com.bolsadeideas.springboot.backend.trimix.model.entity.TipoDocumento;
import com.bolsadeideas.springboot.backend.trimix.services.IPersonaService;
import com.bolsadeideas.springboot.backend.trimix.services.ITiposDocumentoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	private IPersonaService iPersonaService;

	@Autowired
	private ITiposDocumentoService iTiposDocumentoService;

	@GetMapping("/personas")
	public List<Persona> listarClientes() {
		return iPersonaService.findAll();
	}

	@PostMapping("/form/")
	public Persona create(@RequestBody Persona persona) {

		Persona nuevaPersona = new Persona();
		nuevaPersona.setPerNombre(persona.getPerNombre());
		nuevaPersona.setPerApellido(persona.getPerApellido());
		nuevaPersona.getTipoDocumento().setId(persona.getTipoDocumento().getId());
		nuevaPersona.getTipoDocumento().setTipo(persona.getTipoDocumento().getTipo());
		nuevaPersona.setPerNumeroDocumento(persona.getPerNumeroDocumento());
		nuevaPersona.setPerFechaNacimiento(persona.getPerFechaNacimiento());
		nuevaPersona = iPersonaService.save(nuevaPersona);
		return nuevaPersona;

	}
	
	@GetMapping("/form/{id}")
	public Persona show(@PathVariable Long id) {
		
		Persona persona = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			persona = iPersonaService.findByperId(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
		}
		
		if(persona == null) {
			response.put("mensaje", "La persona ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
		}
		
		return persona;

	}

	@PutMapping("/form/{perId}")
	public Persona update(@RequestBody Persona persona, @PathVariable Long perId) {

		Persona updatePersona = null;
		Map<String, Object> response = new HashMap<>();

		try {
			updatePersona = iPersonaService.findByperId(perId);
			updatePersona.setPerNombre(persona.getPerNombre());
			updatePersona.setPerApellido(persona.getPerApellido());
			updatePersona.setPerNumeroDocumento(persona.getPerNumeroDocumento());
			updatePersona.setTipoDocumento(persona.getTipoDocumento());
			updatePersona.setPerFechaNacimiento(persona.getPerFechaNacimiento());

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente");
		}

		return iPersonaService.save(updatePersona);

	}

	@DeleteMapping("/form/{perId}")
	public void delete(@PathVariable Long perId) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
									
			iPersonaService.delete(perId);
	
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la persona");
			
		}
		
		response.put("persona", "Persona ha sido eliminado con exito");
	}

	@GetMapping("/tiposDocumento")
	public List<TipoDocumento> findAllTiposDocumentos() {
		return iTiposDocumentoService.findAllTiposDocumentos();
	}

}
