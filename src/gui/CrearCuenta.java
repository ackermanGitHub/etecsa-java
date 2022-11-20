package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import logic.Sistema;

import javax.swing.SwingConstants;

import auxiliar.Utils;

@SuppressWarnings("serial")
public class CrearCuenta extends JDialog {

	private JPanel contentPanel = new JPanel();

	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	private JRadioButton rdbtnPersonaNatural;
	private JRadioButton rdbtnPersonaJuridica;
	private JRadioButton rdbtnEntidadNoEstatal;

	public CrearCuenta(final Sistema sistem) {
		setFont(new Font("Dialog", Font.PLAIN, 12));

		setTitle("Cuenta Nueva");
		setBounds(100, 100, 430, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);

		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 394, 224);
			contentPanel.add(panel);
			panel.setLayout(null);

			{
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblUsuario.setFont(new Font("Arial", Font.BOLD, 15));
				lblUsuario.setBounds(10, 20, 170, 23);
				panel.add(lblUsuario);
			}
			{
				userNameField = new JTextField();
				userNameField.setFont(new Font("Arial", Font.PLAIN, 15));
				userNameField.setBounds(209, 21, 165, 23);
				panel.add(userNameField);
				userNameField.setColumns(10);
			}
			{
				JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
				lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
				lblContrasena.setFont(new Font("Arial", Font.BOLD, 15));
				lblContrasena.setBounds(10, 58, 170, 23);
				panel.add(lblContrasena);
			}
			{
				JLabel lblConfirmarContrasena = new JLabel("Confirmar Contrase\u00F1a:");
				lblConfirmarContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
				lblConfirmarContrasena.setFont(new Font("Arial", Font.BOLD, 15));
				lblConfirmarContrasena.setBounds(10, 94, 170, 23);
				panel.add(lblConfirmarContrasena);
			}
			{
				JLabel lblTipoDeCuenta = new JLabel("Tipo de Cuenta:");
				lblTipoDeCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTipoDeCuenta.setFont(new Font("Arial", Font.BOLD, 15));
				lblTipoDeCuenta.setBounds(10, 144, 170, 23);
				panel.add(lblTipoDeCuenta);
			}

			ButtonGroup btngroup = new ButtonGroup();

			rdbtnPersonaNatural = new JRadioButton("Persona Natural");
			rdbtnPersonaNatural.setFont(new Font("Arial", Font.BOLD, 15));
			rdbtnPersonaNatural.setBounds(209, 194, 165, 23);
			panel.add(rdbtnPersonaNatural);
			btngroup.add(rdbtnPersonaNatural);

			rdbtnPersonaJuridica = new JRadioButton("Persona Jur\u00EDdica");
			rdbtnPersonaJuridica.setFont(new Font("Arial", Font.BOLD, 15));
			rdbtnPersonaJuridica.setBounds(209, 144, 165, 23);
			panel.add(rdbtnPersonaJuridica);
			btngroup.add(rdbtnPersonaJuridica);

			rdbtnEntidadNoEstatal = new JRadioButton("Entidad no Estatal");
			rdbtnEntidadNoEstatal.setFont(new Font("Arial", Font.BOLD, 15));
			rdbtnEntidadNoEstatal.setBounds(209, 168, 165, 23);
			panel.add(rdbtnEntidadNoEstatal);
			btngroup.add(rdbtnEntidadNoEstatal);

			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
			passwordField.setBounds(209, 59, 165, 23);
			panel.add(passwordField);

			passwordField_1 = new JPasswordField();
			passwordField_1.setFont(new Font("Arial", Font.PLAIN, 15));
			passwordField_1.setBounds(209, 95, 165, 23);
			panel.add(passwordField_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 246, 394, 43);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String userName = userNameField.getText();
						@SuppressWarnings("deprecation")
						String password1 = passwordField.getText();
						@SuppressWarnings("deprecation")
						String password2 = passwordField_1.getText();

						if(!password1.equals(password2))
							throw new IllegalArgumentException("Las contraseñas no coinciden");

						if(sistem.getUsuario(userName) != null) 
							throw new IllegalArgumentException("El nombre de usuario ya está tomado");						

						if(!Utils.validarNombreUsuario(userName))
							throw new IllegalArgumentException("Nombre de usuario no válido");

						if(!Utils.validarNombreUsuario(password1))
							throw new IllegalArgumentException("Contraseña no válida");						

						if(rdbtnPersonaNatural.isSelected()){
							CrearPersonaNatural datosPersonaNatural = new CrearPersonaNatural(userName, password1, sistem);
							datosPersonaNatural.setVisible(true);
							datosPersonaNatural.setAlwaysOnTop(true);
							dispose();
						} else if(rdbtnPersonaJuridica.isSelected()){
							CrearPersonaJuridica datosPersonaJuridica = new CrearPersonaJuridica(userName, password1, sistem);
							datosPersonaJuridica.setVisible(true);
							datosPersonaJuridica.setAlwaysOnTop(true);
							dispose();
						} else if(rdbtnEntidadNoEstatal.isSelected()){
							CrearEntidadNoEstatal datosEntidadNoEstatal = new CrearEntidadNoEstatal(userName, password1, sistem);
							datosEntidadNoEstatal.setVisible(true);
							datosEntidadNoEstatal.setAlwaysOnTop(true);
							dispose();
						} else {
							throw new IllegalArgumentException("El usuario no ha seleccionado un tipo de cuenta");
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
