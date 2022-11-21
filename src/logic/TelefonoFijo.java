package logic;

import java.util.ArrayList;

public class TelefonoFijo extends Telefono{
	
	private ArrayList<FacturaMensual> facturas = new ArrayList<FacturaMensual>();

	public TelefonoFijo(String numero, Usuario usuario) {
		super(numero, usuario);
	}
	
	public ArrayList<FacturaMensual> getFacturas() {
		return facturas;
	}
	public void addFactura(FacturaMensual factura) {
		this.facturas.add(factura);
	}
	
	public void addLlamada(Llamada llamada){
		if(this.getFacturas().size() != 0){
			this.getFacturas().get(this.getFacturas().size() - 1).addLlamada(llamada); // agrega la llamada a la última factura
		} else {
			FacturaMensual factura = new FacturaMensual(0); // crea una nueva factura,
			factura.addLlamada(llamada);                    // le añade la llamada
			this.addFactura(factura);                       // y agrega la factura al teléfono
		}
	}
	public ArrayList<Llamada> getLlamadas(){
		ArrayList<Llamada> resultado = new ArrayList<Llamada>();
		if(this.getFacturas().size() != 0){
			for(FacturaMensual factura : this.getFacturas()){
				if(factura.getLlamadas().size() > 0)
					resultado.addAll(factura.getLlamadas());
			}
		} else{
			resultado = null;
		}
		return resultado;
	}
	
}
