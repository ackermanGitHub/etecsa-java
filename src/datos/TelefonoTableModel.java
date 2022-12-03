package datos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import logic.Sistema;
import logic.Telefono;
import logic.TelefonoFijo;
import logic.TelefonoMovil;
import logic.Usuario;

@SuppressWarnings("serial")
public class TelefonoTableModel extends DefaultTableModel{

	public TelefonoTableModel(Sistema sistem){
		String[] columnNames = {"Usuario", "Tipo", "Numero"};
		this.setColumnIdentifiers(columnNames);
		String tipo = "Undefined";
		for(Usuario usuario : sistem.getListaDeUsuarios()){
			ArrayList<Telefono> telefonos = usuario.getListaTelefonos();
			for(Telefono telefono : telefonos){
				if (telefono instanceof TelefonoMovil)
					tipo = "TelefonoMovil";
				else if(telefono instanceof TelefonoFijo)
					tipo = "TelefonoFijo";	
				Object[] newRow = new Object[]{usuario.getNombre(), tipo, telefono.getNumero()};
				addRow(newRow);			
			}
		}
	}

}
