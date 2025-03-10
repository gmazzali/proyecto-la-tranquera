package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.CajaService;
import com.project.tranquera.domain.model.Caja;
import com.project.tranquera.persistence.dao.CajaDao;

/**
 * Clase que define los servicios base para el las Cajas.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class CajaServiceImpl extends TranqueraBaseServiceImpl<Caja, Long> implements CajaService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setCajaDao(CajaDao dao) {
		super.setDao(dao);
	}

	public void validate(Caja entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}