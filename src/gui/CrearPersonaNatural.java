package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import auxiliar.Utils;
import logic.Sistema;
import java.awt.Color;

@SuppressWarnings("serial")
public class CrearPersonaNatural extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido_1;
	private JTextField txtApellido_2;
	private JTextField txtID;
	private JTextField txtDireccion;
	private JTextField txtMunicipio;
	private JTextField txtProvincia;

	public CrearPersonaNatural(final String userName, final String password, final Sistema sistema) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/anadir-32.png")));
		setTitle("Creando Cuenta de Persona Natural");
		setBounds(100, 100, 329, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombre.setBounds(133, 54, 160, 23);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombre.setBounds(21, 54, 91, 23);
		contentPanel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido 1:");
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido.setBounds(21, 85, 91, 23);
		contentPanel.add(lblApellido);

		JLabel lblApellido_1 = new JLabel("Apellido 2:");
		lblApellido_1.setForeground(new Color(0, 0, 0));
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido_1.setBounds(21, 116, 91, 23);
		contentPanel.add(lblApellido_1);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 13));
		lblId.setBounds(21, 147, 91, 23);
		contentPanel.add(lblId);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(0, 0, 0));
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDireccion.setBounds(21, 178, 91, 23);
		contentPanel.add(lblDireccion);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(133, 85, 160, 23);
		contentPanel.add(txtApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(133, 116, 160, 23);
		contentPanel.add(txtApellido_2);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 13));
		txtID.setColumns(10);
		txtID.setBounds(133, 147, 160, 23);
		contentPanel.add(txtID);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(133, 178, 160, 23);
		contentPanel.add(txtDireccion);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setForeground(new Color(0, 0, 0));
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMunicipio.setBounds(21, 209, 91, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(new Color(0, 0, 0));
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(21, 240, 91, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(133, 209, 160, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(133, 240, 160, 23);
		contentPanel.add(txtProvincia);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta");
		lblIntroduzcaLosDatos.setForeground(new Color(0, 0, 0));
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIntroduzcaLosDatos.setBounds(27, 11, 258, 28);
		contentPanel.add(lblIntroduzcaLosDatos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(28, 274, 266, 31);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {		
						String name = txtNombre.getText();
						String apellido1 = txtApellido_1.getText();
						String apellido2 = txtApellido_2.getText();
						String ID = txtID.getText();
						String direccion = txtDireccion.getText();
						String municipio = txtMunicipio.getText();
						String provincia = txtProvincia.getText();

						String errorMessage = null;
						if(name.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() || ID.isEmpty() 
							|| direccion.isEmpty() || municipio.isEmpty() || provincia.isEmpty())
							errorMessage = "Rellene todos los campos";						
						else if(!Utils.validarNombre(name))
							errorMessage = "El nombre no es válido";
						else if(!Utils.validarNombre(apellido1))
							errorMessage = "El primer apellido no es válido";	
						else if(!Utils.validarNombre(apellido2))
							errorMessage = "El segundo apellido no es válido";
						else if(!Utils.validarID(ID))
							errorMessage = "El ID no es válido";	
						else if(!Utils.validarDireccion(direccion))
							errorMessage = "La dirección no es válida";		
						else if(!Utils.validarNombre(municipio))
							errorMessage = "El municipio no es válido";	
						else if(!Utils.validarNombre(provincia))
							errorMessage = "La provincia no es válida";			
						if(errorMessage != null)
							Utils.launchError(errorMessage);

						sistema.addPersonaNatural(userName, password, name, apellido1, 
								apellido2, ID, direccion, municipio, provincia);
						Principal p = new Principal(sistema.getUsuario(userName), sistema);
						p.setVisible(true);	
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
