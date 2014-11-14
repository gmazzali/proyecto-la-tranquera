package project.tranquera.domain.model;

/**
 * Clase que representa un item de un pedido en particular.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
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

	private Integer cantidad;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" PEDIDO: ").append(this.pedido).append(" MENU: ").append(this.menu).append(" CANTIDAD: ")
				.append(this.cantidad);
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}