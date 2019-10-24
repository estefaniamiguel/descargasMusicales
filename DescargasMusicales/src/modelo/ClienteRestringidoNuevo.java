package modelo;

public class ClienteRestringidoNuevo extends ClienteRestringido {

	public ClienteRestringidoNuevo(ICliente cliente) {
		super(cliente);
	}

	private static final int DURACION_MAXIMA = 5;

	@Override
	public void descargar(Item item) {
		if (this.esNuevo() && item.getDuracion() > DURACION_MAXIMA) {
			throw new ClienteNuevoException();
		}
		cliente.descargar(item);
	}

}
