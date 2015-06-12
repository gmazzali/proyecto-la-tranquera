package com.project.tranquera.view.mozo.component;

import javax.annotation.PostConstruct;
import javax.swing.ListSelectionModel;

import org.springframework.stereotype.Component;

import com.common.swing.view.component.list.BaseList;
import com.project.tranquera.view.mozo.bean.MozoBean;

/**
 * La lista de Mozos.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoList extends BaseList<MozoBean> {
	private static final long serialVersionUID = 1L;

	@Override
	@PostConstruct
	protected void init() {
		super.init();
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}