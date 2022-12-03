package logic;

import java.util.ArrayList;

public class TelefonoFijo extends Telefono{
	
	private ArrayList<FacturaMensual> facturas = new ArrayList<FacturaMensual>();

	public TelefonoFijo(String numero) {
		super(numero);
	}
	
	public ArrayList<FacturaMensual> getFacturas() {
		return this.facturas;
	}
	public void addFactura(double atrasoDePago) {
		this.facturas.add(new FacturaMensual(atrasoDePago));
	}
	
	public void addLlamada(Llamada llamada){
		if(this.getFacturas().size() != 0)
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada);
		else {
			this.addFactura(0);
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada);
		}
	}
	public ArrayList<Llamada> getLlamadas(){
		ArrayList<Llamada> resultado = new ArrayList<Llamada>();
		if(this.getFacturas().size() != 0){
			for(FacturaMensual factura : this.getFacturas()){
				if(!factura.getListaLlamadas().isEmpty())
					resultado.addAll(factura.getListaLlamadas());
			}
		}
		return resultado;
	}
	
}
