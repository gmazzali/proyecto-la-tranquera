package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.MenuService;
import project.tranquera.domain.model.Menu;
import project.tranquera.persistence.dao.MenuDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los menues.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class MenuServiceImpl extends TranqueraBaseServiceImpl<Menu, Long> implements MenuService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMenuDao(MenuDao dao) {
		super.setDao(dao);
	}

	public void validate(Menu entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}