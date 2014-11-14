package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.AcreedorService;
import project.tranquera.domain.model.Acreedor;
import project.tranquera.persistence.dao.AcreedorDao;

import com.common.util.domain.exception.ServiceException;

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