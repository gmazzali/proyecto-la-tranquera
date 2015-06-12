package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.Pago;
import com.project.tranquera.persistence.dao.PagoDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los pagos a los acreedores.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class PagoDaoImpl extends TranqueraActiveBaseDaoImpl<Pago, Long> implements PagoDao {
	private static final long serialVersionUID = 1L;
}