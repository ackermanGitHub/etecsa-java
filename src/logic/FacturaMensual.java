package logic;

import java.util.ArrayList;

public class FacturaMensual {

	private double tarifaFija = 10;
	private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();
	private double atrasoDePago;

	public FacturaMensual(double atrasoDePago) {
		this.atrasoDePago = atrasoDePago;
	}

	public double montoLocal(){
		double monto = 0;
		return monto;
	}
	public double montoLargaDistancia(){
		double monto = 0;
		return monto;
	}
	public double totalPagar(){
		double monto = 0;
		return monto;
	}

	public ArrayList<Llamada> getLlamadas() {
		return llamadas;
	}
	public void addLlamada(Llamada llamadas) {
		this.llamadas.add(llamadas);
	}

	public double getAtrasoDePago() {
		return atrasoDePago;
	}
	public void setAtrasoDePago(double atrasoDePago) {
		this.atrasoDePago = atrasoDePago;
	}

}
