package init;

import logic.Llamada;
import logic.Representante;
import logic.Sistema;
import gui.Login;

public class Main {
	public static void main(String[] args) {

		Sistema sistem = new Sistema();

		Representante representante = new Representante("Alfredo", "Socarraz", "Perez", "1000", true);

		sistem.addPersonaNatural("alejandro", "alejandro123", "Alejandro", "García", "Rodriguez", "1234567890", "XX/XX y XX No.XXX", "Playa", "La Habana");
		sistem.getUsuario("alejandro").addTelefonoMovil("55395131");
		sistem.getTelefono("55395131").addLlamada(new Llamada("52953930", 8, "Camaguey", true, true));
		
		sistem.addPersonaNatural("julio", "julio123", "Julio", "López", "Quiros", "02092766721", "Pedro Pérez/Clavel y Mariano No.561", "Florida", "Camaguey");
		sistem.getUsuario("julio").addTelefonoMovil("52953930");
		sistem.getTelefono("52953930").addLlamada(new Llamada("55395131", 15, "La Habana", true, true));
		
		sistem.addEntidadNoEstatal("laMimosa", "lamimosa123", "La Mimosa", "Vedado", "La Habana", "10050", representante);
		sistem.getUsuario("laMimosa").addTelefonoFijo("78671790");

		Login login = new Login(sistem);
		login.setVisible(true);
	}
	
}
