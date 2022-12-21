package logic;

import java.util.ArrayList;

import auxiliar.Utils;

public class CuentaNauta {
	private String nickName;
	private ArrayList<NavegacionMensual> datosNavegacion = new ArrayList<NavegacionMensual>();

	public CuentaNauta(String nickName) {
		this.setNickName(nickName);
	}

	public ArrayList<NavegacionMensual> getDatosNavegacion() {
		return datosNavegacion;
	}
	public void addNavegacionMensual(double kbNacRecibXCorreo, 
			double kbNacEnvXCorreo, double kbIntRecibXCorreo, 
			double kbIntEnvXCorreo, double kbNavInternet){
		if(kbNacRecibXCorreo < 0 || kbNacEnvXCorreo < 0 || kbIntRecibXCorreo < 0 
				|| kbIntEnvXCorreo < 0 || kbNavInternet < 0){
			throw new IllegalArgumentException("Ningún parámetro puede ser inicializado en 0");
		}

		this.datosNavegacion.add(new NavegacionMensual(kbNacRecibXCorreo, kbNacEnvXCorreo, 
				kbIntRecibXCorreo, kbIntEnvXCorreo, kbNavInternet));
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		if(!Utils.validarNombreUsuario(nickName))
			throw new IllegalArgumentException("El nickName no es válido");
		this.nickName = nickName;
	}

}
