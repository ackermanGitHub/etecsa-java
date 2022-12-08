package logic;

public class EntidadNoEstatal extends Usuario{

	public EntidadNoEstatal(String userName, String password, String nombre,  
			String municipio, String provincia, String direccionPostal, 
			Representante representante, boolean isAdministrador) {
		
		super(userName, password, nombre, municipio, 
				provincia, direccionPostal, representante, isAdministrador);
	}

}
