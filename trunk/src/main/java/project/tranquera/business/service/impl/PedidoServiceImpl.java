package project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tranquera.business.service.PedidoService;
import project.tranquera.domain.model.Pedido;
import project.tranquera.persistence.dao.PedidoDao;

import com.common.util.domain.exception.ServiceException;

/**
 * Clase que define los servicios base para el los pedidos.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class PedidoServiceImpl extends TranqueraBaseServiceImpl<Pedido, Long> implements PedidoService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPedidoDao(PedidoDao dao) {
		super.setDao(dao);
	}

	public void validate(Pedido entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}