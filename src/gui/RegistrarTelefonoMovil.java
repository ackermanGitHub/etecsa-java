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

import logic.PersonaNatural;
import logic.Sistema;
import logic.Usuario;
import java.awt.Color;

@SuppressWarnings("serial")
public class RegistrarTelefonoMovil extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroTelefono;

	public RegistrarTelefonoMovil(final Sistema sistema, final Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarTelefonoMovil.class.getResource("/images/smartphone-32.png")));
		setTitle("Registrar Nuevo Telefono");
		setBounds(100, 100, 410, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = txtNumeroTelefono.getText();

				if (!Utils.validarNumeroMovil(numero)) 
					Utils.launchError("El número ingresado no es válido, debe ser de 8 cifras comenzando por 5");
				if(usuario instanceof PersonaNatural && usuario.getTelefonosMoviles().size() == 2)
					Utils.launchError("Las Personas Naturales solamente pueden tener dos teléfonos móviles");
				if(sistema.getTelefono(numero) == null){
					usuario.addTelefonoMovil(numero);
					dispose();					
				} else
					Utils.launchError("Ese número ya se encuentra registrado");
			}
		});
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.setBounds(216, 135, 80, 25);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setBounds(306, 135, 80, 25);
		contentPane.add(btnCancel);

		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumeroTelefono.setColumns(10);
		txtNumeroTelefono.setBounds(127, 78, 150, 29);
		contentPane.add(txtNumeroTelefono);

		JLabel lblIntroduzcaSuNuevo = new JLabel("Introduzca su nuevo n\u00FAmero de tel\u00E9fono m\u00F3vil:");
		lblIntroduzcaSuNuevo.setForeground(Color.BLUE);
		lblIntroduzcaSuNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaSuNuevo.setFont(new Font("Arial", Font.BOLD, 13));
		lblIntroduzcaSuNuevo.setBounds(17, 28, 369, 39);
		contentPane.add(lblIntroduzcaSuNuevo);
	}
}
