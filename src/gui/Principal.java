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

import logic.PersonaJuridica;
import logic.Sistema;
import logic.Usuario;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

import auxiliar.Utils;
import datos.DatosDeLlamada;
import datos.DatosDeTelefono;
import datos.DatosDeUsuario;
import datos.FacturaTelFijo;
import datos.NavegacionNauta;
import datos.SelectTelefInfLlamadas;
import datos.SelectTelefLlamar;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal(final Usuario usuario, final Sistema sistema) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema ETECSA");
		setBounds(100, 100, 1200, 700);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 12));
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnArchivo);

		JMenuItem mntmCerrarSecion = new JMenuItem("Cerrar Cesi\u00F3n");
		mntmCerrarSecion.setIcon(new ImageIcon(Principal.class.getResource("/images/cierre-de-sesión-16.png")));
		mntmCerrarSecion.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmCerrarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login logIn = new Login(sistema);
				logIn.setVisible(true);
				dispose();
			}
		});
		mnArchivo.add(mntmCerrarSecion);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/eliminar-16.png")));
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

		if(usuario.isAdministrador()){
			JMenuItem mntmDatosUsuarios = new JMenuItem("Datos de Usuarios");
			mntmDatosUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/images/usuario-16.png")));
			mntmDatosUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DatosDeUsuario datos = new DatosDeUsuario(sistema.getListaDeUsuarios());
					datos.setVisible(true);
				}
			});
			mntmDatosUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosUsuarios);

			JMenuItem mntmDatosTelefonos = new JMenuItem("Datos de Tel\u00E9fonos");
			mntmDatosTelefonos.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonos-16.png")));
			mntmDatosTelefonos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sistema.getListaTelefonos().size() > 0){
						DatosDeTelefono datosTelefonos = new DatosDeTelefono(sistema, sistema.getListaTelefonos());
						datosTelefonos.setVisible(true);						
					} else {
						Utils.launchError("No hay ningún teléfono registrado en el sistema");
					}
				}
			});
			mntmDatosTelefonos.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosTelefonos);

			JMenuItem mntmDatosLlamadas = new JMenuItem("Datos Llamadas");
			mntmDatosLlamadas.setIcon(new ImageIcon(Principal.class.getResource("/images/llamadas-16.png")));
			mntmDatosLlamadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sistema.getListaLlamadas().size() > 0){
						DatosDeLlamada datosLlamadas = new DatosDeLlamada(sistema, sistema.getListaTelefonos());
						datosLlamadas.setVisible(true);
					} else {
						Utils.launchError("No hay ninguna llamada registrada en el sistema");
					}
				}
			});
			mntmDatosLlamadas.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosLlamadas);
		}

		JMenuItem mntmDatosTelefonos = new JMenuItem("Tus Tel\u00E9fonos");
		mntmDatosTelefonos.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonos-16.png")));
		mntmDatosTelefonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getListaTelefonos().size() == 0){
					Utils.launchError("Usted no cuenta con ningún teléfono");
				}
				DatosDeTelefono datosTelefono = new DatosDeTelefono(sistema, usuario.getListaTelefonos());
				datosTelefono.setVisible(true);
			}
		});
		mntmDatosTelefonos.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosTelefonos);

		JMenuItem mntmDatosLlamadas = new JMenuItem("Tus Llamadas");
		mntmDatosLlamadas.setIcon(new ImageIcon(Principal.class.getResource("/images/llamadas-16.png")));
		mntmDatosLlamadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getListaTelefonos().size() == 0)
					Utils.launchError("Usted no cuenta con ningún teléfono");
				SelectTelefInfLlamadas seleccion = new SelectTelefInfLlamadas(sistema, usuario);
				seleccion.setVisible(true);
			}
		});
		mntmDatosLlamadas.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosLlamadas);

		JMenu mnServicios = new JMenu("Servicios");
		mnServicios.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnServicios);

		JMenu mnCuentaNauta = new JMenu("Cuenta Nauta");
		mnCuentaNauta.setIcon(new ImageIcon(Principal.class.getResource("/images/cuenta-nauta.png")));
		mnCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mnCuentaNauta);

		JMenuItem mntmCrearCuentaNauta = new JMenuItem("Crear Cuenta Nauta");
		mntmCrearCuentaNauta.setIcon(new ImageIcon(Principal.class.getResource("/images/crear-cuenta-nauta.png")));
		mntmCrearCuentaNauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuentaNauta nuevaCuentaNauta = new CrearCuentaNauta(sistema, usuario);
				nuevaCuentaNauta.setVisible(true);
			}
		});
		mntmCrearCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCuentaNauta.add(mntmCrearCuentaNauta);

		JMenuItem mntmEstadoDeCuenta = new JMenuItem("Estado de Cuenta");
		mntmEstadoDeCuenta.setIcon(new ImageIcon(Principal.class.getResource("/images/estado-de-cuenta.png")));
		mntmEstadoDeCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario instanceof PersonaJuridica)
					Utils.launchError("Las Personas Jurídicas no pueden tener cuenta nauta");
				else if(usuario.getCuentasNauta().isEmpty()){
					Utils.launchError("Usted no cuenta con ninguna cuenta nauta");
				} else {
					NavegacionNauta navegacionNauta = new NavegacionNauta(usuario.getCuentasNauta().get(usuario.getCuentasNauta().size()-1));
					navegacionNauta.setVisible(true);
				}
			}
		});
		mntmEstadoDeCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnCuentaNauta.add(mntmEstadoDeCuenta);

		JMenuItem mntmTelefoniaFija = new JMenu("Telefon\u00EDa Fija");
		mntmTelefoniaFija.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonia-fija.png")));
		mntmTelefoniaFija.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaFija);

		JMenuItem mntmRegistrarNuevoTelefono = new JMenuItem("Registrar Nuevo Tel\u00E9fono");
		mntmRegistrarNuevoTelefono.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonia-fija.png")));
		mntmRegistrarNuevoTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarTelefonoFijo nuevoTelefono = new RegistrarTelefonoFijo(sistema, usuario);
				nuevoTelefono.setVisible(true);
			}
		});
		mntmRegistrarNuevoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmRegistrarNuevoTelefono);

		JMenuItem mntmVerFacturas = new JMenuItem("Ver Facturas");
		mntmVerFacturas.setIcon(new ImageIcon(Principal.class.getResource("/images/estado-de-cuenta.png")));
		mntmVerFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getTelefonosFijos().size() == 0)
					Utils.launchError("Usted no cuenta con ningún teléfono fijo");
				else if(usuario.getTelefonosFijos().size() == 1) {
					FacturaTelFijo FacturaFijo = new FacturaTelFijo(usuario.getTelefonosFijos().get(0));
					FacturaFijo.setVisible(true);
				} else {

				}
			}
		});
		mntmVerFacturas.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmVerFacturas);

		JMenuItem mntmTelefoniaMovil = new JMenu("Telefon\u00EDa M\u00F3vil");
		mntmTelefoniaMovil.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonia-movil.png")));
		mntmTelefoniaMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaMovil);

		JMenuItem mntmLlamador = new JMenuItem("Llamador");
		mntmLlamador.setIcon(new ImageIcon(Principal.class.getResource("/images/numerico-16.png")));
		mntmLlamador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(usuario.getListaTelefonos().size() == 0)
					Utils.launchError("Usted no cuenta con ningún teléfono");
				else if(usuario.getListaTelefonos().size() == 1) {
					LLamador llamador = new LLamador(sistema, usuario, usuario.getTelefonosMoviles().get(0));
					llamador.setVisible(true);
				} else {
					SelectTelefLlamar seleccionarTelefono = new SelectTelefLlamar(sistema, usuario);
					seleccionarTelefono.setVisible(true);
				}
			}
		});
		mntmLlamador.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmLlamador);

		JMenuItem mntmRegistrarNuevoMovil = new JMenuItem("Registrar Nuevo M\u00F3vil");
		mntmRegistrarNuevoMovil.setIcon(new ImageIcon(Principal.class.getResource("/images/telefonia-movil.png")));
		mntmRegistrarNuevoMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarTelefonoMovil nuevoTelefono = new RegistrarTelefonoMovil(sistema, usuario);
				nuevoTelefono.setVisible(true);
			}
		});
		mntmRegistrarNuevoMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaMovil.add(mntmRegistrarNuevoMovil);

		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnOpciones);

		JMenuItem mntmBorrarCuenta = new JMenuItem("Borrar Cuenta");
		mntmBorrarCuenta.setIcon(new ImageIcon(Principal.class.getResource("/images/delete-16.png")));
		mntmBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.removeUsuario(usuario);
				Login logIn = new Login(sistema);
				logIn.setVisible(true);
				dispose();
			}
		});
		mntmBorrarCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmBorrarCuenta);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/images/informacion-16.png")));
		mntmAcercaDe.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcercaDe info = new AcercaDe();
				info.setVisible(true);
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

		JLabel lblTipoDeCuenta = new JLabel("Bienvenido: " + usuario.getNombre());
		lblTipoDeCuenta.setForeground(Color.WHITE);
		lblTipoDeCuenta.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 35));
		lblTipoDeCuenta.setBounds(10, 0, 440, 49);
		contentPane.add(lblTipoDeCuenta);
	}
}
