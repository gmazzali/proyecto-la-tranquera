package com.project.tranquera.persistence.dao;

import java.io.Serializable;

import com.common.util.domain.model.entity.Persistence;
import com.common.util.persistence.dao.BaseDao;

/**
 * La interfaz base para los DAOs del proyecto.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 *
 * @param <E>
 *            Las entidades que vamos a manipular.
 * @param <PK>
 *            La clase de la clave de las entidades que vamos a manipular.
 */
public interface TranqueraBaseDao<E extends Persistence<PK>, PK extends Serializable> extends BaseDao<E, PK> {
}