package logic;

import java.util.ArrayList;

import auxiliar.Utils;

public class Sistema {
	
	private ArrayList<Usuario> listaDeUsuario = new ArrayList<Usuario>();
	private ArrayList<Telefono> listaDeTelefonos = new ArrayList<Telefono>();

	public Usuario getUsuario(String userName){
		Usuario resultado = null;
		for(Usuario user : this.getListaDeUsuarios()){
			if(user.getNombre().equals(userName)){
				resultado = user;
			}
		}
		return resultado;
	}
	public void addUsuario(Usuario usuario) {
		Usuario resultado = this.getUsuario(usuario.getUserName());
		if(resultado == null)
			this.listaDeUsuario.add(usuario);
		else
			Utils.launchError("El usuario ya existe");
	}
	public ArrayList<Usuario> getListaDeUsuarios(){
		return this.listaDeUsuario;
	}

	public Telefono getTelefono(String numero){
		Telefono resultado = null;
		for(Telefono telefono : this.getListaDeTelefonos()){
			if(telefono.getNumero().equals(numero))
				resultado = telefono;
		}
		return resultado;
	}
	public void addTelefono(Telefono telefono) {
		Telefono resultado = this.getTelefono(telefono.getNumero());
		if(resultado == null)
			this.listaDeTelefonos.add(telefono);
		else
			Utils.launchError("El télefono ya existe");
	}
	public ArrayList<Telefono> getListaDeTelefonos(){
		return this.listaDeTelefonos;
	}
	
	public ArrayList<Llamada> getListaLlamadas(){
		ArrayList<Llamada> result = new ArrayList<Llamada>();
		for(Telefono telefono : this.getListaDeTelefonos()){
			if(telefono.getLlamadas() != null)
				result.addAll(telefono.getLlamadas());
		}
		return result;
	}

}
