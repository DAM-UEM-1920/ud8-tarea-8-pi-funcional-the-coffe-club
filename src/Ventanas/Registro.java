package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

import controller.Controlador;
import model.Modelo;
import sun.java2d.pipe.TextPipe;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;

public class Registro {

	private JFrame Frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField textNombreUser;
	private JPasswordField txtPasswordUser;
	private JTextField textEmail;
	private JLabel lblResultado;
	private JButton btnAtrs;
	private JLabel lblLogoBoton;
	private String texto;
	private String[] parts;
	private JButton btnGuardar;
	private File fichero;
	private boolean check;
	private JPasswordField txtPasswordConfirmar;
	private JTextField textFieldDNI;
	private JLabel lblResultado_DNI;
	private JLabel lblResultado_Nombre;
	private JLabel lblResultado_pass;
	private JLabel lblResultado_ConfirmarPass;
	private JLabel lblResultado_Email;
	private JLabel lblResultado_Procesado;
	private JLabel lblResultado_Combo;
	private JLabel lblfondo;
	private JComboBox comboBoxRol;
	private String usr, passwd, rppasswd, email, DNI, rol; 

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Frame = new JFrame();
		Frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		Frame.setTitle("Opciones de la Aplicacion");

		Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/Img/UEM-simbolo.jpg")));
		Frame.setResizable(false);
		Frame.getContentPane().setMinimumSize(new Dimension(75, 23));
		Frame.getContentPane().setMaximumSize(new Dimension(75, 23));
		Frame.getContentPane().setBackground(Color.ORANGE);
		Frame.getContentPane().setLayout(null);

		lblLogoBoton = new JLabel("");
		lblLogoBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				miControlador.SoundLogAtras();
				miControlador.RegistroAtras();

			}
		});
		lblLogoBoton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		lblLogoBoton.setIcon(new ImageIcon(Registro.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		Frame.getContentPane().add(lblLogoBoton);

		JLabel lblOpciones = new JLabel("Registro Nuevo Usuario");
		lblOpciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setForeground(Color.WHITE);
		lblOpciones.setBackground(Color.WHITE);
		lblOpciones.setBounds(193, 23, 543, 84);
		Frame.getContentPane().add(lblOpciones);
		SpringLayout springLayout = new SpringLayout();

		btnAtrs = new JButton("Volver");
		btnAtrs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.RegistroAtras();
				}
				miControlador.RegistroAtras();
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				miControlador.SoundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnAtrs.setToolTipText("Te lleva a la pantalla anterior");
		btnAtrs.setBounds(32, 400, 110, 39);
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.RegistroAtras();

			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBackground(Color.BLACK);
		Frame.getContentPane().add(btnAtrs);

		textNombreUser = new JTextField();
		textNombreUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (textNombreUser.getText().length() == 0) {
						lblResultado_Nombre.setForeground(Color.YELLOW);
						miControlador.SoundLogAtras();
						lblResultado_Nombre.setText("Introduce un Nombre de usuario");

					} else {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							lblResultado_Nombre.setText("OK");
							lblResultado_Nombre.setForeground(Color.GREEN);
							miControlador.SoundSend();
							txtPasswordUser.requestFocus();
						}

					}
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					textFieldDNI.requestFocus();
				}
			}
		});
		textNombreUser.setToolTipText("Introduza  su nombre de acceso a la aplicacion");
		textNombreUser.setOpaque(false);
		textNombreUser.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreUser.setForeground(Color.WHITE);
		textNombreUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		textNombreUser.setColumns(10);
		textNombreUser.setCaretColor(Color.CYAN);
		textNombreUser.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Nombre de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		textNombreUser.setBounds(507, 118, 191, 49);
		Frame.getContentPane().add(textNombreUser);

		txtPasswordUser = new JPasswordField();

		txtPasswordUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (txtPasswordUser.getText().length() == 0) {
						lblResultado_pass.setForeground(Color.YELLOW);
						miControlador.SoundLogAtras();
						lblResultado_pass.setText("Introduce una contraseña valida");

					} else {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							lblResultado_pass.setText("OK");
							lblResultado_pass.setForeground(Color.GREEN);
							miControlador.SoundSend();
							txtPasswordConfirmar.requestFocus();
						}

					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					textNombreUser.requestFocus();
				}
			}
		});
		txtPasswordUser.setToolTipText("Introduza  su contrase\u00F1a de acceso a la aplicacion");
		txtPasswordUser.setOpaque(false);
		txtPasswordUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordUser.setForeground(Color.WHITE);
		txtPasswordUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtPasswordUser.setCaretColor(Color.CYAN);
		txtPasswordUser.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPasswordUser.setBounds(258, 190, 191, 48);
		Frame.getContentPane().add(txtPasswordUser);

		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (textEmail.getText().length() == 0) {
						lblResultado_Email.setForeground(Color.YELLOW);
						miControlador.SoundLogAtras();
						lblResultado_Email.setText("Introduce un Email valido");

					} else {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							lblResultado_Email.setText("OK");
							lblResultado_Email.setForeground(Color.GREEN);
							miControlador.SoundSend();
							btnGuardar.requestFocus();
						}

					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					txtPasswordConfirmar.requestFocus();
				}
			}
		});
		textEmail.setToolTipText("Introduzca la direccion del correo electronico");
		textEmail.setOpaque(false);
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setForeground(Color.WHITE);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEmail.setColumns(10);
		textEmail.setCaretColor(Color.CYAN);
		textEmail.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Direcci\u00F3n de Correo Electronico", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		textEmail.setBounds(333, 283, 276, 47);
		Frame.getContentPane().add(textEmail);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.GREEN);
		lblResultado.setBounds(333, 407, 276, 14);
		Frame.getContentPane().add(lblResultado);

		btnGuardar = new JButton("Registrar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();

			}
		});
		btnGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (comboBoxRol.getSelectedItem().toString().equals("ADMIN")
						|| (comboBoxRol.getSelectedItem().toString().equals("TUTOR"))) {
						
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {

						miControlador.SoundAcceso();
						lblResultado_Procesado.setForeground(Color.GREEN);
						lblResultado_Procesado.setText("Procesado");
						lblResultado_Combo.setText(null);
						lblResultado_DNI.setText(null);
						lblResultado_Nombre.setText(null);
						lblResultado_pass.setText(null);
						lblResultado_ConfirmarPass.setText(null);
						lblResultado_Email.setText(null);

						

					}
				} else {
					comboBoxRol.requestFocus();
					lblResultado_Combo.setForeground(Color.YELLOW);
				lblResultado_Combo.setText("Seleccione un Rol");
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					textEmail.requestFocus();
				}

			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.metodoLectura();
				miModelo.conexion();
				miControlador.login();
				añadir();
			}
		});
		btnGuardar.setToolTipText("Guarda los datos introducidos");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(389, 355, 153, 47);
		Frame.getContentPane().add(btnGuardar);
		Frame.setBackground(Color.ORANGE);
		Frame.setBounds(550, 250, 786, 487);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnGuardar.setEnabled(true);

		txtPasswordConfirmar = new JPasswordField();
		txtPasswordConfirmar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					if (txtPasswordUser.getText().equals(txtPasswordConfirmar.getText())) {

						if (txtPasswordConfirmar.getText().length() == 0) {
							lblResultado_ConfirmarPass.setForeground(Color.YELLOW);
							miControlador.SoundLogAtras();
							lblResultado_ConfirmarPass.setText("Introduce una contraseña valida");

						} else {
							if (e.getKeyCode() == KeyEvent.VK_ENTER) {
								lblResultado_ConfirmarPass.setText("OK");
								lblResultado_ConfirmarPass.setForeground(Color.GREEN);
								miControlador.SoundSend();
								textEmail.requestFocus();
							}

						}
					} else {
						lblResultado_ConfirmarPass.setForeground(Color.RED);
						miControlador.SoundLogAtras();
						lblResultado_ConfirmarPass.setText("La contraseñas no coinciden");
					}

				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					txtPasswordUser.requestFocus();
				}
			}
		});
		txtPasswordConfirmar.setToolTipText("Confirma la contrase\u00F1a de acceso a la aplicacion");
		txtPasswordConfirmar.setOpaque(false);
		txtPasswordConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordConfirmar.setForeground(Color.WHITE);
		txtPasswordConfirmar.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtPasswordConfirmar.setCaretColor(Color.CYAN);
		txtPasswordConfirmar.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Confirmar Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPasswordConfirmar.setBounds(507, 190, 191, 48);
		Frame.getContentPane().add(txtPasswordConfirmar);

		textFieldDNI = new JTextField();
		textFieldDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (textFieldDNI.getText().length() == 0) {
						lblResultado_DNI.setForeground(Color.YELLOW);
						miControlador.SoundLogAtras();
						lblResultado_DNI.setText("Introduce un DNI valido");

					} else {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							lblResultado_DNI.setText("OK");
							lblResultado_DNI.setForeground(Color.GREEN);
							miControlador.SoundSend();
							textNombreUser.requestFocus();
						}

					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.RegistroAtras();
				}
			}
		});
		textFieldDNI.setToolTipText("Introduza  el DNI del usuario que se va registrar");
		textFieldDNI.setOpaque(false);
		textFieldDNI.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDNI.setForeground(Color.WHITE);
		textFieldDNI.setFont(new Font("Tahoma", Font.BOLD, 17));
		textFieldDNI.setColumns(10);
		textFieldDNI.setCaretColor(Color.CYAN);
		textFieldDNI.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"DNI del Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldDNI.setBounds(258, 119, 191, 47);
		Frame.getContentPane().add(textFieldDNI);

		comboBoxRol = new JComboBox();
		comboBoxRol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnGuardar.requestFocus();
					miControlador.SoundSend();

				} else {

					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						miControlador.SoundLogAtras();
						miControlador.RegistroAtras();
					}
				}

			}
		});
		comboBoxRol.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxRol.setForeground(Color.BLACK);
		comboBoxRol.setBackground(Color.WHITE);
		comboBoxRol.setLightWeightPopupEnabled(false);
		comboBoxRol.setToolTipText("Categoria a la que pertenece");
		comboBoxRol.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBoxRol.setName("");
		comboBoxRol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxRol.setOpaque(false);
		comboBoxRol.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Elige Rol",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] { "--------", "ADMIN", "TUTOR" }));
		comboBoxRol.setBounds(64, 232, 153, 45);
		Frame.getContentPane().add(comboBoxRol);

		lblResultado_DNI = new JLabel("");
		lblResultado_DNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_DNI.setForeground(Color.WHITE);
		lblResultado_DNI.setBounds(258, 166, 191, 14);
		Frame.getContentPane().add(lblResultado_DNI);

		lblResultado_Nombre = new JLabel("");
		lblResultado_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_Nombre.setForeground(Color.GREEN);
		lblResultado_Nombre.setBounds(507, 166, 191, 14);
		Frame.getContentPane().add(lblResultado_Nombre);

		lblResultado_pass = new JLabel("");
		lblResultado_pass.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_pass.setForeground(Color.GREEN);
		lblResultado_pass.setBounds(258, 239, 191, 14);
		Frame.getContentPane().add(lblResultado_pass);

		lblResultado_ConfirmarPass = new JLabel("");
		lblResultado_ConfirmarPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_ConfirmarPass.setForeground(Color.GREEN);
		lblResultado_ConfirmarPass.setBounds(507, 239, 191, 14);
		Frame.getContentPane().add(lblResultado_ConfirmarPass);

		lblResultado_Email = new JLabel("");
		lblResultado_Email.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_Email.setForeground(Color.GREEN);
		lblResultado_Email.setBounds(343, 330, 262, 14);
		Frame.getContentPane().add(lblResultado_Email);

		lblResultado_Procesado = new JLabel("");
		lblResultado_Procesado.setToolTipText("");
		lblResultado_Procesado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_Procesado.setForeground(Color.GREEN);
		lblResultado_Procesado.setBounds(389, 407, 153, 14);
		Frame.getContentPane().add(lblResultado_Procesado);

		lblResultado_Combo = new JLabel("");
		lblResultado_Combo.setToolTipText("");
		lblResultado_Combo.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado_Combo.setForeground(Color.GREEN);
		lblResultado_Combo.setBounds(64, 283, 153, 14);
		Frame.getContentPane().add(lblResultado_Combo);

		lblfondo = new JLabel("");
		lblfondo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.RegistroAtras();
				}
			}
		});
		lblfondo.setBounds(0, -24, 780, 482);
		lblfondo.setIcon(new ImageIcon(Registro.class.getResource("/Img/Fondogrande.jpg")));
		Frame.getContentPane().add(lblfondo);

	}
 public void añadir() {
		 
		 usr=textNombreUser.getText();
		 passwd=txtPasswordUser.getText();
		 rppasswd=txtPasswordConfirmar.getText();
		 email=textEmail.getText();
		 DNI=textFieldDNI.getText();
		 System.out.println(comboBoxRol.getSelectedItem().toString());
		 miModelo.insert("users", "'"+usr+"' ,'"+passwd+"' ,'"+comboBoxRol.getSelectedItem().toString()+"'");
		
	 }

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setVisible(boolean b) {
		Frame.setVisible(b);

	}
}
