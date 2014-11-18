package com.project.tranquera.view.mozo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.swing.view.component.list.BaseList;
import com.common.swing.view.component.list.formatter.PropertyCellFormatter;
import com.common.swing.view.component.panel.BaseListPanel;
import com.project.tranquera.view.mozo.bean.MozoBean;

/**
 * El panel de la lista de Mozos.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoListPanel extends BaseListPanel<MozoBean> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MozoList mozoList;

	@Override
	protected void afterInit() {
	}

	@Override
	public Integer getHeightSize() {
		return 200;
	}

	@Override
	public Integer getWidthSize() {
		return 200;
	}

	@Override
	protected BaseList<MozoBean> createList() {
		return mozoList;
	}

	@Override
	protected PropertyCellFormatter<MozoBean> getFormatterProperty() {
		return new PropertyCellFormatter<MozoBean>(MozoBean.Attributes.NOMBRE_APELLIDO) {
			private static final long serialVersionUID = 1L;
		};
	}
}