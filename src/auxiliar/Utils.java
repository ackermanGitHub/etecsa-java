package auxiliar;

import gui.ErrorWindow;

public class Utils {

	public static double reducirCifras(double numero){
		double valorMultiplicado = numero * 1000;
		int redondeado = (int) Math.round(valorMultiplicado);
		double resultado = redondeado / 1000.0;
		return resultado;
	}
	public static boolean validarNombre(String nombre) {
		boolean resultado = true;
		if(nombre.length() < 2 || nombre.length() > 30)
			resultado = false;
		if(Character.isLowerCase(nombre.charAt(0)))
			resultado = false;
		for (int i = 0; i > nombre.length(); i++) {   
			if (!Character.isAlphabetic((nombre.charAt(i))))
				resultado = false; 
		}
		return resultado; 
	}
	public static boolean validarNombreUsuario(String entrada){
		boolean resultado = false;
		if(entrada.matches("^[A-Za-z]\\w{2,29}$"))
			resultado = true;
		return resultado;
	}
	public static boolean validarPassword(String password) {
		boolean resultado = false;
		if(password.matches("\\w{2,29}$"))
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
		boolean resultado = true;
		if(ID.length() != 11)
			resultado = false;
		return resultado;
	}
	public static boolean validarDireccion(String direccion) {
		return true;
	}
	public static boolean validarDireccionPostal(String direccionPostal) {
		boolean resultado = true;
		if(direccionPostal.length() != 6)
			resultado = false;
		return resultado;
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
		else if(provincia.contains("ritus"))
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
	public static boolean validarProvincia(String provincia){
		boolean resultado = false;
		if(provincia.contains("inar"))
			resultado = true;
		else if(provincia.contains("abana"))
			resultado = true;
		else if(provincia.contains("rtemisa") || provincia.contains("ayabeque"))
			resultado = true;
		else if(provincia.contains("atanzas"))
			resultado = true;
		else if(provincia.contains("illa") && provincia.contains("lara"))
			resultado = true;
		else if(provincia.contains("ienfuegos"))
			resultado = true;
		else if(provincia.contains("ritus"))
			resultado = true;
		else if(provincia.contains("iego") && provincia.contains("vila"))
			resultado = true;
		else if(provincia.contains("amaguey"))
			resultado = true;
		else if(provincia.contains("as") && provincia.contains("unas"))
			resultado = true;
		else if(provincia.contains("olguín") || provincia.contains("olguin"))
			resultado = true;
		else if(provincia.contains("ranma"))
			resultado = true;
		else if(provincia.contains("antiago") && provincia.contains("uba"))
			resultado = true;
		else if(provincia.contains("antánamo") || provincia.contains("antanamo"))
			resultado = true;
		else if(provincia.contains("sla") && provincia.contains("uventud"))
			resultado = true;
		return resultado;
	}
}