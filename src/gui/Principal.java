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
import logic.PersonaNatural;
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
import datos.InfLlamadas;
import datos.SelectEliminarFijo;
import datos.SelectEliminarMovil;
import datos.SelectEliminarNauta;
import datos.TelefLlamar;

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
		mntmCerrarSecion.setIcon(new ImageIcon(Principal.class.getResource("/images/logout.png")));
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
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/salir.png")));
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
			mntmDatosUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/images/usuario-p.png")));
			mntmDatosUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sistema.getListaDeUsuarios().isEmpty())
						Utils.launchError("No hay ningún usuario registrado en el sistema");
					DatosDeUsuario datos = new DatosDeUsuario(sistema.getListaDeUsuarios());
					datos.setVisible(true);
				}
			});
			mntmDatosUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosUsuarios);

			JMenuItem mntmDatosTelefonos = new JMenuItem("Datos de Tel\u00E9fonos");
			mntmDatosTelefonos.setIcon(new ImageIcon(Principal.class.getResource("/images/tus-telefonos.png")));
			mntmDatosTelefonos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sistema.getListaTelefonos().isEmpty())
						Utils.launchError("No hay ningún teléfono registrado en el sistema");
					DatosDeTelefono datosTelefonos = new DatosDeTelefono(sistema, sistema.getListaTelefonos());
					datosTelefonos.setVisible(true);						
				}
			});
			mntmDatosTelefonos.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosTelefonos);

			JMenuItem mntmDatosLlamadas = new JMenuItem("Datos Llamadas");
			mntmDatosLlamadas.setIcon(new ImageIcon(Principal.class.getResource("/images/tus-llamadas.png")));
			mntmDatosLlamadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(sistema.getListaLlamadas().isEmpty())
						Utils.launchError("No hay ninguna llamada registrada en el sistema");
					DatosDeLlamada datosLlamadas = new DatosDeLlamada(sistema, sistema.getListaTelefonos());
					datosLlamadas.setVisible(true);
				}
			});
			mntmDatosLlamadas.setFont(new Font("Arial", Font.PLAIN, 12));
			mnSistema.add(mntmDatosLlamadas);
		}

		JMenuItem mntmDatosTelefonos = new JMenuItem("Tus Tel\u00E9fonos");
		mntmDatosTelefonos.setIcon(new ImageIcon(Principal.class.getResource("/images/tus-telefonos.png")));
		mntmDatosTelefonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getListaTelefonos().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono");
				DatosDeTelefono datosTelefono = new DatosDeTelefono(sistema, usuario.getListaTelefonos());
				datosTelefono.setVisible(true);
			}
		});
		mntmDatosTelefonos.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosTelefonos);

		JMenuItem mntmDatosLlamadas = new JMenuItem("Tus Llamadas");
		mntmDatosLlamadas.setIcon(new ImageIcon(Principal.class.getResource("/images/tus-llamadas.png")));
		mntmDatosLlamadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getListaTelefonos().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono");
				InfLlamadas seleccion = new InfLlamadas(sistema, usuario);
				seleccion.setVisible(true);
			}
		});
		mntmDatosLlamadas.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSistema.add(mntmDatosLlamadas);

		JMenu mnServicios = new JMenu("Servicios");
		mnServicios.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnServicios);

		if(!(usuario instanceof PersonaJuridica)){
			
			JMenu mnCuentaNauta = new JMenu("Cuenta Nauta");
			mnCuentaNauta.setIcon(new ImageIcon(Principal.class.getResource("/images/cuenta-nauta.png")));
			mnCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
			mnServicios.add(mnCuentaNauta);
	
			JMenuItem mntmCrearCuentaNauta = new JMenuItem("Crear Cuenta Nauta");
			mntmCrearCuentaNauta.setIcon(new ImageIcon(Principal.class.getResource("/images/cuenta-nueva.png")));
			mntmCrearCuentaNauta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(usuario instanceof PersonaNatural && usuario.getCuentasNauta().size() > 0)
						Utils.launchError("Las personas naturales solo pueden tener 1 cuenta nauta");
					CrearCuentaNauta nuevaCuentaNauta = new CrearCuentaNauta(sistema, usuario);
					nuevaCuentaNauta.setVisible(true);
				}
			});
			mntmCrearCuentaNauta.setFont(new Font("Arial", Font.PLAIN, 12));
			mnCuentaNauta.add(mntmCrearCuentaNauta);
	
			JMenuItem mntmEstadoDeCuenta = new JMenuItem("Estado de Cuenta");
			mntmEstadoDeCuenta.setIcon(new ImageIcon(Principal.class.getResource("/images/info.png")));
			mntmEstadoDeCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(usuario.getCuentasNauta().isEmpty())
						Utils.launchError("Usted no cuenta con una cuenta nauta");
					NavegacionNauta navNauta = new NavegacionNauta(usuario.getCuentasNauta().get(0));
					navNauta.setVisible(true);
				}
			});
			mntmEstadoDeCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
			mnCuentaNauta.add(mntmEstadoDeCuenta);
			
			JMenuItem mntmEliminarNauta = new JMenuItem("Eliminar Cuenta");
			mntmEliminarNauta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(usuario.getCuentasNauta().isEmpty())
						Utils.launchError("Usted no cuenta con ninguna cuenta nauta");
					else if(usuario.getCuentasNauta().size() == 1) {
						ConfirmarBorrarNauta confirmar = new ConfirmarBorrarNauta(usuario, usuario.getCuentasNauta().get(0));
						confirmar.setVisible(true);
					} else {
						SelectEliminarNauta select = new SelectEliminarNauta(usuario);
						select.setVisible(true);
					}
				}
			});
			mntmEliminarNauta.setIcon(new ImageIcon(Principal.class.getResource("/images/borrar-cuenta.png")));
			mntmEliminarNauta.setFont(new Font("Arial", Font.PLAIN, 12));
			mnCuentaNauta.add(mntmEliminarNauta);
		
		}

		JMenuItem mntmTelefoniaFija = new JMenu("Telefon\u00EDa Fija");
		mntmTelefoniaFija.setIcon(new ImageIcon(Principal.class.getResource("/images/fijo.png")));
		mntmTelefoniaFija.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaFija);

		JMenuItem mntmRegistrarNuevoTelefono = new JMenuItem("Registrar Nuevo Tel\u00E9fono");
		mntmRegistrarNuevoTelefono.setIcon(new ImageIcon(Principal.class.getResource("/images/cuenta-nueva.png")));
		mntmRegistrarNuevoTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario instanceof PersonaNatural && !usuario.getTelefonosFijos().isEmpty())
					Utils.launchError("Las personas naturales solo pueden tener 1 teléfono fijo");
				RegistrarTelefonoFijo nuevoTelefono = new RegistrarTelefonoFijo(sistema, usuario);
				nuevoTelefono.setVisible(true);
			}
		});
		mntmRegistrarNuevoTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmRegistrarNuevoTelefono);

		JMenuItem mntmVerFacturas = new JMenuItem("Ver Facturas");
		mntmVerFacturas.setIcon(new ImageIcon(Principal.class.getResource("/images/info.png")));
		mntmVerFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getTelefonosFijos().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono fijo");
				FacturaTelFijo FacturaFijo = new FacturaTelFijo(usuario);
				FacturaFijo.setVisible(true);
			}
		});
		mntmVerFacturas.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmVerFacturas);
		
		JMenuItem mntmEliminarFijo = new JMenuItem("Eliminar Fijo");
		mntmEliminarFijo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getTelefonosFijos().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono fijo");
				else if(usuario.getTelefonosFijos().size() == 1) {
					ConfirmarBorrarTelefono confirmar = new ConfirmarBorrarTelefono(usuario, usuario.getTelefonosFijos().get(0));
					confirmar.setVisible(true);
				} else {
					SelectEliminarFijo seleccionarTelefono = new SelectEliminarFijo(sistema, usuario);
					seleccionarTelefono.setVisible(true);
				}
			}
		});
		mntmEliminarFijo.setIcon(new ImageIcon(Principal.class.getResource("/images/borrar-cuenta.png")));
		mntmEliminarFijo.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaFija.add(mntmEliminarFijo);

		JMenuItem mntmTelefoniaMovil = new JMenu("Telefon\u00EDa M\u00F3vil");
		mntmTelefoniaMovil.setIcon(new ImageIcon(Principal.class.getResource("/images/movil.png")));
		mntmTelefoniaMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmTelefoniaMovil);

		JMenuItem mntmLlamador = new JMenuItem("Llamador");
		mntmLlamador.setIcon(new ImageIcon(Principal.class.getResource("/images/llamador-p.png")));
		mntmLlamador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(usuario.getListaTelefonos().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono");
				else if(usuario.getListaTelefonos().size() == 1) {
					LLamador llamador = new LLamador(sistema, usuario, usuario.getListaTelefonos().get(0));
					llamador.setVisible(true);
				} else {
					TelefLlamar seleccionarTelefono = new TelefLlamar(sistema, usuario);
					seleccionarTelefono.setVisible(true);
				}
			}
		});
		mntmLlamador.setFont(new Font("Arial", Font.PLAIN, 12));
		mnServicios.add(mntmLlamador);

		JMenuItem mntmRegistrarNuevoMovil = new JMenuItem("Registrar Nuevo M\u00F3vil");
		mntmRegistrarNuevoMovil.setIcon(new ImageIcon(Principal.class.getResource("/images/cuenta-nueva.png")));
		mntmRegistrarNuevoMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario instanceof PersonaNatural && usuario.getTelefonosMoviles().size() > 1)
					Utils.launchError("Las personas naturales solo pueden tener 2 teléfonos móviles");
				RegistrarTelefonoMovil nuevoTelefono = new RegistrarTelefonoMovil(sistema, usuario);
				nuevoTelefono.setVisible(true);
			}
		});
		mntmRegistrarNuevoMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaMovil.add(mntmRegistrarNuevoMovil);
		
		JMenuItem mntmEliminarMovil = new JMenuItem("Eliminar Móvil");
		mntmEliminarMovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.getTelefonosMoviles().isEmpty())
					Utils.launchError("Usted no cuenta con ningún teléfono móvil");
				else if(usuario.getTelefonosMoviles().size() == 1) {
					ConfirmarBorrarTelefono confirmar = new ConfirmarBorrarTelefono(usuario, usuario.getTelefonosMoviles().get(0));
					confirmar.setVisible(true);
				} else {
					SelectEliminarMovil seleccionarTelefono = new SelectEliminarMovil(sistema, usuario);
					seleccionarTelefono.setVisible(true);
				}
			}
		});
		mntmEliminarMovil.setIcon(new ImageIcon(Principal.class.getResource("/images/borrar-cuenta.png")));
		mntmEliminarMovil.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmTelefoniaMovil.add(mntmEliminarMovil);

		JMenu mnOpciones = new JMenu("Opciones");
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnOpciones);

		JMenuItem mntmBorrarCuenta = new JMenuItem("Borrar Cuenta");
		mntmBorrarCuenta.setIcon(new ImageIcon(Principal.class.getResource("/images/borrar-cuenta.png")));
		mntmBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarBorrarUsuario borrarUsuario = new ConfirmarBorrarUsuario(sistema, usuario);
				borrarUsuario.setVisible(true);
				dispose();
			}
		});
		mntmBorrarCuenta.setFont(new Font("Arial", Font.PLAIN, 12));
		mnOpciones.add(mntmBorrarCuenta);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setIcon(new ImageIcon(Principal.class.getResource("/images/acerca-de-p.png")));
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
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTipoDeCuenta = new JLabel("Bienvenido: " + usuario.getNombre());
		lblTipoDeCuenta.setForeground(Color.WHITE);
		lblTipoDeCuenta.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 35));
		lblTipoDeCuenta.setBounds(10, 0, 440, 49);
		contentPane.add(lblTipoDeCuenta);
	}
}