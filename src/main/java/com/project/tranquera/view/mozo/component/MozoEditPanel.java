package com.project.tranquera.view.mozo.component;

import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.common.swing.domain.exception.SwingException;
import com.common.swing.view.component.panel.BaseEditPanel;
import com.project.tranquera.view.mozo.bean.MozoBean;

/**
 * El panel de edición de Mozos.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoEditPanel extends BaseEditPanel<MozoBean> {
	private static final long serialVersionUID = 1L;

	/**
	 * Los campos de nombre y apellido del mozo.
	 */
	private JTextField nombreField;
	private JTextField apellidoField;

	@Override
	public Integer getHeightSize() {
		return 100;
	}

	@Override
	public Integer getWidthSize() {
		return 300;
	}

	@Override
	protected void afterInit() {
	}

	@Override
	public void emptyFields() {
		this.nombreField.setText("");
		this.apellidoField.setText("");
	}

	@Override
	protected void fromFieldToBean(MozoBean bean) throws SwingException {
		bean.setNombre(this.nombreField.getText());
		bean.setApellido(this.apellidoField.getText());
	}

	@Override
	protected void fromBeanToField(MozoBean bean) throws SwingException {
		this.nombreField.setText(bean.getNombre());
		this.apellidoField.setText(bean.getApellido());
	}
}