package com.project.tranquera.business.service.impl;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.business.converter.Converter;
import com.common.util.business.converter.impl.ConverterServiceImpl;
import com.project.tranquera.business.service.TranqueraConverterService;

/**
 * La clase que nos permite manipular los conversores dentro de la tranquera.
 * 
 * @since 18/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Service
public class TranqueraConverterServiceImpl extends ConverterServiceImpl implements TranqueraConverterService {
	private static final long serialVersionUID = 1L;

	@Autowired
	private Collection<Converter<?, ?>> converters;

	@PostConstruct
	protected void init() {
		this.init(this.converters);
	}
}