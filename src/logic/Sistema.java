package logic;

import java.util.ArrayList;

import auxiliar.Utils;

public class Sistema {
	
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

	public Usuario getUsuario(String userName, String password){
		Usuario resultado = null;
		for(Usuario user : this.getListaDeUsuarios()){
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
				resultado = user;
			}
		}
		return resultado;
	}
	public Usuario getUsuario(String userName){
		Usuario resultado = null;
		for(Usuario user : this.getListaDeUsuarios()){
			if(user.getUserName().equals(userName)){
				resultado = user;
			}
		}
		return resultado;
	}
	public Usuario getUsuarioPorTelefono(String numero){
		Usuario resultado = null;
		for(Usuario user : this.getListaDeUsuarios()){
			if(user.getTelefono(numero) != null){
				resultado = user;
			}
		}
		return resultado;
	}
	public void addUsuario(Usuario usuario) {
		Usuario resultado = this.getUsuario(usuario.getUserName());
		if(resultado == null)
			this.listaDeUsuarios.add(usuario);
		else
			Utils.launchError("El usuario ya existe");
	}
	public void addPersonaNatural(String userName, String password, String nombre, 
			String apellido1, String apellido2, String ID, 
			String direccionParticular, String municipio, String provincia) {
		
			PersonaNatural nuevoUsuario = new PersonaNatural(userName, password, nombre, 
					apellido1, apellido2, ID, direccionParticular, municipio, provincia);
			
			this.addUsuario(nuevoUsuario);
	}
	public void addPersonaJuridica(String userName, String password, String nombreEmpresa, 
			String entidad, String organismo, String municipio, String provincia, 
			String direccionPostal, Representante representante) {
		
			PersonaJuridica nuevoUsuario = new PersonaJuridica(userName, password, nombreEmpresa, 
					entidad, organismo, municipio, provincia, 
					direccionPostal, representante);
			
			this.addUsuario(nuevoUsuario);
	}
	public void addEntidadNoEstatal(String userName, String password, String nombre,  
			String municipio, String provincia, String direccionPostal, 
			Representante representante) {
		
			EntidadNoEstatal nuevoUsuario = new EntidadNoEstatal(userName, password, nombre,  
					municipio, provincia, direccionPostal, 
					representante);
			
			this.addUsuario(nuevoUsuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		Usuario resultado = this.getUsuario(usuario.getUserName());
		if(resultado != null)
			this.listaDeUsuarios.remove(usuario);
		else
			Utils.launchError("El usuario no existe");
	}
	public ArrayList<Usuario> getListaDeUsuarios(){
		return this.listaDeUsuarios;
	}

	public Telefono getTelefono(String numero){
		Telefono resultado = null;
		for(Telefono telefono : this.getListaTelefonos()){
			if(telefono.getNumero().equals(numero))
				resultado = telefono;
		}
		return resultado;
	}
	public ArrayList<Telefono> getListaTelefonos(){
		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
		for(Usuario usuario : this.getListaDeUsuarios()){
			telefonos.addAll(usuario.getListaTelefonos());
		}
		return telefonos;
	}
	
	public ArrayList<Llamada> getListaLlamadas(){
		ArrayList<Llamada> result = new ArrayList<Llamada>();
		for(Telefono telefono : this.getListaTelefonos()){
			if(telefono.getLlamadas() != null)
				result.addAll(telefono.getLlamadas());
		}
		return result;
	}

}
