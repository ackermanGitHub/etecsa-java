package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AcercaDe extends JFrame {

	private JPanel contentPane;

	public AcercaDe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Acerca de");
		setBounds(100, 100, 456, 260);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		JLabel lblHechoPor = new JLabel("Hecho por:");
		lblHechoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHechoPor.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHechoPor.setBounds(37, 21, 143, 23);
		contentPane.add(lblHechoPor);

		JLabel lblAlejandroGarciaRodriguez = new JLabel("Alejandro Garcia Rodriguez #14");
		lblAlejandroGarciaRodriguez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAlejandroGarciaRodriguez.setBounds(204, 21, 226, 23);
		contentPane.add(lblAlejandroGarciaRodriguez);

		JLabel lblJulioSergioLpez = new JLabel("Julio Sergio L\u00F3pez Quiros #19");
		lblJulioSergioLpez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblJulioSergioLpez.setBounds(204, 51, 226, 23);
		contentPane.add(lblJulioSergioLpez);

		JLabel lblTutorDelProyecto = new JLabel("Tutor del Proyecto:");
		lblTutorDelProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTutorDelProyecto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTutorDelProyecto.setBounds(37, 111, 143, 23);
		contentPane.add(lblTutorDelProyecto);

		JLabel lblCarlos = new JLabel("Carlos");
		lblCarlos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCarlos.setBounds(204, 111, 46, 23);
		contentPane.add(lblCarlos);

		JLabel lblNombreDelProyecto = new JLabel("Nombre del Proyecto:");
		lblNombreDelProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDelProyecto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombreDelProyecto.setBounds(37, 141, 143, 23);
		contentPane.add(lblNombreDelProyecto);

		JLabel lblSistemaAutomatizadoDe = new JLabel("Sistema Automatizado de ETECSA");
		lblSistemaAutomatizadoDe.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSistemaAutomatizadoDe.setBounds(204, 141, 226, 23);
		contentPane.add(lblSistemaAutomatizadoDe);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(179, 187, 81, 23);
		contentPane.add(btnCerrar);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGrupo.setBounds(37, 81, 143, 23);
		contentPane.add(lblGrupo);

		JLabel lblGrupo12 = new JLabel("G12");
		lblGrupo12.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGrupo12.setBounds(204, 81, 46, 23);
		contentPane.add(lblGrupo12);
	}

}
