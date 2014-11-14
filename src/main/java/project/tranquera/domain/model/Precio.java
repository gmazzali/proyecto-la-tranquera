package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.common.util.domain.annotation.Model;

/**
 * Clase utilizada para representar un precio de un menu.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "PRECIOS")
@Entity(name = "Precio")
public class Precio extends TranqueraEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraEntity.Attributes {
		public static final String MENU = "menu";
		public static final String PRECIO = "precio";
		public static final String FECHA_DESDE = "fechaDesde";
		public static final String FECHA_HASTA = "fechahasta";
	}

	private Menu menu;

	private BigDecimal precio = BigDecimal.ZERO;;

	private Date fechaDesde;

	private Date fechaHasta;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" PRECIO: ").append(this.precio).append(" FECHA DESDE: ").append(this.fechaDesde)
				.append(" FECHA HASTA: ").append(this.fechaHasta);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_PRECIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU", insertable = true, updatable = true, nullable = false)
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "PRECIO", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Column(name = "FECHA_DESDE", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	@Column(name = "FECHA_HASTA", columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}