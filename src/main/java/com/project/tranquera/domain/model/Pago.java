package com.project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.util.domain.annotation.Model;

/**
 * Clase que representa un pago a un acreedor.
 * 
 * @since 14/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "PAGOS")
@Entity(name = "Pago")
public class Pago extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String PROVEEDOR = "proveedor";
		public static final String TRANSACCION = "transaccion";
		public static final String FECHA = "fecha";
		public static final String IMPORTE = "importe";
	}

	private Acreedor proveedor;

	private Transaccion transaccion;

	private Date fecha;

	private BigDecimal importe;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" PROVEEDOR: ").append(this.proveedor).append(" TRANSACCION: ").append(this.transaccion)
				.append(" FECHA: ").append(this.fecha).append(" IMPORTE: ").append(this.importe);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_PAGO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Acreedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Acreedor proveedor) {
		this.proveedor = proveedor;
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
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
}