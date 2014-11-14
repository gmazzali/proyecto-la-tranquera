package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un movimiento de stock de un menu dentro del sistema.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class MovimientoStock extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String MENU = "menu";
		public static final String FECHA = "fecha";
		public static final String MOVIMIENTO = "movimiento";
		public static final String DISPONIBLE = "disponible";
	}

	private Menu menu;

	private Date fecha;

	private BigDecimal movimiento;

	private BigDecimal disponible;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" MENU: ").append(this.menu).append(" FECHA: ").append(this.fecha).append(" MOVIMIENTO: ")
				.append(this.movimiento).append(" DISPONIBLE: ").append(this.disponible);
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(BigDecimal movimiento) {
		this.movimiento = movimiento;
	}

	public BigDecimal getDisponible() {
		return disponible;
	}

	public void setDisponible(BigDecimal disponible) {
		this.disponible = disponible;
	}
}