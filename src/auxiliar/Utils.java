package auxiliar;

import gui.ErrorWindow;

public class Utils {

	public static boolean validarNombre(String nombre) {
		boolean result = true;
		if(nombre.length() < 3)
			result = false;
		for (int i = 0; i > nombre.length(); i++) {   
			if (!Character.isAlphabetic((nombre.charAt(i))))
				result = false; 
		}
		return result; 
	}
	public static boolean validarNombreUsuario(String entrada){
		boolean resultado = false;
		if(entrada.matches("^[A-Za-z]\\w{5,29}$"))
			resultado = true;
		return resultado;
	}
	public static boolean validarNumeroFijo(String numeroTelefono) {
		boolean esValido = true;
		if (numeroTelefono.length() != 7) 
			esValido = false;
		else {
			for (int i = 0; i < numeroTelefono.length(); i++) {
			  char caracter = numeroTelefono.charAt(i);
			  if (!Character.isDigit(caracter)) 
				esValido = false;
			}
		}
		return esValido;
	}
	public static boolean validarNumeroMovil(String numeroTelefono) {
		boolean esValido = true;
		if (!numeroTelefono.startsWith("5"))
			esValido = false;
		else if (numeroTelefono.length() != 8) 
			esValido = false;
		else {
			for (int i = 0; i < numeroTelefono.length(); i++) {
		  		char caracter = numeroTelefono.charAt(i);
		  		if (!Character.isDigit(caracter)) 
					esValido = false;
			}
		}
		return esValido;
	}
	public static boolean validarID(String ID) {
		return true;
	}
	public static boolean validarDireccion(String direccion) {
		return true;
	}
	public static void launchError(String errorMessage){
		ErrorWindow errorWindow = new ErrorWindow(errorMessage);
		errorWindow.setVisible(true);
		throw new IllegalArgumentException(errorMessage);
	}
	public static int getProvinciaNum(String provincia){
		int result = 0;
		if(provincia.contains("inar"))
			result = 48;
		else if(provincia.contains("abana"))
			result = 7;
		else if(provincia.contains("rtemisa") || provincia.contains("ayabeque"))
			result = 47;
		else if(provincia.contains("atanzas"))
			result = 45;
		else if(provincia.contains("illa") && provincia.contains("lara"))
			result = 42;
		else if(provincia.contains("ienfuegos"))
			result = 43;
		else if(provincia.contains("ancti"))
			result = 41;
		else if(provincia.contains("iego") && provincia.contains("vila"))
			result = 33;
		else if(provincia.contains("amaguey"))
			result = 32;
		else if(provincia.contains("as") && provincia.contains("unas"))
			result = 31;
		else if(provincia.contains("olgu�n") || provincia.contains("olguin"))
			result = 24;
		else if(provincia.contains("ranma"))
			result = 23;
		else if(provincia.contains("antiago") && provincia.contains("uba"))
			result = 22;
		else if(provincia.contains("ant�namo") || provincia.contains("antanamo"))
			result = 21;
		else if(provincia.contains("sla") && provincia.contains("uventud"))
			result = 46;
		return result;
	}

}