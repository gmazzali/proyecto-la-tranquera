package com.project.tranquera.app;

import com.common.util.app.ApplicacionParameter;
import com.common.util.business.holder.ApplicationContextMonitor;

/**
 * Los parámetros para la aplicación de la tranquera.
 * 
 * @since 21/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class TranqueraApplicationParameter extends ApplicacionParameter {
	private static final long serialVersionUID = 1L;

	private static final String VARIABLE = "tranquera.configuration.dir";

	private static final String VARIABLE_VALUE = "D:/DEV/SVN/proyecto-la-tranquera/trunk/src/main/config";
	// private static final String VARIABLE_VALUE = "C:/dev/svn/mios/Tranquera/trunk/src/main/config";

	private static final String[] FILES =
		{ "/com/project/tranquera/spring/general-application-context.xml" };

	private final ApplicationContextMonitor monitor = new ApplicationContextMonitor();

	@Override
	public String getConfigurationDirectoryVariable() {
		return VARIABLE;
	}

	@Override
	public String getConfigurationDirectoryPath() {
		return VARIABLE_VALUE;
	}

	@Override
	public String[] getConfigurationSpringFiles() {
		return FILES;
	}

	@Override
	public ApplicationContextMonitor getApplicationContextMonitor() {
		return monitor;
	}
}