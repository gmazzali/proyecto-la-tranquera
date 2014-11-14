package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.Mesa;
import project.tranquera.persistence.dao.MesaDao;

/**
 * La clase que implementa la interfaz base para los DAOs de las mesas.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class MesaDaoImpl extends TranqueraActiveBaseDaoImpl<Mesa, Long> implements MesaDao {
	private static final long serialVersionUID = 1L;
}