package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.PrecioService;
import project.tranquera.domain.model.Precio;
import project.tranquera.persistence.dao.PrecioDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los menues.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class PrecioServiceImpl extends TranqueraBaseServiceImpl<Precio, Long> implements PrecioService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPrecioDao(PrecioDao dao) {
		super.setDao(dao);
	}

	public void validate(Precio entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}