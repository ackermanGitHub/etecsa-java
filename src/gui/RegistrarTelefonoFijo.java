package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Sistema;
import logic.TelefonoFijo;
import logic.Usuario;

@SuppressWarnings("serial")
public class RegistrarTelefonoFijo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroTelefono;

	public RegistrarTelefonoFijo(final Sistema sistem, final Usuario usuario) {
		setTitle("Registrar Nuevo Telefono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		txtNumeroTelefono.setBounds(106, 69, 217, 29);
		contentPane.add(txtNumeroTelefono);
		txtNumeroTelefono.setColumns(10);

		JLabel lblIntroduzcaSuNuevo = new JLabel("Introduzca su nuevo n\u00FAmero de tel\u00E9fono:");
		lblIntroduzcaSuNuevo.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblIntroduzcaSuNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaSuNuevo.setBounds(96, 25, 238, 39);
		contentPane.add(lblIntroduzcaSuNuevo);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = txtNumeroTelefono.getText();
				TelefonoFijo nuevoFijo = new TelefonoFijo(numero, usuario);
				usuario.addTelefonoFijo(sistem, nuevoFijo);
				sistem.addTelefono(nuevoFijo);
				dispose();
			}
		});
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.setBounds(243, 125, 80, 25);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setBounds(333, 125, 80, 25);
		contentPane.add(btnCancel);
	}

}
