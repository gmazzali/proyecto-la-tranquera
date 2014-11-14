package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.MontoInicioService;
import project.tranquera.domain.model.MontoInicio;
import project.tranquera.persistence.dao.MontoInicioDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los montos de inicios de cajas.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class MontoInicioServiceImpl extends TranqueraBaseServiceImpl<MontoInicio, Long> implements MontoInicioService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMontoInicioDao(MontoInicioDao dao) {
		super.setDao(dao);
	}

	public void validate(MontoInicio entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}