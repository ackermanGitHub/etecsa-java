package logic;

import java.util.ArrayList;

public abstract class Telefono {
	
	protected String numero;
	protected Usuario usuario;
	private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	
	public Telefono(String numero, Usuario usuario) {
		this.setNumero(numero);
		this.setUsuario(usuario);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void addLlamada(Llamada llamada){
		this.llamadas.add(llamada);
	}
	public ArrayList<Llamada> getLlamadas(){
		return this.llamadas;
	}
	
}
