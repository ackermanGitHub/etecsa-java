package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AcercaDe extends JFrame {

	private JPanel contentPane;

	public AcercaDe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/información-32.png")));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Acerca de");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		JLabel lblHechoPor = new JLabel("Hecho por:");
		lblHechoPor.setForeground(Color.BLACK);
		lblHechoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHechoPor.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHechoPor.setBounds(29, 21, 75, 23);
		contentPane.add(lblHechoPor);

		JLabel lblAlejandroGarciaRodriguez = new JLabel("Alejandro Garcia Rodriguez #14");
		lblAlejandroGarciaRodriguez.setForeground(Color.BLACK);
		lblAlejandroGarciaRodriguez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAlejandroGarciaRodriguez.setBounds(114, 21, 194, 23);
		contentPane.add(lblAlejandroGarciaRodriguez);

		JLabel lblJulioSergioLpez = new JLabel("Julio Sergio L\u00F3pez Quiros #19");
		lblJulioSergioLpez.setForeground(Color.BLACK);
		lblJulioSergioLpez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblJulioSergioLpez.setBounds(114, 47, 194, 23);
		contentPane.add(lblJulioSergioLpez);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(338, 235, 75, 25);
		contentPane.add(btnCerrar);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setForeground(Color.BLACK);
		lblGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGrupo.setBounds(321, 21, 49, 23);
		contentPane.add(lblGrupo);

		JLabel lblGrupo12 = new JLabel("G12");
		lblGrupo12.setForeground(Color.BLACK);
		lblGrupo12.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGrupo12.setBounds(380, 21, 33, 23);
		contentPane.add(lblGrupo12);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(29, 81, 386, 146);
		contentPane.add(scrollPane);
		
		JTextPane txtpnEnNuestroProyecto = new JTextPane();
		txtpnEnNuestroProyecto.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(txtpnEnNuestroProyecto);
		txtpnEnNuestroProyecto.setText("En nuestro proyecto de curso elaboramos un sistema informatizado para el control de sus clientes, con el objetivo de mejorar la calidad de sus servicios y la atenci\u00F3n al cliente. Los servicios que se ofrecen son telefon\u00EDa fija, telefon\u00EDa m\u00F3vil y cuentas Nauta para correo electr\u00F3nico y navegaci\u00F3n en Internet. Los clientes se dividen en personas naturales, personas jur\u00EDdicas y entidades no estatales, y se registran sus datos en el sistema seg\u00FAn su tipo. Las personas naturales pueden tener un tel\u00E9fono fijo, dos tel\u00E9fonos m\u00F3viles y una cuenta Nauta, mientras que las personas jur\u00EDdicas pueden tener m\u00FAltiples tel\u00E9fonos fijos y m\u00F3viles, pero no cuentas Nauta. Las entidades no estatales pueden tener m\u00FAltiples tel\u00E9fonos fijos, m\u00F3viles y cuentas Nauta. El sistema registra las llamadas realizadas a trav\u00E9s de un interfaz llamador, y se guardan los datos de la llamada seg\u00FAn el tipo de origen (fijo o m\u00F3vil). De cada tel\u00E9fono fijo se registra su n\u00FAmero y el titular, y se genera una factura mensual que incluye tarifas fijas, llamadas locales y larga distancia, entre otros conceptos.");
	}
}
