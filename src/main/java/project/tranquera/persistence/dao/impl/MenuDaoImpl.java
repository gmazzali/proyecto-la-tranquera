package project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import project.tranquera.domain.model.Menu;
import project.tranquera.persistence.dao.MenuDao;

/**
 * La clase que implementa la interfaz base para los DAOs de los menues.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class MenuDaoImpl extends TranqueraActiveBaseDaoImpl<Menu, Long> implements MenuDao {
	private static final long serialVersionUID = 1L;
}