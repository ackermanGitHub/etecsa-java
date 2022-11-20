package logic;

import java.util.ArrayList;

public abstract class Telefono {
	
	private String numero;
	private ArrayList<FacturaMensual> facturas = new ArrayList<FacturaMensual>();
	private Usuario usuario;
	
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
	
	public void addLlamada(Llamada llamada){
		if(this.getFacturas().size() != 0){
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada);
			
		} else {
			FacturaMensual factura = new FacturaMensual(0);
			factura.addLlamada(llamada);
			this.addFactura(factura);
		}
	}
	public ArrayList<Llamada> getLlamadas(){
		ArrayList<Llamada> resultado = new ArrayList<Llamada>();
		if(this.getFacturas().size() != 0){
			for(FacturaMensual factura : this.getFacturas()){
				if(factura.getLlamadas().size() > 0){
					resultado.addAll(factura.getLlamadas());
				}
			}
		} else {
			resultado = null;
		}
		return resultado;
	}
	
}
