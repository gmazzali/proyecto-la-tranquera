package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.Caja;
import project.tranquera.persistence.dao.CajaDao;

/**
 * La clase que implementa la interfaz base para los DAOs de las cajas.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class CajaDaoImpl extends TranqueraBaseDaoImpl<Caja, Long> implements CajaDao {
	private static final long serialVersionUID = 1L;
}