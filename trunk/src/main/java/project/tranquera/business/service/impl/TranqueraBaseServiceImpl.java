package project.tranquera.business.service.impl;

import java.io.Serializable;

import project.tranquera.business.service.TranqueraBaseService;

import com.common.util.business.service.impl.BaseServiceImpl;
import com.common.util.domain.model.entity.Persistence;

/**
 * La clase que define los servicios base para el sistema.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 * 
 * @param <E>
 *            La clase de entidad que vamos a usar dentro del servicio.
 * @param <PK>
 *            La PK de la entidad del servicio.
 */
public abstract class TranqueraBaseServiceImpl<E extends Persistence<PK>, PK extends Serializable> extends BaseServiceImpl<E, PK> implements
		TranqueraBaseService<E, PK> {
	private static final long serialVersionUID = 1L;
}