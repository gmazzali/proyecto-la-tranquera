package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.ItemPedido;
import project.tranquera.persistence.dao.ItemDePedidoDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de los items de pedidos.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class ItemDePedidoDaoImpl extends TranqueraActiveBaseDaoImpl<ItemPedido, Long> implements ItemDePedidoDao {
	private static final long serialVersionUID = 1L;
}