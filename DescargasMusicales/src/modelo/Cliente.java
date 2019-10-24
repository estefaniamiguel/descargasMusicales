package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente implements ICliente {
	private static final int DIAS_DE_NOVATO = 30;
	private static final int DE_HOUR_TO_DAY = 24;
	private static final int DE_MIN_TO_HOUR = 60;
	private static final int DE_SEC_TO_MIN = 60;
	private static final int DE_MILLI_TO_SEC = 1000;
	private List<Item> items = new ArrayList<Item>();
//	private Estrategia estrategia;
	private Date diaDeSuscripcion;
	public void setDiaDeSuscripcion(Date diaDeSuscripcion) {
		this.diaDeSuscripcion = diaDeSuscripcion;
	}

	public void descargar(Item item) {
		//estrategia.puedeDescargar(item, this);
		item.descargar();
		items.add(item);
	}
	
	public double totalAFacturar() {
		double acum = 0;
		for(Item item : items) {
			acum += item.costo();
		}
		return acum;
	}

	public boolean esNuevo() {
		Date hoy = new Date();
		long millis = hoy.getTime() - diaDeSuscripcion.getTime();
		return (millis / (DE_HOUR_TO_DAY*DE_MIN_TO_HOUR*DE_SEC_TO_MIN*DE_MILLI_TO_SEC)) <= DIAS_DE_NOVATO;
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
	
}
