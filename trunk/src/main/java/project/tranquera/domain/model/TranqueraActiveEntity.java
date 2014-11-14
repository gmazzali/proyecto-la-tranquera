package project.tranquera.domain.model;

import java.io.Serializable;

import com.common.util.domain.model.entity.ActiveEntity;

/**
 * Clase base para las entidades activables.
 * 
 * @author Guillermo
 *
 * @param <PK>
 *            La clase de las claves primarias.
 */
public abstract class TranqueraActiveEntity<PK extends Serializable> extends ActiveEntity<PK> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends ActiveEntity.Attributes {
	}

	public Boolean getActive() {
		return active;
	}
}