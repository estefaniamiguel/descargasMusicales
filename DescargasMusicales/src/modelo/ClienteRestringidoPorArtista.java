package modelo;

public class ClienteRestringidoPorArtista extends ClienteRestringido {

	private String artista;

	public ClienteRestringidoPorArtista(ICliente cliente, String artista) {
		super(cliente);
		this.artista = artista;
	}

	@Override
	public void descargar(Item item) {
		if (item.esDeArtista(artista)) {
			throw new ControlParentalException("Artista no permitido:" + artista);
		}
		cliente.descargar(item);
	}

}
