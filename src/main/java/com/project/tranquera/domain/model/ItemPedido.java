package com.project.tranquera.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.common.util.domain.annotation.Model;

/**
 * Clase que representa un item de un pedido en particular.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "ITEMS_PEDIDOS")
@Entity(name = "ItemPedido")
public class ItemPedido extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String PEDIDO = "pedido";
		public static final String MENU = "menu";
		public static final String CANTIDAD = "cantidad";
	}

	private Pedido pedido;

	private Menu menu;

	private Integer cantidad = 0;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" PEDIDO: ").append(this.pedido).append(" MENU: ").append(this.menu).append(" CANTIDAD: ")
				.append(this.cantidad);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_ITEM_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO", insertable = true, updatable = true, nullable = false)
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU", insertable = true, updatable = true, nullable = false)
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "CANTIDAD", columnDefinition = "decimal(12,4)", nullable = false)
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}