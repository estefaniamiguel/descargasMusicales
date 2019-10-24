package modelo;

import java.util.List;

public class Compilado extends Item {

	private static final double COSTO_HIT = 60;
	private static final double COSTO_DEFAULT = 40;
	private List<Cancion> canciones;

	@Override
	boolean esHit() {
		return descargas > 10000;
	}

	@Override
	double precioDeHit() {
		return COSTO_HIT;
	}

	@Override
	double precioNoHit() {
		return COSTO_DEFAULT;
	}
	
	public void descargar() {
		super.descargar();
		canciones.forEach(cancion -> cancion.descargar());
	}

	@Override
	List<String> getGeneros() {
		return (List<String>) canciones.stream().map(cancion -> cancion.getGenero());
	}

	@Override
	boolean esDeArtista(String artista) {
		return canciones.stream().anyMatch(cancion -> cancion.esDeArtista(artista));
	}

	@Override
	boolean tituloContiene(String palabraARestringir) {
		return canciones.stream().anyMatch(cancion -> cancion.tituloContiene(palabraARestringir));
	}

	@Override
	double getDuracion() {
		double duracionMayor = 0;
		for (Cancion cancion : canciones) {
			if (duracionMayor < cancion.getDuracion()) {
				duracionMayor = cancion.getDuracion();
			}
		}
		return duracionMayor;
	}
}
