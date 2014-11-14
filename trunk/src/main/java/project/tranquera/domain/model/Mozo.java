package project.tranquera.domain.model;

/**
 * Clase destinada a representar a un mozo del restaurante con sus datos.
 *
 * @since 11/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Mozo extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String NOMBRE = "nombre";
		public static final String APELLIDO = "apellido";
	}

	private String nombre;

	private String apellido;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" NOMBRE: ").append(this.nombre).append(" APELLIDO: ").append(this.apellido);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}