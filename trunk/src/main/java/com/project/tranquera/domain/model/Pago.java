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
		public static final String ACREEDOR = "acreedor";
		public static final String TRANSACCION = "transaccion";
		public static final String FECHA = "fecha";
		public static final String IMPORTE = "importe";
	}

	private Acreedor acreedor;

	private Transaccion transaccion;

	private Date fecha;

	private BigDecimal importe;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" ACREEDOR: ").append(this.acreedor).append(" TRANSACCION: ").append(this.transaccion)
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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_ACREEDOR", referencedColumnName = "ID_ACREEDOR", insertable = true, updatable = true, nullable = false)
	public Acreedor getAcreedor() {
		return acreedor;
	}

	public void setAcreedor(Acreedor acreedor) {
		this.acreedor = acreedor;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_TRANSACCION", referencedColumnName = "ID_TRANSACCION", insertable = true, updatable = true, nullable = false)
	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	@Column(name = "FECHA", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "IMPORTE", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
}