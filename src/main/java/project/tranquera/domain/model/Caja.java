package project.tranquera.domain.model;

import java.util.Date;

/**
 * Clase utilizada para representar una caja.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Caja extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String FECHA_APERTURA = "fechaApertura";
		public static final String FECHA_CIERRE = "fechaCierre";
	}

	private Date fechaApertura;

	private Date fechaCierre;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" FECHA APERTURA: ").append(this.fechaApertura).append(" FECHA CIERRE: ")
				.append(this.fechaCierre);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
}