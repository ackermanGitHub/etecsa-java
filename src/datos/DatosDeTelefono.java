package datos;

import gui.Login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logic.Telefono;

@SuppressWarnings("serial")
public class DatosDeTelefono extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TelefonoTableModel tableModel;
	private JMenuBar menuBar;

	public DatosDeTelefono(ArrayList<Telefono> telefonos) {
		setTitle("Datos Teléfonos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setBounds(100, 100, 524, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 528, 24);
		contentPane.add(menuBar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 488, 264);
		contentPane.add(scrollPane);

		table = new JTable();
		tableModel = new TelefonoTableModel(telefonos);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}

}
