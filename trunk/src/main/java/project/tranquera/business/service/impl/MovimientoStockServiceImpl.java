package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.MovimientoStockService;
import project.tranquera.domain.model.MovimientoStock;
import project.tranquera.persistence.dao.MovimientoStockDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los movimientos de stock.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class MovimientoStockServiceImpl extends TranqueraBaseServiceImpl<MovimientoStock, Long> implements MovimientoStockService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMovimientoStockDao(MovimientoStockDao dao) {
		super.setDao(dao);
	}

	public void validate(MovimientoStock entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}