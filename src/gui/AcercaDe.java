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

@SuppressWarnings("serial")
public class AcercaDe extends JFrame {

	private JPanel contentPane;

	public AcercaDe() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Acerca de");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 260);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel lblHechoPor = new JLabel("Hecho por:");
		lblHechoPor.setFont(new Font("Arial", Font.PLAIN, 13));
		lblHechoPor.setBounds(37, 21, 97, 23);
		contentPane.add(lblHechoPor);

		JLabel lblAlejandroGarciaRodriguez = new JLabel("Alejandro Garcia Rodriguez #14");
		lblAlejandroGarciaRodriguez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAlejandroGarciaRodriguez.setBounds(204, 21, 250, 23);
		contentPane.add(lblAlejandroGarciaRodriguez);

		JLabel lblJulioSergioLpez = new JLabel("Julio Sergio L\u00F3pez Quiros #19");
		lblJulioSergioLpez.setFont(new Font("Arial", Font.PLAIN, 13));
		lblJulioSergioLpez.setBounds(204, 51, 250, 23);
		contentPane.add(lblJulioSergioLpez);

		JLabel lblTutorDelProyecto = new JLabel("Tutor del Proyecto:");
		lblTutorDelProyecto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTutorDelProyecto.setBounds(37, 111, 143, 23);
		contentPane.add(lblTutorDelProyecto);

		JLabel lblCarlos = new JLabel("Carlos");
		lblCarlos.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCarlos.setBounds(204, 111, 46, 23);
		contentPane.add(lblCarlos);

		JLabel lblNombreDelProyecto = new JLabel("Nombre del Proyecto: ");
		lblNombreDelProyecto.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNombreDelProyecto.setBounds(37, 141, 157, 23);
		contentPane.add(lblNombreDelProyecto);

		JLabel lblSistemaAutomatizadoDe = new JLabel("Sistema Automatizado de ETECSA");
		lblSistemaAutomatizadoDe.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSistemaAutomatizadoDe.setBounds(204, 141, 250, 23);
		contentPane.add(lblSistemaAutomatizadoDe);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCerrar.setBounds(181, 187, 89, 23);
		contentPane.add(btnCerrar);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblGrupo.setBounds(37, 81, 67, 23);
		contentPane.add(lblGrupo);

		JLabel lblG = new JLabel("G12");
		lblG.setFont(new Font("Arial", Font.PLAIN, 13));
		lblG.setBounds(204, 81, 46, 23);
		contentPane.add(lblG);
	}
}
