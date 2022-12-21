package logic;

public class TelefonoMovil extends Telefono{
	
	private double saldo;

	public TelefonoMovil(String numero) {
		super(numero);
		this.setSaldo(15.0);
	}

	public void addLlamada(Sistema sistema, Usuario usuario, String numeroLlamado, double duracion) {

		String provinciaUsuario = usuario.getProvincia();
		String provinciaLlamada = sistema.getUsuarioPorNumero(numeroLlamado).getProvincia();

		boolean largaDistancia = !provinciaUsuario.equals(provinciaLlamada);
		
		Llamada llamada = new Llamada(numeroLlamado, duracion, 
					provinciaLlamada, largaDistancia, true);
		this.addLlamada(llamada);
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
