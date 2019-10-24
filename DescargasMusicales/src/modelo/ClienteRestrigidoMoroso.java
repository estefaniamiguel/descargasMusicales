package modelo;

public class ClienteRestrigidoMoroso extends ClienteRestringido {

	public ClienteRestrigidoMoroso(ICliente cliente) {
		super(cliente);
	}

	private static final double TOTAL_MOROSIDAD = 500;

	@Override
	public void descargar(Item item) {
		if (cliente.totalAFacturar() > TOTAL_MOROSIDAD) {
			throw new MorosoException();
		}
	}

}
