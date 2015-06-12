package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.ItemPedido;
import com.project.tranquera.persistence.dao.ItemPedidoDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los items de pedidos.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class ItemPedidoDaoImpl extends TranqueraActiveBaseDaoImpl<ItemPedido, Long> implements ItemPedidoDao {
	private static final long serialVersionUID = 1L;
}