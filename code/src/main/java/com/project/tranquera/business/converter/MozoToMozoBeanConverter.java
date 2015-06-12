package com.project.tranquera.business.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.common.util.business.converter.Converter;
import com.project.tranquera.domain.model.Mozo;
import com.project.tranquera.view.mozo.bean.MozoBean;

/**
 * Permite convertir un mozo en un bean de mozo.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Component
public class MozoToMozoBeanConverter extends Converter<Mozo, MozoBean> {
	private static final long serialVersionUID = 1L;

	@Override
	public MozoBean convert(Mozo source) {
		MozoBean bean = new MozoBean();
		BeanUtils.copyProperties(source, bean);
		return bean;
	}
}