package logic;

import java.util.Date;

public class TelefonoMovil extends Telefono{

	public TelefonoMovil(String numero) {
		super(numero);
	}

	public void addLlamada(Sistema sistema, Usuario usuario, String numeroLlamado, double duracion) {

		String provinciaUsuario = usuario.getProvincia();
		String provinciaLlamada = sistema.getUsuarioPorNumero(numeroLlamado).getProvincia();

		boolean largaDistancia = !provinciaUsuario.equals(provinciaLlamada);
		
		Llamada llamada = new Llamada(numeroLlamado, duracion, 
					provinciaLlamada, largaDistancia, true, new Date());
		this.addLlamada(llamada);
		
	}

}
