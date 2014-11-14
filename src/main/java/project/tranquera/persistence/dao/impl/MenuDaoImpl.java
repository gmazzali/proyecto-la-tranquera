package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.Menu;
import project.tranquera.persistence.dao.MenuDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de los menues.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class MenuDaoImpl extends TranqueraActiveBaseDaoImpl<Menu, Long> implements MenuDao {
	private static final long serialVersionUID = 1L;
}