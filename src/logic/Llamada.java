package logic;

public class Llamada {
	private String numero;
	private double duracion;
	private String provinciaLlamada;

	public Llamada(String numero, double duracion, String provinciaLlamada) {
		this.setNumero(numero);
		this.setDuracion(duracion);
		this.setProvinciaLlamada(provinciaLlamada);
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getProvinciaLlamada() {
		return provinciaLlamada;
	}
	public void setProvinciaLlamada(String provinciaLlamada) {
		this.provinciaLlamada = provinciaLlamada;
	}

}
