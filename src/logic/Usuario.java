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

	
	public Telefono getTelefono(String numero){
		Telefono resultado = null;
		for(Telefono telefono : this.getListaTelefonos()){
			if(telefono.getNumero().equals(numero))
				resultado = telefono;
		}
		return resultado;
	}
	
	public ArrayList<TelefonoMovil> getTelefonosMoviles() {
		return this.telefonosMoviles;
	}
	public void addTelefonoMovil(String numero) {
		this.telefonosMoviles.add(new TelefonoMovil(numero));
	}

	public ArrayList<TelefonoFijo> getTelefonosFijos() {
		return this.telefonosFijos;
	}
	public void addTelefonoFijo(String numero) {
		this.telefonosFijos.add(new TelefonoFijo(numero));
	}
	
	public ArrayList<Telefono> getListaTelefonos(){
		ArrayList<Telefono> listaTelefonos = new ArrayList<Telefono>();
		listaTelefonos.addAll(this.getTelefonosFijos());
		listaTelefonos.addAll(this.getTelefonosMoviles());
		return listaTelefonos;
	}

	public ArrayList<CuentaNauta> getCuentasNauta() {
		return this.cuentasNautas;
	}
	public void addCuentaNauta(String nickName) {
		this.cuentasNautas.add(new CuentaNauta(nickName));
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		if(!Utils.validarNombre(userName))
			throw new IllegalArgumentException("El nombre de usuario no es válido");
		else
			this.userName = userName;			
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		if(!Utils.validarNombre(password))
			throw new IllegalArgumentException("La contrase�a no es v�lida");
		else
			this.password = password;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(!Utils.validarNombre(nombre))
			throw new IllegalArgumentException("El nombre no es v�lido");
		else 
			this.nombre = nombre;
	}

	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		if(!Utils.validarNombre(municipio))
			throw new IllegalArgumentException("El municipio no es v�lido");
		else 
			this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		if(!Utils.validarNombre(provincia))
			throw new IllegalArgumentException("La provincia no es v�lida");
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
