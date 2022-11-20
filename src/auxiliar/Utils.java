package auxiliar;

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

}
