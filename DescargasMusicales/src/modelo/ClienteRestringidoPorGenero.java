package modelo;

import java.util.List;

public class ClienteRestringidoPorGenero extends ClienteRestringido {
	
	private List<String> generos;

	
	public ClienteRestringidoPorGenero(ICliente cliente, List<String> generos) {
		super(cliente);
		this.generos = generos;
	}
	
	@Override
	public void descargar(Item item) {
		if (generos.stream().anyMatch(genero -> item.getGeneros().contains(genero))) {
			throw new ControlParentalException("Género no permitido:"+ item.getGeneros());
		}
		cliente.descargar(item);
	}

}
