package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Sistema;
import logic.Usuario;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import datos.DatosDeTelefono;
import datos.DatosDeUsuario;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	JPanel contentPane;
	@SuppressWarnings("unused")
	private Usuario usuario;

	public Principal(final Usuario user, final Sistema sistem) {
		usuario = user;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Sistema ETECSA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnArchivo);

		JMenuItem mntmCerrarSecion = new JMenuItem("Cerrar Cesi\u00F3n");
		mntmCerrarSecion.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmCerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login logIn = new Login(sistem);
				logIn.setVisible(true);
				dispose();
			}
		});
		mnArchivo.add(mntmCerrarSecion);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnSistema);
		
		JMenuItem mntmDatosUsuarios = new JMenuItem("Datos de Usuarios");
		mntmDatosUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosDeUsuario datos = new DatosDeUsuario(sistem);
				datos.setVisible(true);
			}
		});
		mntmDatosUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosUsuarios);
		
		JMenuItem mntmDatosTelefonos = new JMenuItem("Datos de Tel\u00E9fonos");
		mntmDatosTelefonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosDeTelefono datos = new DatosDeTelefono(sistem);
				datos.setVisible(true);
			}
		});
		mntmDatosTelefonos.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosTelefonos);
		
		JMenuItem mntmDatosLlamadas = new JMenuItem("Datos Llamadas");
		mntmDatosLlamadas.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosLlamadas);

		JMenu mnServicios = new JMenu("Servicios");
		mnServicios.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnServicios);

		JMenu mnCuentaNauta = new JMenu("Cuenta Nauta");
		mnCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mnCuentaNauta);

		JMenuItem mntmCrearCuentaNauta = new JMenuItem("Crear Cuenta Nauta");
		mntmCrearCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCuentaNauta.add(mntmCrearCuentaNauta);

		JMenuItem mntmEstadoDeCuenta = new JMenuItem("Estado de Cuenta");
		mntmEstadoDeCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCuentaNauta.add(mntmEstadoDeCuenta);

		JMenuItem mntmTelefoniaFija = new JMenu("Telefon\u00EDa Fija");
		mntmTelefoniaFija.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaFija);

		JMenuItem mntmLlamador1 = new JMenuItem("Llamador");
		mntmLlamador1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.getTelefonosFijos().size() == 0)
					throw new IllegalArgumentException("Usted no cuenta con un teléfono fijo");
				
				LLamador llamador = new LLamador(sistem, user, user.getTelefonosFijos().get(0));
				llamador.setVisible(true);
				llamador.setAlwaysOnTop(true);
			}
		});

		JMenuItem mntmFacturaTelefonica = new JMenuItem("Factura Telefonica");
		mntmFacturaTelefonica.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmFacturaTelefonica);
		mntmLlamador1.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmLlamador1);

		JMenuItem mntmRegistrarNuevoTelefono = new JMenuItem("Registrar Nuevo Tel\u00E9fono");
		mntmRegistrarNuevoTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarTelefonoFijo nuevoTelefono = new RegistrarTelefonoFijo(sistem, user);
				nuevoTelefono.setVisible(true);
				nuevoTelefono.setAlwaysOnTop(true);
			}
		});
		mntmRegistrarNuevoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmRegistrarNuevoTelefono);

		JMenuItem mntmTelefoniaMovil = new JMenu("Telefon\u00EDa M\u00F3vil");
		mntmTelefoniaMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaMovil);

		JMenuItem mntmLlamador = new JMenuItem("Llamador");
		mntmLlamador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.getTelefonosMoviles().size() == 0)
					throw new IllegalArgumentException("Usted no cuenta con un teléfono fijo");
				
				LLamador llamador = new LLamador(sistem, user, user.getTelefonosMoviles().get(0));
				llamador.setVisible(true);
				llamador.setAlwaysOnTop(true);
			}
		});
		mntmLlamador.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaMovil.add(mntmLlamador);

		JMenuItem mntmRegistrarNuevoMovil = new JMenuItem("Registrar Nuevo M\u00F3vil");
		mntmRegistrarNuevoMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarTelefonoMovil nuevoTelefono = new RegistrarTelefonoMovil(sistem, user);
				nuevoTelefono.setVisible(true);
				nuevoTelefono.setAlwaysOnTop(true);
			}
		});
		mntmRegistrarNuevoMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaMovil.add(mntmRegistrarNuevoMovil);

		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnOpciones);

		JMenuItem mntmCrearCuenta = new JMenuItem("Crear Cuenta");
		mntmCrearCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmCrearCuenta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				CrearCuenta cuentaNueva = new CrearCuenta(sistem);
				cuentaNueva.setVisible(true);
				cuentaNueva.setAlwaysOnTop(true);
			}
		});
		mnOpciones.add(mntmCrearCuenta);

		JMenuItem mntmBorrarCuenta = new JMenuItem("Borrar Cuenta");
		mntmBorrarCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmBorrarCuenta);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcercaDe info = new AcercaDe();
				info.setVisible(true);
				info.setAlwaysOnTop(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);

		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/oficina-etecsa.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTipoDeCuenta = new JLabel("Bienvenido " + user.getUserName());
		lblTipoDeCuenta.setForeground(Color.WHITE);
		lblTipoDeCuenta.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 35));
		lblTipoDeCuenta.setBounds(10, 0, 440, 49);
		contentPane.add(lblTipoDeCuenta);
	}
}
