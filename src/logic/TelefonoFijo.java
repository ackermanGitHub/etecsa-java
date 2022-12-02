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
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada); // añade la llamada a la última factura
		else {
			FacturaMensual factura = new FacturaMensual(0); // crea una nueva factura,
			factura.addLlamada(llamada);                    // le añade la llamada
			this.addFactura(factura);                       // y añade la factura al teléfono
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
