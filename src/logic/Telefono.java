package logic;

import java.util.ArrayList;

public abstract class Telefono {
	private String numero;
	private ArrayList<FacturaMensual> facturas = new ArrayList<FacturaMensual>();
	private Usuario usuario;

	public Telefono(String numero, Usuario usuario) {
		this.setNumero(numero);
		this.usuario = usuario;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<FacturaMensual> getFacturas() {
		return facturas;
	}
	public void addFactura(FacturaMensual factura) {
		this.facturas.add(factura);
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
