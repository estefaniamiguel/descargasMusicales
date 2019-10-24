package modelo;

import java.util.List;

public abstract class ClienteRestringido implements ICliente {

	public ICliente cliente;
	
	public ClienteRestringido(ICliente cliente) {
		this.cliente = cliente;
	}
	
	public boolean esNuevo() {
		return cliente.esNuevo();
	}
	
	@Override
	public double totalAFacturar() {
		return cliente.totalAFacturar();
	}
	
	public List<Item> getItems() {
		return cliente.getItems();
	}

}
