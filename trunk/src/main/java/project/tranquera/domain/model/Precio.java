package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase utilizada para representar un precio de un menu.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Precio extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String MENU = "menu";
		public static final String PRECIO = "precio";
		public static final String FECHA_DESDE = "fechaDesde";
		public static final String FECHA_HASTA = "fechahasta";
	}

	private Menu menu;

	private BigDecimal precio;

	private Date fechaDesde;

	private Date fechaHasta;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" PRECIO: ").append(this.precio).append(" FECHA DESDE: ").append(this.fechaDesde)
				.append(" FECHA HASTA: ").append(this.fechaHasta);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}