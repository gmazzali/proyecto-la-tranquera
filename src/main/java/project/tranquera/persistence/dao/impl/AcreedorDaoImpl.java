package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.Acreedor;
import project.tranquera.persistence.dao.AcreedorDao;

/**
 * La clase que implementa la interfaz base para los DAOs de los acreedores.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class AcreedorDaoImpl extends TranqueraActiveBaseDaoImpl<Acreedor, Long> implements AcreedorDao {
	private static final long serialVersionUID = 1L;
}