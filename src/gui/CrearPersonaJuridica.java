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
public class CrearPersonaJuridica extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreEmpresa;
	private JTextField txtEntidad;
	private JTextField txtOrganismo;
	private JTextField txtDireccionPostal;
	private JTextField txtMunicipio;
	private JTextField txtProvincia;
	private JTextField txtNombre;
	private JTextField txtApellido_1;
	private JTextField txtApellido_2;
	private JTextField txtID;

	public CrearPersonaJuridica(final String userName, final String password, final Sistema sistema) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setTitle("Creando Cuenta de Persona Jur�dica");
		setBounds(100, 100, 388, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombreEmpresa.setBounds(169, 54, 170, 23);
		contentPanel.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);

		JLabel lblNombreEmpresa = new JLabel("Nombre de Empresa:");
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreEmpresa.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombreEmpresa.setBounds(21, 54, 138, 23);
		contentPanel.add(lblNombreEmpresa);

		JLabel lblEntidad = new JLabel("Entidad:");
		lblEntidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntidad.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEntidad.setBounds(21, 85, 138, 23);
		contentPanel.add(lblEntidad);

		JLabel lblOrganismo = new JLabel("Organismo:");
		lblOrganismo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrganismo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblOrganismo.setBounds(21, 116, 138, 23);
		contentPanel.add(lblOrganismo);

		JLabel lblId = new JLabel("Direccion Postal:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 13));
		lblId.setBounds(21, 147, 138, 23);
		contentPanel.add(lblId);

		txtEntidad = new JTextField();
		txtEntidad.setFont(new Font("Arial", Font.PLAIN, 13));
		txtEntidad.setColumns(10);
		txtEntidad.setBounds(169, 85, 170, 23);
		contentPanel.add(txtEntidad);

		txtOrganismo = new JTextField();
		txtOrganismo.setFont(new Font("Arial", Font.PLAIN, 13));
		txtOrganismo.setColumns(10);
		txtOrganismo.setBounds(169, 116, 170, 23);
		contentPanel.add(txtOrganismo);

		txtDireccionPostal = new JTextField();
		txtDireccionPostal.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDireccionPostal.setColumns(10);
		txtDireccionPostal.setBounds(169, 147, 170, 23);
		contentPanel.add(txtDireccionPostal);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		lblMunicipio.setBounds(21, 178, 138, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(21, 209, 138, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(169, 178, 170, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(169, 209, 170, 23);
		contentPanel.add(txtProvincia);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIntroduzcaLosDatos.setBounds(33, 11, 290, 28);
		contentPanel.add(lblIntroduzcaLosDatos);

		JLabel lblRepresentante = new JLabel("Representante:");
		lblRepresentante.setFont(new Font("Arial", Font.PLAIN, 13));
		lblRepresentante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepresentante.setBounds(95, 240, 165, 28);
		contentPanel.add(lblRepresentante);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombre.setBounds(21, 279, 138, 23);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(169, 280, 170, 23);
		contentPanel.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido 1:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido.setBounds(21, 310, 138, 23);
		contentPanel.add(lblApellido);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(169, 311, 170, 23);
		contentPanel.add(txtApellido_1);

		JLabel lblApellido_1 = new JLabel("Apellido 2:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblApellido_1.setBounds(21, 341, 138, 23);
		contentPanel.add(lblApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 13));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(169, 342, 170, 23);
		contentPanel.add(txtApellido_2);

		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblId_1.setBounds(21, 372, 138, 23);
		contentPanel.add(lblId_1);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 13));
		txtID.setColumns(10);
		txtID.setBounds(169, 373, 170, 23);
		contentPanel.add(txtID);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(20, 406, 332, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nombreRepr = txtNombre.getText();
						String apellido1Repr = txtApellido_1.getText();
						String apellido2Repr = txtApellido_2.getText();
						String IDRepr = txtID.getText();

						String nombreEmpresa =  txtNombreEmpresa.getText();
						String entidad = txtEntidad.getText();
						String organismo = txtOrganismo.getText();
						String municipio = txtMunicipio.getText();
						String provincia = txtProvincia.getText();
						String direccionPostal = txtDireccionPostal.getText();

						String errorMessage = null;
						if(nombreRepr.isEmpty() || apellido1Repr.isEmpty() || apellido2Repr.isEmpty()
								|| IDRepr.isEmpty() || nombreEmpresa.isEmpty() || entidad.isEmpty() || organismo.isEmpty() 
								|| municipio.isEmpty() || provincia. isEmpty() || direccionPostal.isEmpty())
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
							errorMessage = "El nombre de la empresa no es válido";
						else if(!Utils.validarNombre(entidad))
							errorMessage = "La entidad no es válida";	
						else if(!Utils.validarNombre(organismo))
							errorMessage = "El organismo no es válido";
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
						sistema.addPersonaJuridica(userName, password, nombreEmpresa, entidad, 
								organismo, municipio, provincia, direccionPostal, nuevoRepresent);
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
