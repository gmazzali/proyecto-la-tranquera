package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.MovimientoStock;
import project.tranquera.persistence.dao.MovimientoStockDao;

/**
 * La clase que implementa la interfaz base para los DAOs de los movimientos de stock.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class MovimientoStockDaoImpl extends TranqueraActiveBaseDaoImpl<MovimientoStock, Long> implements MovimientoStockDao {
	private static final long serialVersionUID = 1L;
}