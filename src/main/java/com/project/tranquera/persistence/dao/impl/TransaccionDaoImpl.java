package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.Transaccion;
import com.project.tranquera.persistence.dao.TransaccionDao;


/**
 * La clase que implementa la interfaz base para los DAOs de las cajas.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class TransaccionDaoImpl extends TranqueraBaseDaoImpl<Transaccion, Long> implements TransaccionDao {
	private static final long serialVersionUID = 1L;
}