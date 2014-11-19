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
@Table(name = "TIPOS_TRANSACCIONES")
@Entity(name = "TipoTransaccion")
public class TipoTransaccion extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String DESCRIPCION = "descripcion";
		public static final String MODIFICABLE = "modificable";
	}

	private String descripcion;

	private Boolean modificable;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" DESCRIPCION: ").append(this.descripcion).append(" MODIFICABLE: ").append(this.modificable);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_TIPO_TRANSACCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getModificable() {
		return modificable;
	}

	public void setModificable(Boolean modificable) {
		this.modificable = modificable;
	}
}