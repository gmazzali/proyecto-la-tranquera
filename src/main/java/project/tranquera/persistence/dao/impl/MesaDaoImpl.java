package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.Mesa;
import project.tranquera.persistence.dao.MesaDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de las mesas.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class MesaDaoImpl extends TranqueraActiveBaseDaoImpl<Mesa, Long> implements MesaDao {
	private static final long serialVersionUID = 1L;
}