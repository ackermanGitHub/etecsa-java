package datos;

import javax.swing.table.DefaultTableModel;

import logic.Sistema;
import logic.Telefono;
import logic.TelefonoFijo;
import logic.TelefonoMovil;

@SuppressWarnings("serial")
public class TelefonoTableModel extends DefaultTableModel{
	public TelefonoTableModel(Sistema sistem){
		String[] columnNames = {
				"Tipo", "Numero", "Nombre"};
		this.setColumnIdentifiers(columnNames);
		String tipo = "Undefined";
		for (int i = 0; i < sistem.getListaDeTelefonos().size(); i++) {
			Telefono telefono = sistem.getListaDeTelefonos().get(i);
			if (telefono instanceof TelefonoMovil)
				tipo = "TelefonoMovil";
			else if(telefono instanceof TelefonoFijo)
				tipo = "TelefonoFijo";	
			Object[] newRow = new Object[]{tipo, telefono.getNumero(), telefono.getUsuario().getNombre()};
			addRow(newRow);
		}
	}
}
