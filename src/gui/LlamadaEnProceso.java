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

import java.awt.Color;

@SuppressWarnings("serial")
public class LlamadaEnProceso extends JFrame {

	private JPanel contentPane;
	private double duracion = 1;
	private final Timer timer;

	public LlamadaEnProceso(final Sistema sistema, final Usuario usuario, final Telefono telefono, final String numeroLlamado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LlamadaEnProceso.class.getResource("/images/llamada-en-proceso.png")));
		setTitle(sistema.getUsuarioPorNumero(numeroLlamado).getNombre());
		setBounds(100, 100, 260, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setResizable(false);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumero.setBounds(41, 22, 80, 25);
		contentPane.add(lblNumero);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setForeground(Color.BLACK);
		lblProvincia.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvincia.setBounds(41, 58, 80, 25);
		contentPane.add(lblProvincia);

		JLabel lblDuracion = new JLabel("Duraci\u00F3n:");
		lblDuracion.setForeground(Color.BLACK);
		lblDuracion.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracion.setBounds(41, 94, 80, 25);
		contentPane.add(lblDuracion);

		JLabel lblCargada = new JLabel("Cargada:");
		lblCargada.setForeground(Color.BLACK);
		lblCargada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCargada.setBounds(41, 130, 80, 25);
		contentPane.add(lblCargada);

		JLabel lblNumeroLLamado = new JLabel();
		lblNumeroLLamado.setForeground(Color.BLACK);
		lblNumeroLLamado.setText(numeroLlamado);
		lblNumeroLLamado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNumeroLLamado.setBounds(131, 22, 80, 25);
		contentPane.add(lblNumeroLLamado);

		JLabel lblProvinciaLlamada = new JLabel();
		lblProvinciaLlamada.setForeground(Color.BLACK);
		lblProvinciaLlamada.setText(sistema.getUsuarioPorNumero(numeroLlamado).getProvincia());
		lblProvinciaLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblProvinciaLlamada.setBounds(131, 58, 80, 25);
		contentPane.add(lblProvinciaLlamada);

		final JLabel lblDuracionLlamada = new JLabel("0");
		lblDuracionLlamada.setForeground(Color.BLACK);
		lblDuracionLlamada.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDuracionLlamada.setBounds(131, 94, 80, 25);
		contentPane.add(lblDuracionLlamada);

		String cargada = "true";
		if(telefono instanceof TelefonoFijo &&  // Si el teléfono llamando es un fijo y el llamado un móvil
				sistema.getTelefono(numeroLlamado) instanceof TelefonoMovil)
			cargada = "false";   // Se le carga la llamada al teléfono móvil
		final JLabel lblUsuarioCargado = new JLabel(cargada);
		lblUsuarioCargado.setForeground(Color.BLACK);
		lblUsuarioCargado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblUsuarioCargado.setBounds(131, 130, 80, 25);
		contentPane.add(lblUsuarioCargado);

		timer = new Timer(1000, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String strTiempo = String.valueOf(duracion);
				Telefono telefonoLlamado = sistema.getTelefono(numeroLlamado);
				if(telefono instanceof TelefonoMovil){
					((TelefonoMovil) telefono).setSaldo(((TelefonoMovil) telefono).getSaldo() - 1);
					if(((TelefonoMovil) telefono).getSaldo() == 0){
						MostrarSaldo mostrarSaldo = new MostrarSaldo(0);
						mostrarSaldo.setVisible(true);
						dispose();
						timer.stop();
					}
				} else if(telefonoLlamado instanceof TelefonoMovil){
					((TelefonoMovil) telefonoLlamado).setSaldo(((TelefonoMovil) telefonoLlamado).getSaldo() - 1);
					if(((TelefonoMovil) telefonoLlamado).getSaldo() == 0){
						ErrorWindow errorWindow = new ErrorWindow("El telefono llamado se quedó sin saldo");
						errorWindow.setVisible(true);
						dispose();
						timer.stop();
					}
				}
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

				telefono.addLlamada(sistema, usuario, numeroLlamado, duracion);
				
				if( telefono instanceof TelefonoMovil && ((TelefonoMovil) telefono).getSaldo() < 0)
					((TelefonoMovil) telefono).setSaldo(0);

				dispose();
			}
		});
		btnOk.setBounds(82, 175, 89, 30);
		contentPane.add(btnOk);
	}

}