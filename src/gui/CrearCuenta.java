package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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
import java.awt.Color;

@SuppressWarnings("serial")
public class CrearCuenta extends JDialog {

	private JPanel contentPanel = new JPanel();

	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	private JRadioButton rdbtnPersonaNatural;
	private JRadioButton rdbtnPersonaJuridica;
	private JRadioButton rdbtnEntidadNoEstatal;

	public CrearCuenta(final Sistema sistema) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearCuenta.class.getResource("/images/anadir-32.png")));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Cuenta Nueva");
		setBounds(100, 100, 417, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(15, 11, 380, 224);
			contentPanel.add(panel);
			panel.setLayout(null);

			{
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setForeground(new Color(0, 0, 0));
				lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
				lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
				lblUsuario.setBounds(82, 21, 80, 23);
				panel.add(lblUsuario);
			}
			{
				userNameField = new JTextField();
				userNameField.setFont(new Font("Arial", Font.PLAIN, 13));
				userNameField.setBounds(183, 21, 165, 23);
				panel.add(userNameField);
				userNameField.setColumns(10);
			}
			{
				JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
				lblContrasena.setForeground(new Color(0, 0, 0));
				lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
				lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
				lblContrasena.setBounds(71, 59, 91, 23);
				panel.add(lblContrasena);
			}
			{
				JLabel lblConfirmarContrasena = new JLabel("Confirmar Contrase\u00F1a:");
				lblConfirmarContrasena.setForeground(new Color(0, 0, 0));
				lblConfirmarContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
				lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
				lblConfirmarContrasena.setBounds(10, 95, 152, 23);
				panel.add(lblConfirmarContrasena);
			}
			{
				JLabel lblTipoDeCuenta = new JLabel("Tipo de Cuenta:");
				lblTipoDeCuenta.setForeground(new Color(0, 0, 0));
				lblTipoDeCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTipoDeCuenta.setFont(new Font("Arial", Font.PLAIN, 13));
				lblTipoDeCuenta.setBounds(10, 145, 152, 23);
				panel.add(lblTipoDeCuenta);
			}

			ButtonGroup btngroup = new ButtonGroup();

			rdbtnPersonaNatural = new JRadioButton("Persona Natural");
			rdbtnPersonaNatural.setForeground(new Color(0, 0, 0));
			rdbtnPersonaNatural.setBackground(Color.WHITE);
			rdbtnPersonaNatural.setFont(new Font("Arial", Font.PLAIN, 13));
			rdbtnPersonaNatural.setBounds(183, 196, 165, 23);
			panel.add(rdbtnPersonaNatural);
			btngroup.add(rdbtnPersonaNatural);

			rdbtnPersonaJuridica = new JRadioButton("Persona Jur\u00EDdica");
			rdbtnPersonaJuridica.setForeground(new Color(0, 0, 0));
			rdbtnPersonaJuridica.setBackground(Color.WHITE);
			rdbtnPersonaJuridica.setFont(new Font("Arial", Font.PLAIN, 13));
			rdbtnPersonaJuridica.setBounds(183, 144, 165, 23);
			panel.add(rdbtnPersonaJuridica);
			btngroup.add(rdbtnPersonaJuridica);

			rdbtnEntidadNoEstatal = new JRadioButton("Entidad no Estatal");
			rdbtnEntidadNoEstatal.setForeground(new Color(0, 0, 0));
			rdbtnEntidadNoEstatal.setBackground(Color.WHITE);
			rdbtnEntidadNoEstatal.setFont(new Font("Arial", Font.PLAIN, 13));
			rdbtnEntidadNoEstatal.setBounds(183, 170, 165, 23);
			panel.add(rdbtnEntidadNoEstatal);
			btngroup.add(rdbtnEntidadNoEstatal);

			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
			passwordField.setBounds(183, 59, 165, 23);
			panel.add(passwordField);

			passwordField_1 = new JPasswordField();
			passwordField_1.setFont(new Font("Arial", Font.PLAIN, 13));
			passwordField_1.setBounds(183, 95, 165, 23);
			panel.add(passwordField_1);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(15, 246, 380, 32);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String errorMessage = null;
						String userName = userNameField.getText();
						@SuppressWarnings("deprecation")
						String password1 = passwordField.getText();
						@SuppressWarnings("deprecation")
						String password2 = passwordField_1.getText();

						if(userName.isEmpty() || password1.isEmpty() || password2.isEmpty())
							errorMessage = "Rellene todos los campos";
						else if(!password1.equals(password2))
							errorMessage = "Las contraseñas no coinciden";
						else if(sistema.getUsuario(userName) != null) 
							errorMessage = "El nombre de usuario ya está tomado";						
						else if(!Utils.validarNombreUsuario(userName))
							errorMessage = "El nombre de usuario no es válido";
						else if(!Utils.validarNombreUsuario(password1))
							errorMessage = "La contraseña no es válida";						
						if(errorMessage != null)
							Utils.launchError(errorMessage);

						if(rdbtnPersonaNatural.isSelected()){
							CrearPersonaNatural datosPersonaNatural = new CrearPersonaNatural(userName, password1, sistema);
							datosPersonaNatural.setVisible(true);
							dispose();
						} else if(rdbtnPersonaJuridica.isSelected()){
							CrearPersonaJuridica datosPersonaJuridica = new CrearPersonaJuridica(userName, password1, sistema);
							datosPersonaJuridica.setVisible(true);
							dispose();
						} else if(rdbtnEntidadNoEstatal.isSelected()){
							CrearEntidadNoEstatal datosEntidadNoEstatal = new CrearEntidadNoEstatal(userName, password1, sistema);
							datosEntidadNoEstatal.setVisible(true);
							dispose();
						} else {
							Utils.launchError("Seleccione un tipo de cuenta");
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
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 12));
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
