package com.project.tranquera.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.tranquera.domain.model.Mozo;
import com.project.tranquera.persistence.dao.MozoDao;


/**
 * La clase que implementa la interfaz base para los DAOs de los mozos.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Repository
public class MozoDaoImpl extends TranqueraActiveBaseDaoImpl<Mozo, Long> implements MozoDao {
	private static final long serialVersionUID = 1L;
}