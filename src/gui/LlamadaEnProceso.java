package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Sistema;
import logic.Telefono;
import logic.TelefonoFijo;
import logic.TelefonoMovil;
import logic.Usuario;

@SuppressWarnings("serial")
public class LlamadaEnProceso extends JFrame {

	private JPanel contentPane;
	private double duracion = 1;

	public LlamadaEnProceso(final Sistema sistema, final Usuario usuario, final Telefono telefono, final String numeroLlamado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setTitle(sistema.getUsuarioPorNumero(numeroLlamado).getNombre());
		setBounds(100, 100, 290, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setResizable(false);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero.setBounds(45, 31, 80, 25);
		contentPane.add(lblNumero);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(45, 67, 80, 25);
		contentPane.add(lblProvincia);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracion.setBounds(45, 103, 80, 25);
		contentPane.add(lblDuracion);

		JLabel lblCargada = new JLabel("Cargada:");
		lblCargada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCargada.setBounds(45, 139, 80, 25);
		contentPane.add(lblCargada);

		JLabel lblNumeroLLamado = new JLabel();
		lblNumeroLLamado.setText(numeroLlamado);
		lblNumeroLLamado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroLLamado.setBounds(135, 31, 100, 25);
		contentPane.add(lblNumeroLLamado);

		JLabel lblProvinciaLlamada = new JLabel();
		lblProvinciaLlamada.setText(sistema.getUsuarioPorNumero(numeroLlamado).getProvincia());
		lblProvinciaLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvinciaLlamada.setBounds(135, 67, 100, 25);
		contentPane.add(lblProvinciaLlamada);

		final JLabel lblDuracionLlamada = new JLabel("0");
		lblDuracionLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracionLlamada.setBounds(135, 103, 100, 25);
		contentPane.add(lblDuracionLlamada);

		String cargada = "true";
		if(telefono instanceof TelefonoFijo &&  // Si el tel�fono llamando es un fijo y el llamado un m�vil
				sistema.getTelefono(numeroLlamado) instanceof TelefonoMovil)
			cargada = "false";   // Se le carga la llamada al tel�fono m�vil
		final JLabel lblUsuarioCargado = new JLabel(cargada);
		lblUsuarioCargado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsuarioCargado.setBounds(135, 139, 100, 25);
		contentPane.add(lblUsuarioCargado);

		final Timer timer = new Timer(1000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String strTiempo = String.valueOf(duracion);
				lblDuracionLlamada.setText(strTiempo);
				duracion++;
			}
		});
		timer.start();

		JButton btnOk = new JButton("Colgar");
		btnOk.setFont(new Font("Arial", Font.PLAIN, 12));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();

				if(lblUsuarioCargado.getText().equals("true")) 
					telefono.addLlamada(sistema, usuario, numeroLlamado, duracion, true);
				else 
					telefono.addLlamada(sistema, usuario, numeroLlamado, duracion, false);

				dispose();
			}
		});
		btnOk.setBounds(98, 175, 89, 30);
		contentPane.add(btnOk);
	}

}