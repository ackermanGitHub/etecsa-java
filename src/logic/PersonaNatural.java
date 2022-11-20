package logic;

import auxiliar.Utils;

public class PersonaNatural extends Usuario{
	private String apellido1;
	private String apellido2;
	private String ID;
	private String direccionParticular;

	public void addTelefonoMovil(TelefonoMovil telefonoMovil) {
		if(telefonosMoviles.size() < 2)
			this.telefonosMoviles.add(telefonoMovil);
		else 
			Utils.launchError("Las personas naturales solo pueden tener 2 teléfonos móviles");
	}
	public void addTelefonoFijo(TelefonoFijo telefonoFijo) {
		if(telefonosFijos.size() == 0)
			this.telefonosFijos.add(telefonoFijo);
		else 
			Utils.launchError("Las personas naturales solo pueden tener 1 teléfono fijo");
	}

	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public String getDireccionParticular() {
		return direccionParticular;
	}
	public void setDireccionParticular(String direccionParticular) {
		this.direccionParticular = direccionParticular;
	}

	public PersonaNatural(String userName, String password, String nombre, String apellido1, String apellido2, String ID, String direccionParticular, String municipio, String provincia) {
		super(userName, password, nombre, municipio, provincia, null, null);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
		this.setID(ID);
		this.setDireccionParticular(direccionParticular);
	}
	
}
