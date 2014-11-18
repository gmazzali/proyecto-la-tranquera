package com.project.tranquera.view.mozo.bean;

import org.springframework.beans.BeanUtils;

import com.common.swing.view.bean.EditBean;
import com.common.swing.view.bean.RowBean;
import com.project.tranquera.domain.model.Mozo;

/**
 * El bean que corresponde a un mozo.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class MozoBean extends Mozo implements RowBean, EditBean<Mozo> {
	private static final long serialVersionUID = 1L;

	public interface Attributes extends Mozo.Attributes {
		public static final String NOMBRE_APELLIDO = "nombreApellido";
	}

	/**
	 * Permite recuperar el nombre y apellido del mozo.
	 * 
	 * @return El nombre y apellido del mozo.
	 */
	public String getNombreApellido() {
		return (this.getActive() ? "" : "(INACTIVO) ") + this.getApellido() + ", " + this.getNombre();
	}

	@Override
	public Mozo getEntity() {
		Mozo mozo = new Mozo();
		BeanUtils.copyProperties(this, mozo);
		return mozo;
	}

	@Override
	public void initialize() {
		this.setNombre("");
		this.setApellido("");
	}
}