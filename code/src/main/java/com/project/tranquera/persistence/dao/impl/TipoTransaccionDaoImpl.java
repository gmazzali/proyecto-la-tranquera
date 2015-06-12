package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.TipoTransaccion;
import com.project.tranquera.persistence.dao.TipoTransaccionDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los tipos de transacciones.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class TipoTransaccionDaoImpl extends TranqueraActiveBaseDaoImpl<TipoTransaccion, Long> implements TipoTransaccionDao {
	private static final long serialVersionUID = 1L;
}