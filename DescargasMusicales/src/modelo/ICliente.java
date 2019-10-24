package modelo;

import java.util.List;

public interface ICliente {
	public void descargar(Item item);

	public boolean esNuevo();

	public double totalAFacturar();

	public List<Item> getItems();
}
