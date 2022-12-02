package logic;

import java.util.ArrayList;

public class FacturaMensual {

	private double tarifaFija = 10.5;
	private double atrasoDePago;
	private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();

	public FacturaMensual(double atrasoDePago) {
		this.atrasoDePago = atrasoDePago;
	}

	public double montoLocal(){
		double monto = 0;
		for(Llamada llamada : this.getListaLlamadas()){
			if(!llamada.isLargaDistancia()){
				monto += llamada.getDuracion() * this.tarifaFija;
			}
		}
		return monto;
	}
	public double montoLargaDistancia(){
		double monto = this.tarifaFija;
		for(Llamada llamada : this.getListaLlamadas()){
			if(llamada.isLargaDistancia()){
				monto += llamada.getDuracion() * this.tarifaFija * 2;
			}
		}
		return monto;
	}
	public double totalPagar(){
		double total = this.montoLargaDistancia() + this.montoLocal() + this.getAtrasoDePago();
		return total;
	}

	public ArrayList<Llamada> getListaLlamadas() {
		return this.llamadas;
	}
	public void addLlamada(Llamada llamadas) {
		this.llamadas.add(llamadas);
	}

	public double getAtrasoDePago() {
		return this.atrasoDePago;
	}
	public void setAtrasoDePago(double atrasoDePago) {
		this.atrasoDePago = atrasoDePago;
	}

}
