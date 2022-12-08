package logic;

public class TelefonoMovil extends Telefono{

	public TelefonoMovil(String numero) {
		super(numero);
	}

	public void addLlamada(Sistema sistema, Usuario usuario, String numeroLlamado, double duracion, boolean usuarioCargado) {

		String provinciaUsuario = usuario.getProvincia();
		String provinciaLlamada = sistema.getUsuarioPorNumero(numeroLlamado).getProvincia();

		boolean largaDistancia = !provinciaUsuario.equals(provinciaLlamada);

		Llamada llamada;
		if(usuarioCargado) {
			llamada = new Llamada(numeroLlamado, duracion, 
					provinciaLlamada, largaDistancia, true);
			this.addLlamada(llamada);
		}
		else {
			llamada = new Llamada(this.getNumero(), 
					duracion, provinciaUsuario, largaDistancia, false);

			sistema.getTelefono(numeroLlamado).addLlamada(llamada);
		}

	}

}
