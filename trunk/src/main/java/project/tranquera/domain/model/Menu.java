package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.common.util.business.tool.date.DateUtil;
import com.common.util.business.util.DatePrecisionEnum;
import com.common.util.domain.annotation.Model;

/**
 * Clase utilizada para representar un objeto del tipo de menu.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "MENUS")
@Entity(name = "Menu")
public class Menu extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String NOMBRE = "nombre";
		public static final String CATEGORIA = "categoria";
		public static final String PRECIOS = "precios";
		public static final String MOVIMIENTO_STOCKS = "movimientoStocks";
	}

	private String nombre;

	private Categoria categoria;

	private List<Precio> precios = new ArrayList<Precio>();

	private List<MovimientoStock> movimientoStocks = new ArrayList<MovimientoStock>();

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" CATEGORIA: ").append(this.categoria).append(" NOMBRE: ").append(this.nombre);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_MENU")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "NOMBRE", columnDefinition = "varchar(100)", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String descripcion) {
		this.nombre = descripcion;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA", insertable = true, updatable = true, nullable = false)
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Precio.Attributes.MENU, orphanRemoval = true)
	public List<Precio> getPrecios() {
		return precios;
	}

	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}

	public void addPrecio(Precio precio) {
		if (precio != null) {
			this.precios.add(precio);
		}
	}

	public void removePrecio(Precio precio) {
		if (precio != null) {
			this.precios.remove(precio);
		}
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = MovimientoStock.Attributes.MENU, orphanRemoval = true)
	@Where(clause = MovimientoStock.Attributes.ACTIVE + " = 1")
	public List<MovimientoStock> getMovimientoStocks() {
		return movimientoStocks;
	}

	public void setMovimientoStocks(List<MovimientoStock> movimientoStocks) {
		this.movimientoStocks = movimientoStocks;
	}

	public void addMovimientoStock(MovimientoStock movimientoStock) {
		if (movimientoStock != null) {
			this.movimientoStocks.add(movimientoStock);
		}
	}

	public void removeMovimientoStock(MovimientoStock movimientoStock) {
		if (movimientoStock != null) {
			this.movimientoStocks.remove(movimientoStock);
		}
	}

	@Transient
	public BigDecimal getPrecio(Date fecha) {
		Precio precio = null;
		for (Precio p : precios) {
			if (DateUtil.between(fecha, p.getFechaDesde(), p.getFechaHasta(), DatePrecisionEnum.MILLISECOND)) {
				precio = p;
				break;
			}
		}
		return precio != null ? precio.getPrecio() : null;
	}
}