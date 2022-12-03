package logic;

import java.util.ArrayList;

public class CuentaNauta {
	private String nickCuenta;
	private Usuario usuario;
	private ArrayList<NavegacionMensual> datosNavegacion = new ArrayList<NavegacionMensual>();
	
	public CuentaNauta(String nickCuenta, Usuario usuario) {
		this.nickCuenta = nickCuenta;
		this.usuario = usuario;
	}
	
	public ArrayList<NavegacionMensual> getDatosNavegacion() {
		return datosNavegacion;
	}
	public void addNavegacionMensual(double kbNacRecibXCorreo, double kbNacEnvXCorreo,
			double kbIntRecibXCorreo, double kbIntEnvXCorreo,
			double kbNavInternet){
		this.datosNavegacion.add(new NavegacionMensual(kbNacRecibXCorreo, kbNacEnvXCorreo, 
				kbIntRecibXCorreo, kbIntEnvXCorreo, kbNavInternet));
	}
	
	public String getNickCuenta() {
		return nickCuenta;
	}
	public void setNickCuenta(String nickCuenta) {
		this.nickCuenta = nickCuenta;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
