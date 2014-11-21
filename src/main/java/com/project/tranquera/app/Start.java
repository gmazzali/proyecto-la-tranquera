package com.project.tranquera.app;

import com.common.util.app.Application;
import com.common.util.app.ApplicationLoader;
import com.common.util.business.holder.ApplicationContextHolder;

/**
 * La clase que nos permite arrancar el aplicativo.
 * 
 * @since 16/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class Start {

	public static void main(String[] args) {
		try {
			TranqueraApplicationParameter parameter = new TranqueraApplicationParameter();
			new ApplicationLoader().setApplicacionParameter(parameter).startContext();
			ApplicationContextHolder.getBean(Application.class).startApplication();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}