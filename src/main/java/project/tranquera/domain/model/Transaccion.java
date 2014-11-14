package project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import project.tranquera.domain.TipoDeTransaccion;

/**
 * Clase que representa una transacción de caja.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Transaccion extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String TIPO_TRANSACCION = "tipoDeTransaccion";
		public static final String CAJA = "caja";
		public static final String TIPO_CAJA = "tipoCaja";
		public static final String FECHA = "fecha";
		public static final String IMPORTE = "importe";
		public static final String OBSERVACION = "observacion";
	}

	private TipoDeTransaccion tipoDeTransaccion;

	private Caja caja;

	private TipoCaja tipoCaja;

	private Date fecha;

	private BigDecimal importe;

	private String observacion;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" TIPO TRANSACCION: ").append(this.tipoDeTransaccion).append(" CAJA: ").append(this.caja)
				.append(" TIPO CAJA: ").append(this.tipoCaja).append(" FECHA: ").append(this.fecha).append(" IMPORTE: ").append(this.importe)
				.append(" OBSERVACION: ").append(this.observacion);
		return stringBuffer.toString();
	}

	public Long getId() {
		return id;
	}

	public TipoDeTransaccion getTipoDeTransaccion() {
		return tipoDeTransaccion;
	}

	public void setTipoDeTransaccion(TipoDeTransaccion tipoDeTransaccion) {
		this.tipoDeTransaccion = tipoDeTransaccion;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public TipoCaja getTipoCaja() {
		return tipoCaja;
	}

	public void setTipoCaja(TipoCaja tipoCaja) {
		this.tipoCaja = tipoCaja;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}