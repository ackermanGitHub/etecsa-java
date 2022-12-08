package datos;

import gui.Login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import logic.Sistema;
import logic.Telefono;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DatosDeTelefono extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DatosDeTelefonoTableModel tableModel;
	private JMenuBar menuBar;
	private JButton btnCerrar;

	public DatosDeTelefono(Sistema sistema, ArrayList<Telefono> telefonos) {
		setTitle("Datos Teléfonos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setBounds(100, 100, 524, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 528, 24);
		contentPane.add(menuBar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 488, 264);
		contentPane.add(scrollPane);

		table = new JTable();
		tableModel = new DatosDeTelefonoTableModel(sistema, telefonos);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		table.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
			public boolean isCellEditable(EventObject evt) {
				return false;
			}
		});
		table.setRowSelectionAllowed(true);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCerrar.setBounds(417, 313, 81, 23);
		contentPane.add(btnCerrar);
	}

}
