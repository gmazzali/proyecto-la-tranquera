package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.CategoriaService;
import project.tranquera.domain.model.Categoria;
import project.tranquera.persistence.dao.CategoriaDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el las Categorias.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class CategoriaServiceImpl extends TranqueraBaseServiceImpl<Categoria, Long> implements CategoriaService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setCategoriaDao(CategoriaDao dao) {
		super.setDao(dao);
	}

	public void validate(Categoria entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}