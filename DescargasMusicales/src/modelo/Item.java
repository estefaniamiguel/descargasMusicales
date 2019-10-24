package modelo;

import java.util.List;

public abstract class Item {
	protected int descargas;

	public void descargar() {
		descargas++;
	}
	
	public double costo() {
		if (esHit()) {
			return precioDeHit();
		} else {
			return precioNoHit();
		}
	}

	abstract boolean esHit();
	abstract double precioDeHit();
	abstract double precioNoHit();

	abstract List<String> getGeneros();

	abstract boolean esDeArtista(String artista);

	abstract boolean tituloContiene(String palabraARestringir);

	abstract double getDuracion();

}
