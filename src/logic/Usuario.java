package logic;

import java.util.ArrayList;

import auxiliar.Utils;

public abstract class Usuario {
	
	protected String userName;
	protected String password;
	protected String nombre;
	protected String municipio;
	protected String provincia;
	protected String direccionPostal;
	protected Representante representante;
	protected ArrayList<TelefonoFijo> telefonosFijos = new ArrayList<TelefonoFijo>();
	protected ArrayList<TelefonoMovil> telefonosMoviles = new ArrayList<TelefonoMovil>();
	protected ArrayList<CuentaNauta> cuentasNautas = new ArrayList<CuentaNauta>();

	public TelefonoMovil getTelefonoMovil(String numero) {
		TelefonoMovil resultado = null;
		for(TelefonoMovil telefono : this.telefonosMoviles){
			if(telefono.getNumero().equals(numero))
				resultado = telefono;
		}
		return resultado;
	}
	public ArrayList<TelefonoMovil> getTelefonosMoviles() {
		return this.telefonosMoviles;
	}
	public void addTelefonoMovil(Sistema sistem, TelefonoMovil telefonoMovil) {
		sistem.addTelefono(telefonoMovil);
		this.telefonosMoviles.add(telefonoMovil);
	}
	
	public TelefonoFijo getTelefonoFijo(String numero) {
		TelefonoFijo resultado = null;
		for(TelefonoFijo telefono : this.telefonosFijos){
			if(telefono.getNumero().equals(numero))
				resultado = telefono;
		}
		return resultado;
	}
	public void addTelefonoFijo(Sistema sistem, TelefonoFijo telefonoFijo) {
		sistem.addTelefono(telefonoFijo);
		this.telefonosFijos.add(telefonoFijo);
	}
	public ArrayList<TelefonoFijo> getTelefonosFijos() {
		return this.telefonosFijos;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		if(!Utils.validarNombre(userName))
			Utils.launchError("El nombre de usuario no es válido");
		else
			this.userName = userName;			
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		if(!Utils.validarNombre(password))
			Utils.launchError("La contraseña no es válida");
		else
			this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(!Utils.validarNombre(nombre))
			Utils.launchError("El nombre no es válido");
		else 
			this.nombre = nombre;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		if(!Utils.validarNombre(municipio))
			Utils.launchError("El municipio no es válido");
		else 
			this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		if(!Utils.validarNombre(provincia))
			Utils.launchError("La provincia no es válida");
		else 
			this.provincia = provincia;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public Representante getRepresentante() {
		return representante;
	}
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public Usuario(String userName, String password, String nombre, String municipio, String provincia, String direccionPostal, Representante representante) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setNombre(nombre);
		this.setMunicipio(municipio);
		this.setProvincia(provincia);
		this.setDireccionPostal(direccionPostal);
		this.setRepresentante(representante);		
	}
	
}
