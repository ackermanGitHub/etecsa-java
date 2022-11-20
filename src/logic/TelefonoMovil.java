package logic;

import java.util.ArrayList;

public class TelefonoMovil extends Telefono{
	
	private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();

	public TelefonoMovil(String numero, Usuario usuario) {
		super(numero, usuario);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void addLlamada(Llamada llamada){
		this.llamadas.add(llamada);
	}
	public ArrayList<Llamada> getLlamadas(){
		return this.llamadas;
	}

}
