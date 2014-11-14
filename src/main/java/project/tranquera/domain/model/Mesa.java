package project.tranquera.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.common.util.domain.annotation.Model;

/**
 * Clase que crea objetos que representan una mesa del local.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "MESAS")
@Entity(name = "Mesa")
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

	private Boolean disponible = Boolean.TRUE;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" DISPONIBILIDAD: ").append(this.disponible).append(" PEDIDO: ").append(this.pedido);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_MESA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO", insertable = true, updatable = true, nullable = false)
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Column(name = "DISPONIBLE", columnDefinition = "bool", nullable = false)
	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
}