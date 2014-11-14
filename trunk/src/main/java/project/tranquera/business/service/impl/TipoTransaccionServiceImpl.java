package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.TipoTransaccionService;
import project.tranquera.domain.model.TipoTransaccion;
import project.tranquera.persistence.dao.TipoTransaccionDao;

import com.common.util.domain.exception.ServiceException;

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