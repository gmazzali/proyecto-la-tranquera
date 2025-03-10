package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.TransaccionService;
import com.project.tranquera.domain.model.Transaccion;
import com.project.tranquera.persistence.dao.TransaccionDao;

/**
 * Clase que define los servicios base para el las transacciones.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class TransaccionServiceImpl extends TranqueraBaseServiceImpl<Transaccion, Long> implements TransaccionService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setTransaccionDao(TransaccionDao dao) {
		super.setDao(dao);
	}

	public void validate(Transaccion entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}