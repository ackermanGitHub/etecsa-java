package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Sistema;
import logic.Usuario;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Login extends JDialog {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtUserPassword;

	public Login(final Sistema sistema) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/login.png")));
		setForeground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setTitle("Autenticaci\u00F3n de Usuario");
		setBounds(100, 100, 429, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(67, 33, 94, 23);
		contentPane.add(lblUsuario);

		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUserName.setBounds(171, 33, 165, 23);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		lblContrasena.setBounds(67, 85, 94, 23);
		contentPane.add(lblContrasena);

		txtUserPassword = new JPasswordField();
		txtUserPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUserPassword.setToolTipText("");
		txtUserPassword.setBounds(171, 85, 165, 23);
		contentPane.add(txtUserPassword);

		final JLabel lblErrorMessage = new JLabel("Nombre de Usuario o Contrase\u00F1a Incorrecta.");
		lblErrorMessage.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setBounds(31, 144, 359, 14);
		lblErrorMessage.setVisible(false);
		contentPane.add(lblErrorMessage);


		JButton btnIniciarSecion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSecion.setBackground(new Color(17, 24, 141));
		btnIniciarSecion.setForeground(new Color(255, 255, 255));
		btnIniciarSecion.setFont(new Font("Arial", Font.BOLD, 14));
		btnIniciarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				@SuppressWarnings("deprecation")
				String userPassword = txtUserPassword.getText();
				String userName = txtUserName.getText();
				Usuario usuario = sistema.getUsuario(userName, userPassword);
				
				if(usuario != null){
					Principal p = new Principal(usuario, sistema);
					p.setVisible(true);					
					dispose();
				} else {
					if(userName.isEmpty() || userPassword.isEmpty())
						lblErrorMessage.setText("Rellene todos los campos.");
					else
						lblErrorMessage.setText("Nombre de Usuario o Contrase\u00F1a Incorrecta.");
					lblErrorMessage.setVisible(true);
				}
			}
		});
		btnIniciarSecion.setBounds(74, 169, 141, 31);
		contentPane.add(btnIniciarSecion);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(17, 24, 141));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(241, 169, 107, 31);
		contentPane.add(btnSalir);

		JLabel lblCrearCuenta = new JLabel("Crear Cuenta");
		lblCrearCuenta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CrearCuenta crearCuenta = new CrearCuenta(sistema);
				crearCuenta.setVisible(true);
				dispose();
			}
		});
		lblCrearCuenta.setForeground(Color.BLUE);
		lblCrearCuenta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblCrearCuenta.setBounds(181, 119, 94, 23);
		contentPane.add(lblCrearCuenta);
	}

}
