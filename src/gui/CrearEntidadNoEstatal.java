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

import logic.EntidadNoEstatal;
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

	public CrearEntidadNoEstatal(final String userName, final String password, final Sistema sistem) {
		setTitle("Creando Cuenta de Entidad no Estatal");
		setBounds(100, 100, 401, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(191, 54, 160, 23);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre.setBounds(23, 54, 146, 23);
		contentPanel.add(lblNombre);

		JLabel lblDireccionPostal = new JLabel("Direccion Postal:");
		lblDireccionPostal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccionPostal.setFont(new Font("Arial", Font.BOLD, 15));
		lblDireccionPostal.setBounds(23, 85, 146, 23);
		contentPanel.add(lblDireccionPostal);

		JLabel lblApellido_1 = new JLabel("Apellido 1:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido_1.setBounds(23, 265, 146, 23);
		contentPanel.add(lblApellido_1);

		JLabel lblApellido_2 = new JLabel("Apellido 2:");
		lblApellido_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido_2.setBounds(23, 296, 146, 23);
		contentPanel.add(lblApellido_2);

		txtDireccionPostal = new JTextField();
		txtDireccionPostal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccionPostal.setColumns(10);
		txtDireccionPostal.setBounds(191, 85, 160, 23);
		contentPanel.add(txtDireccionPostal);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(191, 265, 160, 23);
		contentPanel.add(txtApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(191, 296, 160, 23);
		contentPanel.add(txtApellido_2);

		JLabel lblID = new JLabel("ID:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Arial", Font.BOLD, 15));
		lblID.setBounds(23, 327, 146, 23);
		contentPanel.add(lblID);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(191, 327, 160, 23);
		contentPanel.add(txtID);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblIntroduzcaLosDatos.setBounds(35, 11, 316, 28);
		contentPanel.add(lblIntroduzcaLosDatos);

		JLabel lblRepresentante = new JLabel("Representante:");
		lblRepresentante.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblRepresentante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepresentante.setBounds(35, 192, 316, 31);
		contentPanel.add(lblRepresentante);

		JLabel NombreRepresentante = new JLabel("Nombre:");
		NombreRepresentante.setHorizontalAlignment(SwingConstants.RIGHT);
		NombreRepresentante.setFont(new Font("Arial", Font.BOLD, 15));
		NombreRepresentante.setBounds(23, 234, 146, 23);
		contentPanel.add(NombreRepresentante);

		txtNombreRepresent = new JTextField();
		txtNombreRepresent.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombreRepresent.setColumns(10);
		txtNombreRepresent.setBounds(191, 234, 160, 23);
		contentPanel.add(txtNombreRepresent);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.BOLD, 15));
		lblMunicipio.setBounds(23, 119, 146, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		lblProvincia.setBounds(23, 153, 146, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(191, 119, 160, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 15));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(191, 155, 160, 23);
		contentPanel.add(txtProvincia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Representante nuevoRepresent = new Representante(txtNombreRepresent.getText(), txtApellido_1.getText(), txtApellido_2.getText(), txtID.getText(), true);
						EntidadNoEstatal nuevoUsuario = new EntidadNoEstatal(userName, password, txtNombre.getText(), txtMunicipio.getText(), txtProvincia.getText(), txtDireccionPostal.getText(), nuevoRepresent);
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
