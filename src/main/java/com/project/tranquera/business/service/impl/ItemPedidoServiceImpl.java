package com.project.tranquera.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.common.util.domain.exception.ServiceException;
import com.project.tranquera.business.service.ItemPedidoService;
import com.project.tranquera.domain.model.ItemPedido;
import com.project.tranquera.persistence.dao.ItemPedidoDao;

/**
 * Clase que define los servicios base para el los items de pedidos.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class ItemPedidoServiceImpl extends TranqueraBaseServiceImpl<ItemPedido, Long> implements ItemPedidoService {
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setItemPedidoDao(ItemPedidoDao dao) {
		super.setDao(dao);
	}

	public void validate(ItemPedido entity) throws ServiceException {
		// TODO Auto-generated method stub
	}
}