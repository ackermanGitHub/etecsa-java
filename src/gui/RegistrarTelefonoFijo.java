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

@SuppressWarnings("serial")
public class RegistrarTelefonoFijo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroTelefono;

	public RegistrarTelefonoFijo(final Sistema sistem, final Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setTitle("Registrar Nuevo Telefono");
		setBounds(100, 100, 357, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);

		txtNumeroTelefono = new JTextField();
		txtNumeroTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNumeroTelefono.setBounds(122, 75, 150, 29);
		contentPane.add(txtNumeroTelefono);
		txtNumeroTelefono.setColumns(10);

		JLabel lblIntroduzcaSuNuevo = new JLabel("Introduzca su nuevo n\u00FAmero de tel\u00E9fono fijo:");
		lblIntroduzcaSuNuevo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIntroduzcaSuNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaSuNuevo.setBounds(44, 25, 263, 39);
		contentPane.add(lblIntroduzcaSuNuevo);

		final JLabel lblProvinciaNum = new JLabel(String.valueOf(Utils.getProvinciaNum(usuario.getProvincia())) + " - ");
		lblProvinciaNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvinciaNum.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvinciaNum.setBounds(73, 75, 40, 29);
		contentPane.add(lblProvinciaNum);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Utils.validarNumeroFijo(txtNumeroTelefono.getText())) 
					Utils.launchError("El número ingresado no es válido, debe ser de 7 cifras sin contar el código de la provincia");
				String numero = String.valueOf(Utils.getProvinciaNum(usuario.getProvincia())) + txtNumeroTelefono.getText();
				if (usuario instanceof PersonaNatural && usuario.getTelefonosFijos().size() == 1) 
					Utils.launchError("Las Personas Naturales solamente pueden tener un teléfono fijo");
				if(sistem.getTelefono(numero) == null){
					usuario.addTelefonoFijo(numero);
					dispose();					
				} else 
					Utils.launchError("Ese n�mero ya se encuentra registrado");
			}
		});
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.setBounds(156, 135, 80, 25);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancel.setBounds(246, 135, 80, 25);
		contentPane.add(btnCancel);
		

	}
}