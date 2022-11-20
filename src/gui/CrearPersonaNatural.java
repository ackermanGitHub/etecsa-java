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

import logic.PersonaNatural;
import logic.Sistema;

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

	public CrearPersonaNatural(final String userName, final String password, final Sistema sistem) {
		setTitle("Creando Cuenta de Persona Natural");
		setBounds(100, 100, 376, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		setLocationRelativeTo(null);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(147, 54, 175, 23);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre.setBounds(35, 54, 91, 23);
		contentPanel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido 1:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido.setBounds(35, 85, 91, 23);
		contentPanel.add(lblApellido);

		JLabel lblApellido_1 = new JLabel("Apellido 2:");
		lblApellido_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblApellido_1.setBounds(35, 116, 91, 23);
		contentPanel.add(lblApellido_1);

		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("Arial", Font.BOLD, 15));
		lblId.setBounds(35, 147, 91, 23);
		contentPanel.add(lblId);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 15));
		lblDireccion.setBounds(35, 178, 91, 23);
		contentPanel.add(lblDireccion);

		txtApellido_1 = new JTextField();
		txtApellido_1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(147, 85, 175, 23);
		contentPanel.add(txtApellido_1);

		txtApellido_2 = new JTextField();
		txtApellido_2.setFont(new Font("Arial", Font.PLAIN, 15));
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(147, 116, 175, 23);
		contentPanel.add(txtApellido_2);

		txtID = new JTextField();
		txtID.setFont(new Font("Arial", Font.PLAIN, 15));
		txtID.setColumns(10);
		txtID.setBounds(147, 147, 175, 23);
		contentPanel.add(txtID);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(147, 178, 175, 23);
		contentPanel.add(txtDireccion);

		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Arial", Font.BOLD, 15));
		lblMunicipio.setBounds(35, 209, 91, 23);
		contentPanel.add(lblMunicipio);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setFont(new Font("Arial", Font.BOLD, 15));
		lblProvincia.setBounds(35, 240, 91, 23);
		contentPanel.add(lblProvincia);

		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(147, 209, 175, 23);
		contentPanel.add(txtMunicipio);

		txtProvincia = new JTextField();
		txtProvincia.setFont(new Font("Arial", Font.PLAIN, 15));
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(147, 240, 175, 23);
		contentPanel.add(txtProvincia);

		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos de su nueva cuenta");
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblIntroduzcaLosDatos.setBounds(35, 11, 287, 28);
		contentPanel.add(lblIntroduzcaLosDatos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 274, 340, 38);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {						
						PersonaNatural nuevoUsuario = new PersonaNatural(userName, password, txtNombre.getText(), txtApellido_1.getText(), txtApellido_2.getText(), txtID.getText(), txtDireccion.getText(), txtMunicipio.getText(), txtProvincia.getText());
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
