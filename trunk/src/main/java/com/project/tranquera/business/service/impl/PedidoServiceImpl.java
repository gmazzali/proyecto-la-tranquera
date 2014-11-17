package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.PedidoService;
import com.project.tranquera.domain.model.Pedido;
import com.project.tranquera.persistence.dao.PedidoDao;

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