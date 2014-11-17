package com.project.tranquera.view;

import javax.swing.UIManager;

import org.jdesktop.swingx.plaf.nimbus.NimbusLookAndFeel;

import com.common.util.business.holder.HolderApplicationContext;
import com.project.tranquera.business.service.MozoService;
import com.project.tranquera.domain.model.Mozo;

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
			// System.setProperty("tranquera.configuration.dir", "D:/DEV/SVN/proyecto-la-tranquera/trunk/src/main/config");
			System.setProperty("tranquera.configuration.dir", "C:/dev/svn/mios/Tranquera/trunk/src/main/config");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			String[] files = { "/com/project/tranquera/spring/general-application-context.xml" };
			HolderApplicationContext.initApplicationContext(files);

			Mozo mozo = new Mozo();
			mozo.setNombre("nombre mozo");
			mozo.setApellido("Apellido mozo");
			HolderApplicationContext.getBean(MozoService.class).save(mozo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}