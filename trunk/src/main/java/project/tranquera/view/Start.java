package project.tranquera.view;

import javax.swing.UIManager;

import org.jdesktop.swingx.plaf.nimbus.NimbusLookAndFeel;

import com.common.util.business.holder.HolderApplicationContext;

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
			System.setProperty("tranquera.configuration.dir", "D:/DEV/SVN/proyecto-la-tranquera/trunk/src/main/config");
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			String[] files =
				{ "/com/project/tranquera/spring/general-application-context.xml" };
			HolderApplicationContext.initApplicationContext(files);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}