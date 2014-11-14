package project.tranquera.business.service;

import java.io.Serializable;

import com.common.util.business.service.BaseService;
import com.common.util.domain.model.entity.Persistence;

/**
 * Interfaz que define los servicios base para el sistema.
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
public interface TranqueraBaseService<E extends Persistence<PK>, PK extends Serializable> extends BaseService<E, PK> {
}