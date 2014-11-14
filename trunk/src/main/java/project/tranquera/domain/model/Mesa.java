package project.tranquera.domain.model;

/**
 * Clase que crea objetos que representan una mesa del local.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Mesa extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String PEDIDO = "pedido";
		public static final String DISPONIBILIDAD = "disponibilidad";
	}

	private Pedido pedido;

	private Boolean disponibilidad = Boolean.TRUE;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" DISPONIBILIDAD: ").append(this.disponibilidad).append(" PEDIDO: ").append(this.pedido);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}