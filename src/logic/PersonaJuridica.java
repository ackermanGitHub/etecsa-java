package logic;

public class PersonaJuridica extends Usuario {
	private String entidad;
	private String organismo;

	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getOrganismo() {
		return organismo;
	}
	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}

	public PersonaJuridica(String userName, String password, String nombreEmpresa, String entidad, String organismo, String municipio, String provincia, String direccionPostal, Representante representante) {
		super(userName, password, nombreEmpresa, municipio, provincia, direccionPostal, representante);
		this.setEntidad(entidad);
		this.setOrganismo(organismo);
	}

}