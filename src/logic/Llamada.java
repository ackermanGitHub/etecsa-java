package logic;

public class Llamada {
	private String numero;
	private double duracion;
	private boolean cargado;
	private String provinciaLlamada;

	public Llamada(String numero, double duracion, boolean cargado, String provinciaLlamada) {
		this.numero = numero;
		this.cargado = cargado;
		this.provinciaLlamada = provinciaLlamada;
	}
}
