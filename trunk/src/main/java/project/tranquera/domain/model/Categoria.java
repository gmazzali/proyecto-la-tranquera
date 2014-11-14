package project.tranquera.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que crea un objeto que representa una categoria de menues.
 * 
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Categoria extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String NOMBRE = "nombre";
		public static final String MENUES = "menues";
	}

	private String nombre;

	private List<Menu> menues = new ArrayList<Menu>();

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" NOMBRE: ").append(this.nombre);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Menu> getMenues() {
		return this.menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public void addMenu(Menu menu) {
		if (menu != null) {
			this.menues.add(menu);
		}
	}

	public void removeMenu(Menu menu) {
		if (menu != null) {
			this.menues.remove(menu);
		}
	}
}