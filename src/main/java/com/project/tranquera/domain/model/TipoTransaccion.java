package com.project.tranquera.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.domain.annotation.Model;

/**
 * Clase que representa un tipo de transacción de caja.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "TIPO_TRANSACCIONES")
@Entity(name = "TipoTransaccion")
public class TipoTransaccion extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String NOMBRE = "nombre";
		public static final String INGRESO = "ingreso";
	}

	private String nombre;

	private Boolean ingreso;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" NOMBRE: ").append(this.nombre).append(" INGRESO: ").append(this.ingreso);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_TIPO_TRANSACCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "NOMBRE", columnDefinition = "varchar(100)", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "INGRESO", columnDefinition = "bit", nullable = false)
	public Boolean getIngreso() {
		return ingreso;
	}

	public void setIngreso(Boolean ingreso) {
		this.ingreso = ingreso;
	}
}