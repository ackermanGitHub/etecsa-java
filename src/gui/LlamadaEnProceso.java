package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

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
	public LlamadaEnProceso(final Sistema sistem, final Usuario usuario, final Telefono telefono, final String numero) {
		setTitle("Llamada en Proceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero.setBounds(46, 55, 80, 25);
		contentPane.add(lblNumero);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(46, 91, 80, 25);
		contentPane.add(lblProvincia);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracion.setBounds(46, 127, 80, 25);
		contentPane.add(lblDuracion);

		JLabel lblCargada = new JLabel("Cargada:");
		lblCargada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCargada.setBounds(46, 163, 80, 25);
		contentPane.add(lblCargada);

		JLabel lblNumeroLLamado = new JLabel();
		lblNumeroLLamado.setText(numero);
		lblNumeroLLamado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroLLamado.setBounds(154, 55, 80, 25);
		contentPane.add(lblNumeroLLamado);

		JLabel lblProvinciaLlamada = new JLabel();
		lblProvinciaLlamada.setText(sistem.getTelefono(numero).getUsuario().getProvincia());
		lblProvinciaLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvinciaLlamada.setBounds(154, 91, 80, 25);
		contentPane.add(lblProvinciaLlamada);

		final JLabel lblDuracionLlamada = new JLabel("0");
		lblDuracionLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracionLlamada.setBounds(154, 127, 80, 25);
		contentPane.add(lblDuracionLlamada);

		JLabel lblUsuarioCargado = new JLabel();
		if(telefono instanceof TelefonoMovil){
			lblUsuarioCargado.setText("true");
		} else if(telefono instanceof TelefonoFijo){
			if(sistem.getTelefono(numero) instanceof TelefonoMovil){
				lblUsuarioCargado.setText("false");
			} else if(sistem.getTelefono(numero) instanceof TelefonoFijo){
				lblUsuarioCargado.setText("true");
			}
		}
		lblUsuarioCargado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsuarioCargado.setBounds(154, 163, 80, 25);
		contentPane.add(lblUsuarioCargado);

		final Timer timer = new Timer(1000, new ActionListener(){
			int tiempo = 1;
			public void actionPerformed(ActionEvent e) {
				String strTiempo = String.valueOf(tiempo);
				lblDuracionLlamada.setText(strTiempo);
				tiempo++;
			}
		});

		timer.start();

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				dispose();
			}
		});
		btnOk.setBounds(145, 227, 89, 23);
		contentPane.add(btnOk);
	}
}
