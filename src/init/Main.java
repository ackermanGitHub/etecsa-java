package init;

import logic.EntidadNoEstatal;
import logic.PersonaJuridica;
import logic.PersonaNatural;
import logic.Representante;
import logic.Sistema;
import logic.TelefonoMovil;
import gui.Login;

public class Main {
	public static void main(String[] args) {

		Sistema sistem = new Sistema();

		Representante representante = new Representante("Alfredo", "Socarraz", "Perez", "1000", true);

		PersonaNatural miguel = new PersonaNatural("Miguel", "miguelito0203", "Miguel", "Eduardo", "Rodriguez", "1001", "Pedroso123", "CerroCerrado", "Habana");
		TelefonoMovil miguelMovil = new TelefonoMovil("52816241", miguel);
		miguel.addTelefonoMovil(sistem, miguelMovil);
		sistem.addUsuario(miguel);

		PersonaJuridica charlie = new PersonaJuridica("Charlie", "charlitan", "CubaLibro", "cafeteria", "organismo1", "Vedado", "Habana", "10050", representante);
		TelefonoMovil charlieMovil = new TelefonoMovil("52953930", charlie);
		charlie.addTelefonoMovil(sistem, charlieMovil);
		sistem.addUsuario(charlie);

		EntidadNoEstatal ackerman = new EntidadNoEstatal("ackerman", "A3rWx7Hf8", "Cerritan", "Camaguey", "socialMedia", "10050", representante);
		TelefonoMovil ackermanMovil = new TelefonoMovil("53301607", ackerman);
		ackerman.addTelefonoMovil(sistem, ackermanMovil);
		sistem.addUsuario(ackerman);

		Login login = new Login(sistem);
		login.setVisible(true);
	}
}
