package logic;

import java.util.ArrayList;
import java.util.Date;

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

	public void addLlamada(Sistema sistema, Usuario usuario, 
			String numeroLlamado, double duracion) {

		Usuario usuarioLlamado = sistema.getUsuarioPorNumero(numeroLlamado);
		Telefono telefonoLlamado = sistema.getTelefono(numeroLlamado);

		String provinciaUsuario = usuario.getProvincia();
		String provinciaLlamada = usuarioLlamado.getProvincia();

		boolean isLargaDistancia = !provinciaUsuario.equals(provinciaLlamada);

		Llamada llamada;
		if(telefonoLlamado instanceof TelefonoFijo) {
			llamada = new Llamada(numeroLlamado, duracion, provinciaLlamada, isLargaDistancia, true, new Date());
			this.addLlamada(llamada);
		}
		else {
			llamada = new Llamada(this.getNumero(), duracion, provinciaUsuario, isLargaDistancia, false, new Date());
			telefonoLlamado.addLlamada(llamada);
		}

	}

}
