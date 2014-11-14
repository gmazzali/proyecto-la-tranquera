package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.MozoService;
import project.tranquera.domain.model.Mozo;
import project.tranquera.persistence.dao.MozoDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los mozos.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class MozoServiceImpl extends TranqueraBaseServiceImpl<Mozo, Long> implements MozoService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMozoDao(MozoDao dao) {
		super.setDao(dao);
	}

	public void validate(Mozo entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}