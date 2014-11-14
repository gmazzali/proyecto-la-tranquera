package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa un pedido de una mesa dentro del restaurante.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
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

	private BigDecimal descuento;

	private BigDecimal cubiertos;

	private Transaccion transaccion;

	private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" FECHA: ").append(this.fecha).append(" MESA: ").append(this.mesa).append(" MOZO: ")
				.append(this.mozo).append(" DESCUENTO: ").append(this.descuento).append(" CUBIERTOS: ").append(this.cubiertos)
				.append(" TRANSACCION: ").append(this.transaccion);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getCubiertos() {
		return cubiertos;
	}

	public void setCubiertos(BigDecimal cubiertos) {
		this.cubiertos = cubiertos;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

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
}