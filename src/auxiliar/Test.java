package auxiliar;

import logic.EntidadNoEstatal;
import logic.FacturaMensual;
import logic.Llamada;
import logic.PersonaJuridica;
import logic.PersonaNatural;
import logic.Representante;
import logic.Sistema;
import logic.TelefonoMovil;

public class Test {

	public static void main(String[] args) {
		
		Sistema sistem = new Sistema();

		Representante representante = new Representante("Alfredo", "Socarraz", "Perez", "1000", true);

		PersonaNatural miguel = new PersonaNatural("Miguel", "miguelito0203", "Miguel", "Eduardo", "Rodriguez", "1001", "Pedroso123", "CerroCerrado", "Habana");
		TelefonoMovil miguelMovil = new TelefonoMovil("52816241", miguel);
		miguel.addTelefonoMovil(sistem, miguelMovil);
		sistem.addUsuario(miguel);

		PersonaJuridica charlie = new PersonaJuridica("Charlie", "charlitan", "CubaLibro", "cafeteria", "organismo1", "Vedado", "Habana", "10050", representante);
		TelefonoMovil charlieMovil = new TelefonoMovil("53301607", charlie);
		charlie.addTelefonoMovil(sistem, charlieMovil);
		sistem.addUsuario(charlie);

		EntidadNoEstatal ackerman = new EntidadNoEstatal("ackerman", "A3rWx7Hf8", "Cerritan", "Camaguey", "socialMedia", "10050", representante);
		TelefonoMovil ackermanMovil = new TelefonoMovil("52953930", ackerman);
		ackerman.addTelefonoMovil(sistem, ackermanMovil);
		sistem.addUsuario(ackerman);
		
		
		PersonaJuridica carlos = new PersonaJuridica("Carlos", "carlito", "Buisness", "restaurante", "organismo1", "Madrid", "España", "10032", representante);
		TelefonoMovil a = new TelefonoMovil("54435365", carlos);
		
		Llamada b = new Llamada("123456", 12.4, true, "habana");
		Llamada c = new Llamada("1234567", 12.4, true, "habana");
		Llamada d = new Llamada("1234568", 12.4, true, "habana");
		
		FacturaMensual factura = new FacturaMensual(10);
		
		factura.addLlamada(b);
		factura.addLlamada(c);
		factura.addLlamada(d);
		
		a.addFactura(factura);
		
		sistem.addTelefono(a);
		
		System.out.println(sistem.getTelefono("54435365").getUsuario().getNombre());
		System.out.println(sistem.getUsuario("ackerman").getTelefonoMovil("52953930").getUsuario().getNombre());
		
	}

}
