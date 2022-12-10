package auxiliar;

import gui.ErrorWindow;

public class Utils {

	public static boolean validarNombre(String nombre) {
		boolean resultado = true;
		if(nombre.length() < 3)
			resultado = false;
		for (int i = 0; i > nombre.length(); i++) {   
			if (!Character.isAlphabetic((nombre.charAt(i))))
				resultado = false; 
		}
		return resultado; 
	}
	public static boolean validarNombreUsuario(String entrada){
		boolean resultado = false;
		if(entrada.matches("^[A-Za-z]\\w{3,29}$"))
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
		int resultado = 0;
		if(provincia.contains("inar"))
			resultado = 48;
		else if(provincia.contains("abana"))
			resultado = 7;
		else if(provincia.contains("rtemisa") || provincia.contains("ayabeque"))
			resultado = 47;
		else if(provincia.contains("atanzas"))
			resultado = 45;
		else if(provincia.contains("illa") && provincia.contains("lara"))
			resultado = 42;
		else if(provincia.contains("ienfuegos"))
			resultado = 43;
		else if(provincia.contains("ancti"))
			resultado = 41;
		else if(provincia.contains("iego") && provincia.contains("vila"))
			resultado = 33;
		else if(provincia.contains("amaguey"))
			resultado = 32;
		else if(provincia.contains("as") && provincia.contains("unas"))
			resultado = 31;
		else if(provincia.contains("olguín") || provincia.contains("olguin"))
			resultado = 24;
		else if(provincia.contains("ranma"))
			resultado = 23;
		else if(provincia.contains("antiago") && provincia.contains("uba"))
			resultado = 22;
		else if(provincia.contains("antánamo") || provincia.contains("antanamo"))
			resultado = 21;
		else if(provincia.contains("sla") && provincia.contains("uventud"))
			resultado = 46;
		return resultado;
	}

}