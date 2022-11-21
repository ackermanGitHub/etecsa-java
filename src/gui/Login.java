package gui;

import javax.swing.JFrame;
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
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPassword;

	public Login(final Sistema sistem) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setForeground(Color.WHITE);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setTitle("Autenticaci\u00F3n de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 260);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsuario.setBounds(67, 21, 94, 23);
		contentPane.add(lblUsuario);

		userName = new JTextField();
		userName.setFont(new Font("Arial", Font.PLAIN, 15));
		userName.setBounds(171, 21, 165, 23);
		contentPane.add(userName);
		userName.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setForeground(Color.BLACK);
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		lblContrasena.setBounds(67, 73, 94, 23);
		contentPane.add(lblContrasena);

		userPassword = new JPasswordField();
		userPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		userPassword.setToolTipText("");
		userPassword.setBounds(171, 73, 165, 23);
		contentPane.add(userPassword);

		final JLabel errorMessage = new JLabel("Nombre de Usuario o Contrase\u00F1a Incorrecta.");
		errorMessage.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(31, 144, 359, 14);
		errorMessage.setVisible(false);
		contentPane.add(errorMessage);


		JButton btnIniciarSecion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSecion.setBackground(new Color(17, 24, 141));
		btnIniciarSecion.setForeground(new Color(255, 255, 255));
		btnIniciarSecion.setFont(new Font("Arial", Font.BOLD, 14));
		btnIniciarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				@SuppressWarnings("deprecation")
				Usuario usuario = sistem.checkUsuario(userName.getText(), userPassword.getText());

				if(usuario != null){
					Principal p = new Principal(usuario, sistem);
					p.setVisible(true);					
					dispose();
				} else
					errorMessage.setVisible(true);
			}
		});
		btnIniciarSecion.setBounds(67, 169, 141, 31);
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
		btnSalir.setBounds(234, 169, 107, 31);
		contentPane.add(btnSalir);

		JLabel lblCrearCuenta = new JLabel("Crear Cuenta");
		lblCrearCuenta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CrearCuenta dialog = new CrearCuenta(sistem);
				dialog.setVisible(true);
				dispose();
			}
		});
		lblCrearCuenta.setForeground(Color.BLUE);
		lblCrearCuenta.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblCrearCuenta.setBounds(181, 119, 94, 23);
		contentPane.add(lblCrearCuenta);
	}

}
