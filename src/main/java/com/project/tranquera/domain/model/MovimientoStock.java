package com.project.tranquera.domain.model;

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
 * Clase que representa un movimiento de stock de un menu dentro del sistema.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "MOVIMIENTOS_STOCKS")
@Entity(name = "MovimientoStock")
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

	private String descripcion;

	private BigDecimal movimiento = BigDecimal.ZERO;;

	private BigDecimal disponible = BigDecimal.ZERO;;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" MENU: ").append(this.menu).append(" FECHA: ").append(this.fecha).append(" MOVIMIENTO: ")
				.append(this.movimiento).append(" DISPONIBLE: ").append(this.disponible);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_MOVIMIENTO_STOCK")
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

	@Column(name = "FECHA", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "DESCRIPCION", columnDefinition = "varchar(150)", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "MOVIMIENTO", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(BigDecimal movimiento) {
		this.movimiento = movimiento;
	}

	@Column(name = "DISPONIBLE", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getDisponible() {
		return disponible;
	}

	public void setDisponible(BigDecimal disponible) {
		this.disponible = disponible;
	}
}