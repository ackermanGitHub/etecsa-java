package init;

import logic.CuentaNauta;
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

		sistem.addPersonaNatural("alejandro", "alejandro123", "Alejandro", "García", "Rodriguez", "1234567890", "44/53 y 57 No.5328", "Cárdenas", "Matanzas");
		PersonaNatural alejandro = (PersonaNatural) sistem.getUsuario("alejandro");
		alejandro.setAdministrador(true);
		alejandro.addTelefonoMovil("55395131");
		TelefonoMovil alejandromMovil = (TelefonoMovil) sistem.getTelefono("55395131");
		alejandro.addTelefonoFijo("458781111");
		TelefonoFijo alejandroFijo = (TelefonoFijo) sistem.getTelefono("458781111");
		alejandro.addCuentaNauta("alejandro02");
		CuentaNauta alejandroNauta = alejandro.getCuentasNauta().get(0);
		
		sistem.addPersonaNatural("julio", "julio123", "Julio", "López", "Quiros", "02092766721", "Pedro Pérez/Clavel y Mariano No.561", "Florida", "Camaguey");
		PersonaNatural julio = (PersonaNatural) sistem.getUsuario("julio");
		julio.setAdministrador(true);
		julio.addTelefonoMovil("52953930");
		TelefonoMovil julioMovil = (TelefonoMovil) sistem.getTelefono("52953930");
		julio.addTelefonoFijo("328783115");
		TelefonoFijo julioFijo = (TelefonoFijo) sistem.getTelefono("328783115");
		julio.addCuentaNauta("julio02");
		CuentaNauta julioNauta = julio.getCuentasNauta().get(0);
		
		sistem.addEntidadNoEstatal("laMimosa", "lamimosa123", "La Mimosa", "Vedado", "La Habana", "10050", representante);
		sistem.getUsuario("laMimosa").addTelefonoFijo("78671790");
		
		alejandroNauta.addNavegacionMensual(12.5, 14, 111, 67, 89);
		alejandroNauta.addNavegacionMensual(12.5, 14, 111, 42, 89);
		alejandroNauta.addNavegacionMensual(12.5, 14, 111, 17, 89);
		alejandroNauta.addNavegacionMensual(12.5, 14, 111, 98, 89);
		alejandromMovil.addLlamada(sistem, alejandro, "52953930", 8);
		alejandromMovil.addLlamada(sistem, alejandro, "52953930", 54);
		alejandromMovil.addLlamada(sistem, alejandro, "78671790", 23);
		alejandromMovil.addLlamada(sistem, alejandro, "52953930", 85);
		alejandromMovil.addLlamada(sistem, alejandro, "78671790", 90);
		alejandromMovil.addLlamada(sistem, alejandro, "52953930", 12);
		alejandromMovil.addLlamada(sistem, alejandro, "78671790", 53);
		alejandroFijo.addLlamada(sistem, alejandro, "52953930", 53);
		alejandroFijo.addLlamada(sistem, alejandro, "78671790", 32);
		alejandroFijo.addLlamada(sistem, alejandro, "78671790", 75);
		alejandroFijo.addFactura(12);
		alejandroFijo.addLlamada(sistem, alejandro, "78671790", 97);
		alejandroFijo.addLlamada(sistem, alejandro, "52953930", 07);
		alejandroFijo.addLlamada(sistem, alejandro, "78671790", 23);
		alejandroFijo.addFactura(0);
		alejandroFijo.addLlamada(sistem, alejandro, "52953930", 98);

		julioNauta.addNavegacionMensual(12.5, 14, 111, 13, 89);
		julioNauta.addNavegacionMensual(12.5, 19, 111, 67, 89);
		julioNauta.addNavegacionMensual(12.5, 54, 111, 45, 89);
		julioNauta.addNavegacionMensual(12.5, 87, 111, 87, 89);
		julioMovil.addLlamada(sistem, alejandro, "52953930", 8);
		julioMovil.addLlamada(sistem, alejandro, "52953930", 54);
		julioMovil.addLlamada(sistem, alejandro, "78671790", 23);
		julioMovil.addLlamada(sistem, alejandro, "52953930", 85);
		julioMovil.addLlamada(sistem, alejandro, "78671790", 90);
		julioMovil.addLlamada(sistem, alejandro, "52953930", 12);
		julioMovil.addLlamada(sistem, alejandro, "78671790", 53);
		julioFijo.addLlamada(sistem, alejandro, "52953930", 53);
		julioFijo.addLlamada(sistem, alejandro, "78671790", 32);
		julioFijo.addLlamada(sistem, alejandro, "78671790", 75);
		julioFijo.addFactura(12);
		julioFijo.addLlamada(sistem, alejandro, "78671790", 97);
		julioFijo.addLlamada(sistem, alejandro, "52953930", 07);
		julioFijo.addLlamada(sistem, alejandro, "78671790", 23);
		julioFijo.addFactura(2);
		julioFijo.addLlamada(sistem, alejandro, "52953930", 98);
		
		Login login = new Login(sistem);
		login.setVisible(true);
		
	}

}
