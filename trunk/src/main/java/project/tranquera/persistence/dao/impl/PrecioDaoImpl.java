package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.Precio;
import project.tranquera.persistence.dao.PrecioDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de los precios.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class PrecioDaoImpl extends TranqueraActiveBaseDaoImpl<Precio, Long> implements PrecioDao {
	private static final long serialVersionUID = 1L;
}