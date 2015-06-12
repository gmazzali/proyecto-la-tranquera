package com.project.tranquera.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.project.tranquera.domain.dto.TipoCaja;

/**
 * Clase que representa una transacción de caja.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "TRANSACCIONES")
@Entity(name = "Transaccion")
public class Transaccion extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String TIPO_TRANSACCION = "tipoTransaccion";
		public static final String CAJA = "caja";
		public static final String TIPO_CAJA = "tipoCaja";
		public static final String FECHA = "fecha";
		public static final String IMPORTE = "importe";
		public static final String OBSERVACION = "observacion";
	}

	private Caja caja;

	private TipoCaja tipoCaja;

	private TipoTransaccion tipoTransaccion;

	private Date fecha;

	private BigDecimal importe;

	private String observacion;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" TIPO TRANSACCION: ").append(this.tipoTransaccion).append(" CAJA: ").append(this.caja)
				.append(" TIPO CAJA: ").append(this.tipoCaja).append(" FECHA: ").append(this.fecha).append(" IMPORTE: ").append(this.importe)
				.append(" OBSERVACION: ").append(this.observacion);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_TRANSACCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_CAJA", referencedColumnName = "ID_CAJA", insertable = true, updatable = true, nullable = false)
	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	@Column(name = "TIPO_CAJA", columnDefinition = "varchar(20)", nullable = false)
	@Enumerated(EnumType.STRING)
	public TipoCaja getTipoCaja() {
		return tipoCaja;
	}

	public void setTipoCaja(TipoCaja tipoCaja) {
		this.tipoCaja = tipoCaja;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_TIPO_TRANSACCION", referencedColumnName = "ID_TIPO_TRANSACCION", insertable = true, updatable = true, nullable = false)
	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
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

	@Column(name = "OBSERVACION", columnDefinition = "varchar(100)", nullable = false)
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}