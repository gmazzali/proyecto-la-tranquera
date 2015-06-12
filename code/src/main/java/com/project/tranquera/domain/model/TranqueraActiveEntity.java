package com.project.tranquera.domain.model;

import java.io.Serializable;

import javax.persistence.Column;

import com.common.util.domain.model.entity.ActiveEntity;

/**
 * Clase base para las entidades activables.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <PK>
 *            La clase de las claves primarias.
 */
public abstract class TranqueraActiveEntity<PK extends Serializable> extends ActiveEntity<PK> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends ActiveEntity.Attributes {
	}

	@Override
	@Column(name = "ACTIVO", columnDefinition = "bit", nullable = false)
	public Boolean getActive() {
		return active;
	}
}