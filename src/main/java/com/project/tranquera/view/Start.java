package com.project.tranquera.view;

import javax.swing.UIManager;

import org.jdesktop.swingx.plaf.nimbus.NimbusLookAndFeel;

import com.common.util.business.holder.HolderApplicationContext;
import com.common.util.business.holder.LoaderApplicationContext;
import com.common.util.business.holder.MonitorApplicationContext;
import com.project.tranquera.view.mozo.MozoListForm;

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
			final MonitorApplicationContext monitorApplicationContext = new MonitorApplicationContext();
			// new Thread() {
			// @Override
			// public void run() {
			// while (!monitorApplicationContext.isContextComplete()) {
			// System.out.println("MONITOR BEAN COUNT: " + monitorApplicationContext.getBeanCount());
			// System.out.println("MONITOR CURRENT BEAN COUNT: " + monitorApplicationContext.getCurrentBeanCount());
			// System.out.println("MONITOR CURRENT BEAN NAME: " + monitorApplicationContext.getCurrentBeanName());
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// }
			// };
			// }.start();
			LoaderApplicationContext.initApplicationContext(monitorApplicationContext, files);

			// Mozo mozo = new Mozo();
			// mozo.setNombre("nombre mozo");
			// mozo.setApellido("Apellido mozo");
			// HolderApplicationContext.getBean(MozoService.class).save(mozo);

			HolderApplicationContext.getBean(MozoListForm.class).setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}