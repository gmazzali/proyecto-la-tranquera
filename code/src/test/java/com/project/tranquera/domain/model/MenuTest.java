package com.project.tranquera.domain.model;

import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.common.util.business.tool.date.DateUtil;

/**
 * Clase utilizada para probar el menu.
 * 
 * @since 17/11/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

	@BeforeClass
	public static void initClass() {
		BasicConfigurator.configure();
	}

	@Test
	public void testGetPrecio() throws Exception {
		Menu menu = new Menu();

		Precio precio = new Precio();
		precio.setMenu(menu);
		precio.setFechaInicio(DateUtil.createDate("01/01/2014"));
		precio.setFechaFin(DateUtil.createDate("31/01/2014"));
		precio.setPrecio(new BigDecimal(10));
		menu.addPrecio(precio);
		precio = new Precio();
		precio.setMenu(menu);
		precio.setFechaInicio(DateUtil.createDate("01/02/2014"));
		precio.setFechaFin(DateUtil.createDate("28/02/2014"));
		precio.setPrecio(new BigDecimal(20));
		menu.addPrecio(precio);
		precio = new Precio();
		precio.setMenu(menu);
		precio.setFechaInicio(DateUtil.createDate("01/03/2014"));
		precio.setPrecio(new BigDecimal(30));
		menu.addPrecio(precio);

		BigDecimal importe = menu.getPrecio(DateUtil.createDate("01/01/2014"));
		Assert.assertEquals(new BigDecimal(10), importe);
		importe = menu.getPrecio(DateUtil.createDate("15/01/2014"));
		Assert.assertEquals(new BigDecimal(10), importe);
		importe = menu.getPrecio(DateUtil.createDate("31/01/2014"));
		Assert.assertEquals(new BigDecimal(10), importe);
		importe = menu.getPrecio(DateUtil.createDate("01/02/2014"));
		Assert.assertEquals(new BigDecimal(20), importe);
		importe = menu.getPrecio(DateUtil.createDate("14/02/2014"));
		Assert.assertEquals(new BigDecimal(20), importe);
		importe = menu.getPrecio(DateUtil.createDate("28/02/2014"));
		Assert.assertEquals(new BigDecimal(20), importe);
		importe = menu.getPrecio(DateUtil.createDate("01/03/2014"));
		Assert.assertEquals(new BigDecimal(30), importe);
		importe = menu.getPrecio(DateUtil.createDate("01/05/2014"));
		Assert.assertEquals(new BigDecimal(30), importe);
		importe = menu.getPrecio(DateUtil.createDate("01/08/2014"));
		Assert.assertEquals(new BigDecimal(30), importe);
	}
}