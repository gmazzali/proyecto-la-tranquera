package com.project.tranquera.persistence.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.common.util.domain.model.entity.Persistence;
import com.common.util.persistence.dao.impl.BaseDaoImpl;
import com.project.tranquera.persistence.dao.TranqueraBaseDao;

/**
 * La clase que implementa la interfaz base para los DAOs del proyecto.
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
public class TranqueraBaseDaoImpl<E extends Persistence<PK>, PK extends Serializable> extends BaseDaoImpl<E, PK> implements TranqueraBaseDao<E, PK> {
	private static final long serialVersionUID = 1L;

	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}