package com.project.tranquera.domain.model;

import java.math.BigDecimal;

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


import com.common.util.domain.annotation.Model;
import com.project.tranquera.domain.dto.TipoCaja;

/**
 * Clase utilizada para representar un monto de inicio de una caja para cada tipo.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "MONTOS_INICIOS")
@Entity(name = "MontoInicio")
public class MontoInicio extends TranqueraEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraEntity.Attributes {
		public static final String CAJA = "caja";
		public static final String TIPO_CAJA = "tipoCaja";
		public static final String MONTO = "monto";
	}

	private Caja caja;

	private TipoCaja tipoCaja;

	private BigDecimal monto;

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" CAJA: ").append(this.caja).append(" TIPO CAJA: ").append(this.tipoCaja).append(" MONTO: ")
				.append(this.monto);
		return stringBuffer.toString();
	}

	@Id
	@Column(name = "ID_MONTO_INICIO")
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

	@Column(name = "MONTO", columnDefinition = "decimal(12,4)", nullable = false)
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
}