package com.project.tranquera.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.common.util.domain.annotation.Model;

/**
 * Clase utilizada para representar una caja.
 * 
 * @since 13/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Model
@Table(name = "CAJAS")
@Entity(name = "Caja")
public class Caja extends TranqueraActiveEntity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * La interfaz que contiene el nombre de los atributos de esta entidad.
	 */
	public interface Attributes extends TranqueraActiveEntity.Attributes {
		public static final String FECHA_APERTURA = "fechaApertura";
		public static final String FECHA_CIERRE = "fechaCierre";
		public static final String MONTO_INICIALES = "montoIniciales";
	}

	private Date fechaApertura;

	private Date fechaCierre;

	private List<MontoInicio> montoIniciales = new ArrayList<MontoInicio>();

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(super.toString()).append(" FECHA APERTURA: ").append(this.fechaApertura).append(" FECHA CIERRE: ")
				.append(this.fechaCierre);
		return stringBuffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_CAJA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "FECHA_APERTURA", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	@Column(name = "FECHA_CIERRE", columnDefinition = "timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = MontoInicio.Attributes.CAJA, orphanRemoval = true)
	public List<MontoInicio> getMontoIniciales() {
		return montoIniciales;
	}

	public void setMontoIniciales(List<MontoInicio> montoIniciales) {
		this.montoIniciales = montoIniciales;
	}

	public void addMontoInicio(MontoInicio montoInicio) {
		if (montoInicio != null) {
			this.montoIniciales.add(montoInicio);
		}
	}

	public void removeMontoInicio(MontoInicio montoInicio) {
		if (montoInicio != null) {
			this.montoIniciales.remove(montoInicio);
		}
	}
}