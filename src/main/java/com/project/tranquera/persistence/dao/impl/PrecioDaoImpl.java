package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.Precio;
import com.project.tranquera.persistence.dao.PrecioDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los precios.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class PrecioDaoImpl extends TranqueraBaseDaoImpl<Precio, Long> implements PrecioDao {
	private static final long serialVersionUID = 1L;
}