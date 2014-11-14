package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.MesaService;
import project.tranquera.domain.model.Mesa;
import project.tranquera.persistence.dao.MesaDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el las mesas.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class MesaServiceImpl extends TranqueraBaseServiceImpl<Mesa, Long> implements MesaService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMesaDao(MesaDao dao) {
		super.setDao(dao);
	}

	public void validate(Mesa entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}