package logic;

import java.util.ArrayList;

public abstract class Telefono implements Llamador{

	protected String numero;
	protected ArrayList<Llamada> llamadas = new ArrayList<Llamada>();

	public Telefono(String numero) {
		this.setNumero(numero);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Llamada> getLlamadas() {
		return this.llamadas;
	}
	public void addLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}

}
