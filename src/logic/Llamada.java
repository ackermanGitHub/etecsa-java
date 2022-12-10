package logic;

import java.util.Date;

public class Llamada {
	private String numeroLlamado;
	private double duracion;
	private String provinciaLlamada;
	private boolean largaDistancia;
	private boolean saliente;
	private Date date;

	public Llamada(String numero, double duracion, 
			String provinciaLlamada, boolean largaDistancia, boolean saliente, Date date) {
		
		this.numeroLlamado = numero;
		this.duracion = duracion;
		this.provinciaLlamada = provinciaLlamada;
		this.largaDistancia = largaDistancia;
		this.saliente = saliente;
		this.date = date;
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
	public boolean isSaliente() {
		return saliente;
	}
	public Date getDate() {
        return date;
    }

}
