package logic;

import java.util.ArrayList;

import auxiliar.Utils;

public class Sistema {
	
	private ArrayList<Usuario> listaDeUsuario = new ArrayList<Usuario>();
	private ArrayList<Telefono> listaDeTelefonos = new ArrayList<Telefono>();

	public Usuario getUsuario(String userName){
		Usuario resultado = null;
		boolean encontrado = false;
		int i = 0;
		if(listaDeUsuario.size() > 0){
			do{
				String name = this.listaDeUsuario.get(i).getUserName();
				if(name.equals(userName)){ 
					resultado = this.listaDeUsuario.get(i);
					encontrado = true;
				}
				i++;
			}while (!encontrado && i < this.listaDeUsuario.size());
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
		boolean encontrado = false;
		int i = 0;
		if(this.listaDeTelefonos.size() > 0){
			do{
				String num = this.listaDeTelefonos.get(i).getNumero();
				if(num.equals(numero)){ 
					resultado = this.listaDeTelefonos.get(i);
					encontrado = true;
				}
				i++;
			}while (!encontrado && i < this.listaDeTelefonos.size());
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
