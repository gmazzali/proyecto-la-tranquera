package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.TipoTransaccionService;
import com.project.tranquera.domain.model.TipoTransaccion;
import com.project.tranquera.persistence.dao.TipoTransaccionDao;

/**
 * Clase que define los servicios base para el los tipos de transacciones.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class TipoTransaccionServiceImpl extends TranqueraBaseServiceImpl<TipoTransaccion, Long> implements TipoTransaccionService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setTipoTransaccionDao(TipoTransaccionDao dao) {
		super.setDao(dao);
	}

	public void validate(TipoTransaccion entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}