package com.project.tranquera.domain.model;

import java.io.Serializable;

import com.common.util.domain.model.entity.Entity;

/**
 * Clase base para las entidades.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <PK>
 *            La clase de las claves primarias.
 */
public abstract class TranqueraEntity<PK extends Serializable> extends Entity<PK> {
	private static final long serialVersionUID = 1L;
}