package modelo;

public class ClienteRestringidoPorPalabraTitulo extends ClienteRestringido {
	public ClienteRestringidoPorPalabraTitulo(ICliente cliente) {
		super(cliente);
	}
	private String palabraARestringir;
	@Override
	public void descargar(Item item) {
		if (item.tituloContiene(palabraARestringir)) {
			throw new ControlParentalException("El titulo contiene:" + palabraARestringir);
		}
		cliente.descargar(item);
	}

}
