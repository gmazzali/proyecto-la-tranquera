package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.AcreedorService;
import com.project.tranquera.domain.model.Acreedor;
import com.project.tranquera.persistence.dao.AcreedorDao;

/**
 * Clase que define los servicios base para los acreedores.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class AcreedorServiceImpl extends TranqueraBaseServiceImpl<Acreedor, Long> implements AcreedorService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setAcreedorDao(AcreedorDao dao) {
		super.setDao(dao);
	}

	public void validate(Acreedor entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}