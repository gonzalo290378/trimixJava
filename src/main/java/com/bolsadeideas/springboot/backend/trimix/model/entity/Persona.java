package com.bolsadeideas.springboot.backend.trimix.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "personas")
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long perId;
	
	@NotEmpty(message = "El campo nombre no puede estar vacio")
	@Column(name = "nombre")
	private String perNombre;
	
	@NotEmpty(message = "El campo apellido no puede estar vacio")
	@Column(name = "apellido")
	private String perApellido;

	@NotNull(message = "El campo numero de documento no puede estar vacio")
	@Column(name = "numero_documento")
	private Long perNumeroDocumento;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull(message = "El tipo de documento no puede ser vacio")
	private TipoDocumento tipoDocumento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "El campo Fecha de Nacimiento no puede estar vacio")
	private Date perFechaNacimiento;

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		if(tipoDocumento == null) {
			return tipoDocumento = new TipoDocumento();
		}
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

}
