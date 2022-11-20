package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Font;

import logic.Sistema;
import logic.Telefono;
import logic.Usuario;

@SuppressWarnings("serial")
public class LLamador extends JFrame {

	private JPanel contentPane;
	private JTextField txtTelefono;

	public LLamador(final Sistema sistema, final Usuario usuario, final Telefono telefono) {
		setTitle("Llamador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Arial", Font.BOLD, 14));
		txtTelefono.setBounds(40, 25, 113, 40);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "1");
			}
		});
		button_1.setBounds(40, 100, 50, 40);
		contentPane.add(button_1);

		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "2");
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 12));
		button_2.setBounds(104, 100, 50, 40);
		contentPane.add(button_2);

		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Arial", Font.PLAIN, 12));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "3");
			}
		});
		button_3.setBounds(170, 100, 50, 40);
		contentPane.add(button_3);

		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Arial", Font.PLAIN, 12));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "4");
			}
		});
		button_4.setBounds(40, 156, 50, 40);
		contentPane.add(button_4);

		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Arial", Font.PLAIN, 12));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "5");
			}
		});
		button_5.setBounds(104, 156, 50, 40);
		contentPane.add(button_5);

		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Arial", Font.PLAIN, 12));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "6");
			}
		});
		button_6.setBounds(170, 156, 50, 40);
		contentPane.add(button_6);

		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Arial", Font.PLAIN, 12));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "7");
			}
		});
		button_7.setBounds(40, 212, 50, 40);
		contentPane.add(button_7);

		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Arial", Font.PLAIN, 12));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "8");
			}
		});
		button_8.setBounds(104, 212, 50, 40);
		contentPane.add(button_8);

		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Arial", Font.PLAIN, 12));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "9");
			}
		});
		button_9.setBounds(170, 212, 50, 40);
		contentPane.add(button_9);

		JButton button_por = new JButton("*");
		button_por.setFont(new Font("Arial", Font.PLAIN, 12));
		button_por.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "*");
			}
		});
		button_por.setBounds(40, 268, 50, 40);
		contentPane.add(button_por);

		JButton button_0 = new JButton("0");
		button_0.setFont(new Font("Arial", Font.PLAIN, 12));
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "0");
			}
		});
		button_0.setBounds(104, 268, 50, 40);
		contentPane.add(button_0);

		JButton button_hash = new JButton("#");
		button_hash.setFont(new Font("Arial", Font.PLAIN, 12));
		button_hash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTelefono.setText(txtTelefono.getText() + "#");
			}
		});
		button_hash.setBounds(170, 268, 50, 40);
		contentPane.add(button_hash);

		JButton btnLlamar = new JButton("LLamar");
		btnLlamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numero = txtTelefono.getText();

				Telefono telefonoLlamado = sistema.getTelefono(numero);
				if(telefonoLlamado == null)
					throw new IllegalArgumentException("El telefono llamado no se encuentra registrado en el sistema");

				LlamadaEnProceso llamadaEnProceso = new LlamadaEnProceso(sistema, usuario, telefono, numero);
				llamadaEnProceso.setVisible(true);
				llamadaEnProceso.setAlwaysOnTop(true);
				txtTelefono.setText("");
			}
		});
		btnLlamar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLlamar.setBounds(40, 328, 85, 30);
		contentPane.add(btnLlamar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(129, 328, 91, 30);
		contentPane.add(btnCancelar);

		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTelefono.getText().isEmpty())
					txtTelefono.setText(txtTelefono.getText().substring(0, txtTelefono.getText().length() - 1));
			}
		});
		btnDel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDel.setBounds(163, 25, 57, 40);
		contentPane.add(btnDel);
	}

}
