package com.project.tranquera.domain.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.common.util.domain.annotation.Model;

/**
 * Clase que representa un pedido de una mesa dentro del restaurante.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "PEDIDOS")
@Entity(name = "Pedido")
public class Pedido extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String FECHA = "fecha";
		public static final String MESA = "mesa";
		public static final String MOZO = "mozo";
		public static final String DESCUENTO = "descuento";
		public static final String CUBIERTOS = "cubiertos";
		public static final String TRANSACCION = "transaccion";
		public static final String ITEM_PEDIDO = "itemDePedidos";
	}

	private Date fecha;

	private Mesa mesa;

	private Mozo mozo;

	private BigDecimal descuento = BigDecimal.ZERO;

	private BigDecimal cubiertos = BigDecimal.ZERO;

	private BigDecimal importe = BigDecimal.ZERO;

	private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();

	private Transaccion transaccion;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" FECHA: ").append(this.fecha).append(" MESA: ").append(this.mesa).append(" MOZO: ")
				.append(this.mozo).append(" DESCUENTO: ").append(this.descuento).append(" CUBIERTOS: ").append(this.cubiertos)
				.append(" TRANSACCION: ").append(this.transaccion);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "FECHA", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_MESA", referencedColumnName = "ID_MESA", insertable = true, updatable = true, nullable = false)
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_MOZO", referencedColumnName = "ID_MOZO", insertable = true, updatable = true, nullable = false)
	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	@Column(name = "DESCUENTO", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	@Column(name = "CUBIERTOS", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getCubiertos() {
		return cubiertos;
	}

	public void setCubiertos(BigDecimal cubiertos) {
		this.cubiertos = cubiertos;
	}

	@Column(name = "IMPORTE", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ItemPedido.Attributes.PEDIDO, orphanRemoval = true)
	@Where(clause = ItemPedido.Attributes.ACTIVE + " = 1")
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public void addItemPedido(ItemPedido itemPedido) {
		if (itemPedido != null) {
			this.itemPedidos.add(itemPedido);
		}
	}

	public void removeItemPedido(ItemPedido itemPedido) {
		if (itemPedido != null) {
			this.itemPedidos.remove(itemPedido);
		}
	}

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_TRANSACCION", referencedColumnName = "ID_TRANSACCION", insertable = true, updatable = true, nullable = false)
	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	@Transient
	public BigDecimal recalcularImporte(Date fecha) {
		BigDecimal total = BigDecimal.ZERO;
		for (ItemPedido itemPedido : this.itemPedidos) {
			total = total.add(itemPedido.getMenu().getPrecio(fecha));
		}
		total = total.add(this.cubiertos).subtract(this.descuento);
		return total;
	}
}