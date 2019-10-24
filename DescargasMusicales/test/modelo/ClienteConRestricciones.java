package modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ClienteConRestricciones {

	@Test(expected = ControlParentalException.class)
	public void clienteConRestriccionDeGeneroNoPuedeDescargar() {
		List<String> generos = new ArrayList<String>();
		generos.add("rock");
		ICliente sheila = new ClienteRestringidoPorGenero(new Cliente(), generos);
		
		Cancion jijiji = new Cancion();
		jijiji.setGenero("rock");
		
		sheila.descargar(jijiji);
	}
	
	@Test(expected = ControlParentalException.class)
	public void clienteConRestriccionDeGeneroYArtistaNoPuedeDescargarPorElGenero() {
		List<String> generos = new ArrayList<String>();
		generos.add("rock");
		ICliente sheila = new ClienteRestringidoPorGenero(
				new ClienteRestringidoPorArtista(
						new Cliente(),
						"ricardo arjona"),
				generos);
		
		Cancion jijiji = new Cancion();
		jijiji.setGenero("rock");
		
		sheila.descargar(jijiji);
	}
	
	@Test(expected = ControlParentalException.class)
	public void clienteConRestriccionDeGeneroYArtistaNoPuedeDescargarPorElArtista() {
		List<String> generos = new ArrayList<String>();
		generos.add("rock");
		ICliente sheila = new ClienteRestringidoPorGenero(
				new ClienteRestringidoPorArtista(
						new Cliente(),
						"ricardo arjona"),
				generos);
		
		Cancion deVezEnMes = new Cancion();
		deVezEnMes.setArtista("ricardo arjona");
		deVezEnMes.setGenero("pop");
		
		sheila.descargar(deVezEnMes);
	}
	
	@Test
	public void clienteConRestriccionDeGeneroYArtistaPuedeDescargar() {
		List<String> generos = new ArrayList<String>();
		generos.add("rock");
		ICliente sheila = new ClienteRestringidoPorGenero(
				new ClienteRestringidoPorArtista(
						new Cliente(),
						"ricardo arjona"),
				generos);
		
		Cancion babyOneMoreTime = new Cancion();
		babyOneMoreTime.setArtista("britney spears");
		babyOneMoreTime.setGenero("pop");
		
		sheila.descargar(babyOneMoreTime);
		
		Assert.assertTrue(sheila.getItems().contains(babyOneMoreTime));
	}
}
