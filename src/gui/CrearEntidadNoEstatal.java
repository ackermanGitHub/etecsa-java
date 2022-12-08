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
import logic.Representante;
import logic.Sistema;

@SuppressWarnings("serial")
public class CrearEntidadNoEstatal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDireccionPostal;
	private JTextField txtApellido_1;
	private JTextField txtApellido_2;
	private JTextField txtID;
	private JTextField txtNombreRepresent;
	private JTextField txtMunicipio;
	private JTextField txtProvincia;

	public CrearEntidadNoEstatal(final String userName, final String password, final Sistema sistema) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setTitle("Creando Cuenta de Entidad no Estatal");
		setBounds(100, 100, 350, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombre.setBounds(146, 50, 160, 23);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombre.setBounds(20, 50, 117, 23);
		contentPanel.add(lblNombre);

		JLabel lblDireccionPostal = new JLabel("Direccion Postal:");
		lblDireccionPostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccionPostal.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDireccionPostal.setBounds(20, 81, 117, 23);
		contentPanel.add(lblDireccionPostal);

		JLabel lblApellido_1 = new JLabel("Apellido 1:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido_1.setBounds(20, 261, 117, 23);
		contentPanel.add(lblApellido_1);

		JLabel lblApellido_2 = new JLabel("Apellido 2:");
		lblApellido_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido_2.setBounds(20, 292, 117, 23);
		contentPanel.add(lblApellido_2);

		txtDireccionPostal = new JTextField();
		txtDireccionPostal.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDireccionPostal.setColumns(10);
		txtDireccionPostal.setBounds(146, 81, 160, 23);
		contentPanel.add(txtDireccionPostal);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(146, 261, 160, 23);
		contentPanel.add(txtApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(146, 292, 160, 23);
		contentPanel.add(txtApellido_2);

		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Arial", Font.PLAIN, 13));
		lblID.setBounds(20, 323, 117, 23);
		contentPanel.add(lblID);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 13));
		txtID.setColumns(10);
		txtID.setBounds(146, 323, 160, 23);
		contentPanel.add(txtID);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta:");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIntroduzcaLosDatos.setBounds(25, 11, 283, 28);
		contentPanel.add(lblIntroduzcaLosDatos);

		JLabel lblRepresentante = new JLabel("Representante:");
		lblRepresentante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRepresentante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepresentante.setBounds(76, 188, 181, 31);
		contentPanel.add(lblRepresentante);

		JLabel NombreRepresentante = new JLabel("Nombre:");
		NombreRepresentante.setHorizontalAlignment(SwingConstants.RIGHT);
		NombreRepresentante.setFont(new Font("Arial", Font.PLAIN, 13));
		NombreRepresentante.setBounds(20, 230, 117, 23);
		contentPanel.add(NombreRepresentante);

		txtNombreRepresent = new JTextField();
		txtNombreRepresent.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombreRepresent.setColumns(10);
		txtNombreRepresent.setBounds(146, 230, 160, 23);
		contentPanel.add(txtNombreRepresent);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMunicipio.setBounds(20, 115, 117, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(20, 149, 117, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(146, 115, 160, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(146, 151, 160, 23);
		contentPanel.add(txtProvincia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 369, 315, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String nombreRepr = txtNombreRepresent.getText();
						String apellido1Repr = txtApellido_1.getText();
						String apellido2Repr = txtApellido_2.getText();
						String IDRepr = txtID.getText();

						String nombreEmpresa =  txtNombre.getText();
						String municipio = txtMunicipio.getText();
						String provincia = txtProvincia.getText();
						String direccionPostal = txtDireccionPostal.getText();

						String errorMessage = null;
						if(nombreRepr.isEmpty() || apellido1Repr.isEmpty() || apellido2Repr.isEmpty()
								|| IDRepr.isEmpty() || nombreEmpresa.isEmpty() || municipio.isEmpty() 
								|| provincia. isEmpty() || direccionPostal.isEmpty())
							errorMessage = "Rellene todos los campos";						
						else if(!Utils.validarNombre(nombreRepr))
							errorMessage = "El nombre del representante no es válido";
						else if(!Utils.validarNombre(apellido1Repr))
							errorMessage = "El primer apellido del representante no es válido";	
						else if(!Utils.validarNombre(apellido2Repr))
							errorMessage = "El segundo apellido del representante no es válido";
						else if(!Utils.validarID(IDRepr))
							errorMessage = "El ID del representante no es válido";				
						else if(!Utils.validarNombre(nombreEmpresa))
							errorMessage = "El nombre de la entidad no es válido";
						else if(!Utils.validarNombre(municipio))
							errorMessage = "El municipio no es válido";	
						else if(!Utils.validarNombre(provincia))
							errorMessage = "La provincia no es válida";			
						else if(!Utils.validarDireccion(direccionPostal))
							errorMessage = "La dirección postal no es válida";		
						if(errorMessage != null)
							Utils.launchError(errorMessage);

						Representante nuevoRepresent = new Representante(nombreRepr, 
								apellido1Repr, apellido2Repr, IDRepr, true);
						sistema.addEntidadNoEstatal(userName, password, nombreEmpresa, 
								municipio, provincia, direccionPostal, nuevoRepresent);
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
