package init;

import logic.EntidadNoEstatal;
import logic.PersonaJuridica;
import logic.PersonaNatural;
import logic.Representante;
import logic.Sistema;
import logic.TelefonoFijo;
import logic.TelefonoMovil;
import gui.Login;

public class Main {
	public static void main(String[] args) {

		Sistema sistem = new Sistema();

		Representante representante = new Representante("Alfredo", "Socarraz", "Perez", "1000", true);

		PersonaNatural alejandro = new PersonaNatural("alejandro", "alejandro123", "Alejandro", "García", "Rodriguez", "1234567890", "XX/XX y XX No.XXX", "Playa", "La Habana");
		TelefonoMovil aleMovil = new TelefonoMovil("55395131", alejandro);
		alejandro.addTelefonoMovil(sistem, aleMovil);
		sistem.addUsuario(alejandro);
		
		PersonaNatural julio = new PersonaNatural("julio", "julio123", "Julio", "López", "Quiros", "02092766721", "Pedro Pérez/Clavel y Mariano No.561", "Cerro", "Camaguey");
		TelefonoMovil julioMovil = new TelefonoMovil("52953930", julio);
		julio.addTelefonoMovil(sistem, julioMovil);
		sistem.addUsuario(julio);

		PersonaJuridica charlie = new PersonaJuridica("tropical", "tropical123", "Salon Rosado de la Tropical", "salon-bar", "educación", "Playa", "Matanzas", "10050", representante);
		TelefonoFijo charlieMovil = new TelefonoFijo("72035322", charlie);
		charlie.addTelefonoFijo(sistem, charlieMovil);
		sistem.addUsuario(charlie);

		EntidadNoEstatal mimosa = new EntidadNoEstatal("laMimosa", "lamimosa123", "La Mimosa", "Vedado", "La Habana", "10050", representante);
		TelefonoFijo mimosaFijo = new TelefonoFijo("78671790", mimosa);
		mimosa.addTelefonoFijo(sistem, mimosaFijo);
		sistem.addUsuario(mimosa);

		Login login = new Login(sistem);
		login.setVisible(true);
	}
}
