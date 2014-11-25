package com.project.tranquera.view.mozo;

import java.util.Collection;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.swing.view.action.EditAction;
import com.common.swing.view.component.panel.BaseEditPanel;
import com.common.swing.view.decorator.ButtonDecorator;
import com.common.util.business.service.MessageService;
import com.crud.swing.view.form.edit.BaseEditForm;
import com.project.tranquera.view.base.TranqueraButtonDecorator;
import com.project.tranquera.view.mozo.bean.MozoBean;
import com.project.tranquera.view.mozo.component.MozoEditPanel;

/**
 * El formulario de edición de Mozos.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoEditForm extends BaseEditForm<MozoBean> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MozoEditPanel mozoEditPanel;

	@Autowired
	private MessageService messageService;

	@Override
	protected String getNewTitle() {
		return this.messageService.getMessage("");
	}

	@Override
	protected String getEditTitle() {
		return this.messageService.getMessage("");
	}

	@Override
	protected String getViewTitle() {
		return this.messageService.getMessage("");
	}

	@Override
	protected void afterInit() {
	}

	@Override
	protected BaseEditPanel<MozoBean> createEditPanel() {
		return mozoEditPanel;
	}

	@Override
	protected ButtonDecorator getConfirmButtonDecorator() {
		return new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("Aceptar");
			}
		};
	}

	@Override
	protected ButtonDecorator getCancelButtonDecorator() {
		return new TranqueraButtonDecorator() {
			private static final long serialVersionUID = 1L;

			@Override
			public void decorateButton(JButton button) {
				super.decorateButton(button);
				button.setText("Cancelar");
			}
		};
	}

	@Override
	protected Collection<EditAction<MozoBean>> getEditActions() {
		return null;
	}
}