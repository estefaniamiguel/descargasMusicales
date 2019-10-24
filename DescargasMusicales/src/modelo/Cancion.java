package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cancion extends Item {

	private static final double COSTO_HIT = 10;
	private static final double COSTO_LARGA = 4;
	private static final double COSTO_DEFAULT = 3;
	private double duracion;
	private String genero;
	private String artista;
	private String titulo;

	@Override
	boolean esHit() {
		return descargas > 1000;
	}

	@Override
	double precioDeHit() {
		return COSTO_HIT;
	}

	@Override
	double precioNoHit() {
		if (esLarga()) {
			return COSTO_LARGA;
		} else {
			return COSTO_DEFAULT;
		}
	}

	private boolean esLarga() {
		return duracion > 5;
	}

	@Override
	List<String> getGeneros() {
		List<String> lista = new ArrayList<String>();
		lista.add(genero);
		return lista;
	}

	public String getGenero() {
		return genero;
	}

	@Override
	boolean esDeArtista(String artista) {
		return artista == this.artista;
	}

	@Override
	boolean tituloContiene(String palabraARestringir) {
		return titulo.contains(palabraARestringir);
	}

	@Override
	double getDuracion() {
		return duracion;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	

}
