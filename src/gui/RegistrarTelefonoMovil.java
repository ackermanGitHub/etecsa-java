package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import auxiliar.Utils;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Sistema;
import logic.Usuario;

@SuppressWarnings("serial")
public class RegistrarTelefonoMovil extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroTelefono;

	public RegistrarTelefonoMovil(final Sistema sistem, final Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setTitle("Registrar Nuevo Telefono");
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = txtNumeroTelefono.getText();
				if(sistem.getTelefono(numero) == null){
					usuario.addTelefonoMovil(numero);
					dispose();					
				} else {
					Utils.launchError("Ese número ya se encuentra registrado");
				}
			}
		});
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.setBounds(141, 135, 80, 25);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setBounds(231, 135, 80, 25);
		contentPane.add(btnCancel);
		
		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumeroTelefono.setColumns(10);
		txtNumeroTelefono.setBounds(97, 78, 150, 29);
		contentPane.add(txtNumeroTelefono);
		
		JLabel lblIntroduzcaSuNuevo = new JLabel("Introduzca su nuevo n\u00FAmero de tel\u00E9fono m\u00F3vil:");
		lblIntroduzcaSuNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaSuNuevo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIntroduzcaSuNuevo.setBounds(25, 28, 294, 39);
		contentPane.add(lblIntroduzcaSuNuevo);
	}
}
