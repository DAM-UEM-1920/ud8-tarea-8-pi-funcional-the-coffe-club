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

public class Registro {

	private JFrame Frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField textNombreUser;
	private JPasswordField txtPasswordUses;
	private JTextField textURLconexion;
	private JLabel lblResultado;
	private JButton btnAtrs;
	private JLabel lblLogoBoton;
	private String texto;
	private String[] parts;
	private JButton btnGuardar;
	private File fichero;
	private boolean check;
	private JPasswordField txtPasswordConfirmar;
	private JTextField textField;

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
					miControlador.OpcionesAtras();
				
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
					miControlador.OpcionesAtras();
				}
				miControlador.OpcionesAtras();
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
		btnAtrs.setBounds(33, 376, 140, 45);
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

					miControlador.SoundSend();
					txtPasswordUses.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
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

		txtPasswordUses = new JPasswordField();

		txtPasswordUses.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					miControlador.SoundSend();
					textURLconexion.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}

			}
		});
		txtPasswordUses.setToolTipText("Introduza  su contrase\u00F1a de acceso a la aplicacion");
		txtPasswordUses.setOpaque(false);
		txtPasswordUses.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordUses.setForeground(Color.WHITE);
		txtPasswordUses.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtPasswordUses.setCaretColor(Color.CYAN);
		txtPasswordUses.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPasswordUses.setBounds(258, 190, 191, 48);
		Frame.getContentPane().add(txtPasswordUses);

		textURLconexion = new JTextField();
		textURLconexion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					miControlador.SoundSend();
					
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		textURLconexion.setToolTipText("Introduzca la direccion del correo electronico");
		textURLconexion.setOpaque(false);
		textURLconexion.setHorizontalAlignment(SwingConstants.CENTER);
		textURLconexion.setForeground(Color.WHITE);
		textURLconexion.setFont(new Font("Tahoma", Font.BOLD, 14));
		textURLconexion.setColumns(10);
		textURLconexion.setCaretColor(Color.CYAN);
		textURLconexion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Direcci\u00F3n de Correo Electronico", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textURLconexion.setBounds(333, 283, 276, 47);
		Frame.getContentPane().add(textURLconexion);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.GREEN);
		lblResultado.setBounds(403, 383, 299, 14);
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
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
		txtPasswordConfirmar.setToolTipText("Confirma la contrase\u00F1a de acceso a la aplicacion");
		txtPasswordConfirmar.setOpaque(false);
		txtPasswordConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordConfirmar.setForeground(Color.WHITE);
		txtPasswordConfirmar.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtPasswordConfirmar.setCaretColor(Color.CYAN);
		txtPasswordConfirmar.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Confirmar Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPasswordConfirmar.setBounds(507, 190, 191, 48);
		Frame.getContentPane().add(txtPasswordConfirmar);
				
				textField = new JTextField();
				textField.setToolTipText("Introduza  el DNI del usuario que se va registrar");
				textField.setOpaque(false);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				textField.setForeground(Color.WHITE);
				textField.setFont(new Font("Tahoma", Font.BOLD, 17));
				textField.setColumns(10);
				textField.setCaretColor(Color.CYAN);
				textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DNI del Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
				textField.setBounds(258, 119, 191, 47);
				Frame.getContentPane().add(textField);
				
						JLabel lblfondo = new JLabel("");
						lblfondo.addKeyListener(new KeyAdapter() {
							@Override
							public void keyReleased(KeyEvent e) {
								if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
									miControlador.SoundLogAtras();
									miControlador.OpcionesAtras();
								}
							}
						});
						lblfondo.setBounds(0, -24, 780, 482);
						lblfondo.setIcon(new ImageIcon(Registro.class.getResource("/Img/Fondogrande.jpg")));
						Frame.getContentPane().add(lblfondo);

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
