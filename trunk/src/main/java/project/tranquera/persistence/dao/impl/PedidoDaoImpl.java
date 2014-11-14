package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.Pedido;
import project.tranquera.persistence.dao.PedidoDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de los pedidos.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class PedidoDaoImpl extends TranqueraActiveBaseDaoImpl<Pedido, Long> implements PedidoDao {
	private static final long serialVersionUID = 1L;
}