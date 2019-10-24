package modelo;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ClientesTest {

	@Test
	public void esNuevo_unClienteEsNuevo() {
		Cliente pepe = new Cliente();
		pepe.setDiaDeSuscripcion(new Date());
		
		Assert.assertTrue(pepe.esNuevo());
	}
	
	@Test
	public void esNuevo_unClienteNoEsNuevo() {
		Cliente pepe = new Cliente();
		pepe.setDiaDeSuscripcion(new Date());
		
		Assert.assertFalse(pepe.esNuevo());
	}
	
	@Test
	public void totalAFacturar_clienteSinItemsNoTieneNadaAFacturar() {
		Cliente pepe = new Cliente();
		
		double total = pepe.totalAFacturar();
		
		Assert.assertEquals(0, total, 0.1);
	}
	
	@Test
	public void totalAFacturar_clienteConUnItemTieneAFacturarElCostoDeEseItem() {
		Cliente pepe = new Cliente();
		Item itemMock = Mockito.mock(Item.class);
		Mockito.when(itemMock.costo()).thenReturn(4.0);
		pepe.agregarItem(itemMock);
		
		double total = pepe.totalAFacturar();
		
		Assert.assertEquals(4.0, total, 0.1);
	}
	
	@Test
	public void totalAFacturar_clienteConMuchosItemsTieneAFacturarLaSumaDelCostoDeEsosItems() {
		Cliente pepe = new Cliente();
		
		Item itemMock = Mockito.mock(Item.class);
		Mockito.when(itemMock.costo()).thenReturn(4.0);
		pepe.agregarItem(itemMock);
		
		Item itemMock2 = Mockito.mock(Item.class);
		Mockito.when(itemMock2.costo()).thenReturn(6.4);
		pepe.agregarItem(itemMock2);
		
		double total = pepe.totalAFacturar();
		
		Assert.assertEquals(10.4, total, 0.1);
	}
	
}
