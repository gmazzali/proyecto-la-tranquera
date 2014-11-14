package project.tranquera.domain.model;

/**
 * Clase que representa un tipo de transacción de caja.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class TipoTransaccion extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String DESCRIPCION = "descripcion";
		public static final String MODIFICABLE = "modificable";
	}

	private String descripcion;

	private Boolean modificable;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" DESCRIPCION: ").append(this.descripcion).append(" MODIFICABLE: ").append(this.modificable);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getModificable() {
		return modificable;
	}

	public void setModificable(Boolean modificable) {
		this.modificable = modificable;
	}
}