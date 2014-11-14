package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.MovimientoStock;
import project.tranquera.persistence.dao.MovimientoStockDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de los movimientos de stock.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class MovimientoStockDaoImpl extends TranqueraActiveBaseDaoImpl<MovimientoStock, Long> implements MovimientoStockDao {
	private static final long serialVersionUID = 1L;
}