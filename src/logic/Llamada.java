package logic;

public class Llamada {
	private String numeroLlamado;
	private double duracion;
	private String provinciaLlamada;
	private boolean largaDistancia;

	public Llamada(String numero, double duracion, String provinciaLlamada, boolean largaDistancia) {
		this.numeroLlamado = numero;
		this.duracion = duracion;
		this.provinciaLlamada = provinciaLlamada;
		this.largaDistancia = largaDistancia;
	}

	public String getNumero() {
		return numeroLlamado;
	}
	public double getDuracion() {
		return duracion;
	}
	public String getProvinciaLlamada() {
		return provinciaLlamada;
	}
	public boolean isLargaDistancia() {
		return largaDistancia;
	}
	
}
