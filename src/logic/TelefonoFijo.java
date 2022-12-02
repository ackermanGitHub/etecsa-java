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
	public void addFactura(FacturaMensual factura) {
		this.facturas.add(factura);
	}
	
	public void addLlamada(Llamada llamada){
		if(this.getFacturas().size() != 0)
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada); // a�ade la llamada a la �ltima factura
		else {
			FacturaMensual factura = new FacturaMensual(0); // crea una nueva factura,
			factura.addLlamada(llamada);                    // le a�ade la llamada
			this.addFactura(factura);                       // y a�ade la factura al tel�fono
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
