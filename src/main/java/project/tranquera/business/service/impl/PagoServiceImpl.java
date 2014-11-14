package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.PagoService;
import project.tranquera.domain.model.Pago;
import project.tranquera.persistence.dao.PagoDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los pagos a los acreedores.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class PagoServiceImpl extends TranqueraBaseServiceImpl<Pago, Long> implements PagoService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPagoDao(PagoDao dao) {
		super.setDao(dao);
	}

	public void validate(Pago entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}