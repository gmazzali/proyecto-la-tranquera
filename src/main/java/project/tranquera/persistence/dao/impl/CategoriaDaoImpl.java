package project.tranquera.persistence.dao.impl;

import project.tranquera.domain.model.Categoria;
import project.tranquera.persistence.dao.CategoriaDao;

import com.common.util.domain.annotation.Dao;

/**
 * La clase que implementa la interfaz base para los DAOs de las categorias de los menues.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Dao
public class CategoriaDaoImpl extends TranqueraActiveBaseDaoImpl<Categoria, Long> implements CategoriaDao {
	private static final long serialVersionUID = 1L;
}