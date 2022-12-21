package datos;

import gui.AcercaDe;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import logic.Sistema;
import logic.Telefono;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DatosDeTelefono extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private DatosDeTelefonoTM tableModel;
	private JButton btnCerrar;
	private JLabel lblTitle;

	public DatosDeTelefono(Sistema sistema, ArrayList<Telefono> telefonos) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("/images/datos-telefono.png")));
		setTitle("Datos Teléfonos");
		setBounds(100, 100, 524, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 35, 490, 265);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		tableModel = new DatosDeTelefonoTM(sistema, telefonos);
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
		btnCerrar.setBounds(429, 311, 75, 25);
		contentPane.add(btnCerrar);
		
		lblTitle = new JLabel("Datos de los Tel\u00E9fonos:");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTitle.setBounds(14, 5, 230, 25);
		contentPane.add(lblTitle);
	}
}
