package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.MontoInicio;
import com.project.tranquera.persistence.dao.MontoInicioDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los montos de inicio de caja.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class MontoInicioDaoImpl extends TranqueraBaseDaoImpl<MontoInicio, Long> implements MontoInicioDao {
	private static final long serialVersionUID = 1L;
}