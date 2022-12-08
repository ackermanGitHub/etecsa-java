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

import logic.Usuario;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DatosDeUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DatosDeUsuarioTableModel tableModel;
	private JMenuBar menuBar;
	private JButton btnCerrar;

	public DatosDeUsuario(ArrayList<Usuario> usuarios) {
		setTitle("Datos Usuarios");
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
		tableModel = new DatosDeUsuarioTableModel(usuarios);
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
