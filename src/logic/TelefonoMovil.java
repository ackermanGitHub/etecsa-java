package logic;

import java.util.ArrayList;

public class TelefonoMovil extends Telefono{
	private String numero;
	private ArrayList<FacturaMensual> facturas = new ArrayList<FacturaMensual>();

	public TelefonoMovil(String numero, Usuario usuario) {
		super(numero, usuario);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
