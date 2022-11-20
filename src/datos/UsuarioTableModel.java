package datos;

import javax.swing.table.DefaultTableModel;

import logic.EntidadNoEstatal;
import logic.PersonaJuridica;
import logic.PersonaNatural;
import logic.Sistema;
import logic.Usuario;

@SuppressWarnings("serial")
public class UsuarioTableModel extends DefaultTableModel{
	public UsuarioTableModel(Sistema sistem){
		String[] columnNames = {
				"Tipo", "Nombre", "Municipio", "Provincia"};
		this.setColumnIdentifiers(columnNames);
		String tipo = "Undefined";
		for (int i = 0; i < sistem.getListaDeUsuarios().size(); i++) {
			Usuario usuario = sistem.getListaDeUsuarios().get(i);
			if (usuario instanceof PersonaNatural)
				tipo = "PersonaNatural";
			else if(usuario instanceof PersonaJuridica)
				tipo = "PersonaJuridica";	
			else if(usuario instanceof EntidadNoEstatal)
				tipo = "EntidadNoEstatal";
			Object[] newRow = new Object[]{tipo, usuario.getNombre(), usuario.getMunicipio(), usuario.getProvincia()};
			addRow(newRow);
		}
	}
}
