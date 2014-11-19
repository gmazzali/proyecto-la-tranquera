package com.project.tranquera.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.domain.annotation.Model;

/**
 * Clase que representa un acreedor.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "ACREEDORES")
@Entity(name = "Acreedor")
public class Acreedor extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String NOMBRE = "nombre";
		public static final String DIRECCION = "direccion";
		public static final String TELEFONO = "telefono";
		public static final String OBSERVACION = "observacion";
	}

	private String nombre;

	private String direccion;

	private String telefono;

	private String observacion;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" NOMBRE: ").append(this.nombre).append(" DIRECCION: ").append(this.direccion)
				.append(" TELEFONO: ").append(this.telefono).append(" OBSERVACION: ").append(this.observacion);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_ACREEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}