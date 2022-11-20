package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import logic.PersonaJuridica;
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

	public CrearPersonaJuridica(final String userName, final String password, final Sistema sistem) {
		setTitle("Creando Cuenta de Persona Jurídica");
		setBounds(100, 100, 432, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);

		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombreEmpresa.setBounds(199, 54, 196, 23);
		contentPanel.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);

		JLabel lblNombreEmpresa = new JLabel("Nombre de Empresa:");
		lblNombreEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreEmpresa.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombreEmpresa.setBounds(24, 54, 165, 23);
		contentPanel.add(lblNombreEmpresa);

		JLabel lblEntidad = new JLabel("Entidad:");
		lblEntidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntidad.setFont(new Font("Arial", Font.BOLD, 15));
		lblEntidad.setBounds(24, 85, 165, 23);
		contentPanel.add(lblEntidad);

		JLabel lblOrganismo = new JLabel("Organismo:");
		lblOrganismo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrganismo.setFont(new Font("Arial", Font.BOLD, 15));
		lblOrganismo.setBounds(24, 116, 165, 23);
		contentPanel.add(lblOrganismo);

		JLabel lblId = new JLabel("Direccion Postal:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.BOLD, 15));
		lblId.setBounds(24, 147, 165, 23);
		contentPanel.add(lblId);

		txtEntidad = new JTextField();
		txtEntidad.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEntidad.setColumns(10);
		txtEntidad.setBounds(199, 85, 196, 23);
		contentPanel.add(txtEntidad);

		txtOrganismo = new JTextField();
		txtOrganismo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtOrganismo.setColumns(10);
		txtOrganismo.setBounds(199, 116, 196, 23);
		contentPanel.add(txtOrganismo);

		txtDireccionPostal = new JTextField();
		txtDireccionPostal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccionPostal.setColumns(10);
		txtDireccionPostal.setBounds(199, 147, 196, 23);
		contentPanel.add(txtDireccionPostal);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.BOLD, 15));
		lblMunicipio.setBounds(24, 178, 165, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		lblProvincia.setBounds(24, 209, 165, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(199, 178, 196, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 15));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(199, 209, 196, 23);
		contentPanel.add(txtProvincia);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblIntroduzcaLosDatos.setBounds(35, 11, 307, 28);
		contentPanel.add(lblIntroduzcaLosDatos);

		JLabel lblRepresentante = new JLabel("Representante:");
		lblRepresentante.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblRepresentante.setHorizontalAlignment(SwingConstants.LEFT);
		lblRepresentante.setBounds(35, 240, 307, 28);
		contentPanel.add(lblRepresentante);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre.setBounds(24, 279, 165, 23);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(199, 280, 196, 23);
		contentPanel.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido 1:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido.setBounds(24, 310, 165, 23);
		contentPanel.add(lblApellido);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(199, 311, 196, 23);
		contentPanel.add(txtApellido_1);

		JLabel lblApellido_1 = new JLabel("Apellido 2:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido_1.setBounds(24, 341, 165, 23);
		contentPanel.add(lblApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(199, 342, 196, 23);
		contentPanel.add(txtApellido_2);

		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblId_1.setBounds(24, 372, 165, 23);
		contentPanel.add(lblId_1);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(199, 373, 196, 23);
		contentPanel.add(txtID);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Representante nuevoRepresent = new Representante(txtNombre.getText(), txtApellido_1.getText(), txtApellido_2.getText(), txtID.getText(), true);
						PersonaJuridica nuevoUsuario = new PersonaJuridica(userName, password, txtNombreEmpresa.getText(), txtEntidad.getText(), txtOrganismo.getText(), txtMunicipio.getText(), txtProvincia.getText(), txtDireccionPostal.getText(), nuevoRepresent);
						sistem.addUsuario(nuevoUsuario);
						Principal p = new Principal(nuevoUsuario, sistem);
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
