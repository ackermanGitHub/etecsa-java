package datos;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import logic.Telefono;
import logic.TelefonoFijo;
import logic.TelefonoMovil;

@SuppressWarnings("serial")
public class TelefonoTableModel extends DefaultTableModel{

	public TelefonoTableModel(ArrayList<Telefono> telefonos){
		String[] columnNames = {"Tipo", "Numero", "Nombre"};
		this.setColumnIdentifiers(columnNames);
		String tipo = "Undefined";
		for(Telefono telefono : telefonos){
			if (telefono instanceof TelefonoMovil)
				tipo = "TelefonoMovil";
			else if(telefono instanceof TelefonoFijo)
				tipo = "TelefonoFijo";	
			Object[] newRow = new Object[]{tipo, telefono.getNumero(), telefono.getUsuario().getNombre()};
			addRow(newRow);			
		}
	}

}
