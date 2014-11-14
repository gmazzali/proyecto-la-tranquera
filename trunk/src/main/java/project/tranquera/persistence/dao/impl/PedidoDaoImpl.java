package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.Pedido;
import project.tranquera.persistence.dao.PedidoDao;

/**
 * La clase que implementa la interfaz base para los DAOs de los pedidos.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class PedidoDaoImpl extends TranqueraActiveBaseDaoImpl<Pedido, Long> implements PedidoDao {
	private static final long serialVersionUID = 1L;
}