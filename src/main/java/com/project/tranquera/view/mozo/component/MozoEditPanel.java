package com.project.tranquera.view.mozo.component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.swing.domain.exception.SwingException;
import com.common.swing.view.component.panel.BaseEditPanel;
import com.common.util.business.service.MessageService;
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

	@Autowired
	private MessageService messageService;

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
		JLabel nombreLabel = new JLabel();
		nombreLabel.setText(this.messageService.getMessage(""));
		nombreLabel.setBounds(5, 5, 100, 10);
		nombreLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		this.nombreField = new JTextField();
		nombreLabel.setBounds(5, 20, 100, 10);

		JLabel apellidoLabel = new JLabel();
		apellidoLabel.setText(this.messageService.getMessage(""));
		nombreLabel.setBounds(5, 20, 100, 10);
		apellidoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		this.apellidoField = new JTextField();
		nombreLabel.setBounds(5, 20, 100, 10);

		this.add(nombreLabel);
		this.add(this.nombreField);
		this.add(apellidoLabel);
		this.add(this.apellidoField);
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