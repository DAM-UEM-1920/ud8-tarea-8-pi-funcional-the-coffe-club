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

public class Opciones {

	private JFrame Frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JCheckBox chckbxSonidoTeclas;
	private JTextField textNombreUser;
	private JPasswordField txtPasswordUses;
	private JTextField textURLconexion;
	private JButton btnSelecionar;
	private JLabel lblResultado;
	private JTextField txtRutaFichero;
	private JButton btnAtrs;
	private JLabel lblLogoBoton;
	private String texto;
	private String[] parts;
	private JButton btnGuardar;
	private File fichero;
	private boolean check;

	/**
	 * Create the application.
	 */
	public Opciones() {
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

		Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Opciones.class.getResource("/Img/UEM-simbolo.jpg")));
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
		lblLogoBoton.setIcon(new ImageIcon(Opciones.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		Frame.getContentPane().add(lblLogoBoton);

		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setForeground(Color.WHITE);
		lblOpciones.setBackground(Color.WHITE);
		lblOpciones.setBounds(321, 11, 221, 84);
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
				miControlador.OpcionesAtras();

			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBackground(Color.BLACK);
		Frame.getContentPane().add(btnAtrs);

		chckbxSonidoTeclas = new JCheckBox("Sonido intros");
		chckbxSonidoTeclas.setEnabled(false);
		chckbxSonidoTeclas.setSelected(true);
		chckbxSonidoTeclas.setOpaque(false);
		chckbxSonidoTeclas.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas.setForeground(Color.WHITE);
		chckbxSonidoTeclas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas.setContentAreaFilled(false);
		chckbxSonidoTeclas.setBounds(258, 421, 124, 22);
		Frame.getContentPane().add(chckbxSonidoTeclas);

		JCheckBox chckbxSonidoTeclas_1 = new JCheckBox("Sonido teclas");
		chckbxSonidoTeclas_1.setEnabled(false);
		chckbxSonidoTeclas_1.setSelected(true);
		chckbxSonidoTeclas_1.setOpaque(false);
		chckbxSonidoTeclas_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas_1.setForeground(Color.WHITE);
		chckbxSonidoTeclas_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas_1.setContentAreaFilled(false);
		chckbxSonidoTeclas_1.setBounds(375, 421, 124, 22);
		Frame.getContentPane().add(chckbxSonidoTeclas_1);

		JCheckBox chckbxSonidoMandar = new JCheckBox("Sonido mandar");
		chckbxSonidoMandar.setEnabled(false);
		chckbxSonidoMandar.setSelected(true);
		chckbxSonidoMandar.setOpaque(false);
		chckbxSonidoMandar.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoMandar.setForeground(Color.WHITE);
		chckbxSonidoMandar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoMandar.setContentAreaFilled(false);
		chckbxSonidoMandar.setBounds(500, 421, 134, 22);
		Frame.getContentPane().add(chckbxSonidoMandar);

		JCheckBox chckbxSonidoVolver = new JCheckBox("Sonido volver");
		chckbxSonidoVolver.setEnabled(false);
		chckbxSonidoVolver.setSelected(true);
		chckbxSonidoVolver.setOpaque(false);
		chckbxSonidoVolver.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoVolver.setForeground(Color.WHITE);
		chckbxSonidoVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoVolver.setContentAreaFilled(false);
		chckbxSonidoVolver.setBounds(625, 421, 109, 22);
		Frame.getContentPane().add(chckbxSonidoVolver);

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
		textNombreUser.setBounds(459, 116, 191, 47);
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
		txtPasswordUses.setBounds(459, 185, 191, 48);
		Frame.getContentPane().add(txtPasswordUses);

		textURLconexion = new JTextField();
		textURLconexion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					miControlador.SoundSend();
					metodoEscritura();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		textURLconexion.setToolTipText("Introduzca la URL de conexion a la base de datos");
		textURLconexion.setOpaque(false);
		textURLconexion.setHorizontalAlignment(SwingConstants.CENTER);
		textURLconexion.setForeground(Color.WHITE);
		textURLconexion.setFont(new Font("Tahoma", Font.BOLD, 14));
		textURLconexion.setColumns(10);
		textURLconexion.setCaretColor(Color.CYAN);
		textURLconexion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Direcci\u00F3n de la Base de Datos", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		textURLconexion.setBounds(415, 259, 276, 47);
		Frame.getContentPane().add(textURLconexion);

		btnSelecionar = new JButton("Seleccionar");
		btnSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnSelecionar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					miControlador.SoundAcceso();
					seleccionaFichero();
				}

			}
		});
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaFichero();
			}

		});
		btnSelecionar.setToolTipText("Selecciona un archivo");
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSelecionar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnSelecionar.setBackground(Color.BLACK);
		btnSelecionar.setBounds(208, 159, 153, 47);
		Frame.getContentPane().add(btnSelecionar);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.GREEN);
		lblResultado.setBounds(403, 383, 299, 14);
		Frame.getContentPane().add(lblResultado);

		txtRutaFichero = new JTextField();
		txtRutaFichero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		txtRutaFichero.setEditable(false);
		txtRutaFichero.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtRutaFichero.setCaretColor(Color.WHITE);
		txtRutaFichero.setForeground(Color.WHITE);
		txtRutaFichero.setOpaque(false);
		txtRutaFichero.setHorizontalAlignment(SwingConstants.CENTER);
		txtRutaFichero.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nombre Fichero", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtRutaFichero.setToolTipText("Inserta la ruta del fichero");
		txtRutaFichero.setColumns(10);
		txtRutaFichero.setBounds(188, 219, 191, 45);
		Frame.getContentPane().add(txtRutaFichero);

		btnGuardar = new JButton("Guardar");
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
					metodoEscritura();
				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					miControlador.SoundLogAtras();
					miControlador.OpcionesAtras();
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				metodoEscritura();
			}
		});
		btnGuardar.setToolTipText("Guarda los datos introducidos");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(480, 319, 153, 47);
		Frame.getContentPane().add(btnGuardar);

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
		lblfondo.setIcon(new ImageIcon(Opciones.class.getResource("/Img/Fondogrande.jpg")));
		Frame.getContentPane().add(lblfondo);
		Frame.setBackground(Color.ORANGE);
		Frame.setBounds(550, 250, 786, 487);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnGuardar.setEnabled(true);

	}

	private void seleccionaFichero() {
		miControlador.SoundAcceso();
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.ini", "ini");
		fc.setFileFilter(filtro);
		int seleccion = fc.showOpenDialog(Frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			txtRutaFichero.setText(fichero.getName());
			metodoLectura();

		}
	}

	private void metodoLectura() {

		lblResultado.setText("");
		texto = "";
		fichero = new File(txtRutaFichero.getText());
		if (fichero.exists()) {
			textNombreUser.setText("");
			try {
				Scanner sc = new Scanner(fichero);

				texto = sc.nextLine();
				parts = texto.split("-");
				textNombreUser.setText(parts[0]);
				txtPasswordUses.setText(parts[1]);
				textURLconexion.setText(parts[2]);

				sc.close();

				check = true;
			} catch (IOException e) {
				lblResultado.setText("Error de Entrada/Salida");
			}
		} else {
			lblResultado.setText("El fichero no existe");
			lblResultado.setForeground(Color.RED);
			miControlador.SoundError();
		}

	}

	private void metodoEscritura() {
		//Exception e = new Exception("Este es mi propio error.");
		int cont=0;
		if (check == true) {

			try {
				if (textNombreUser.getText().length()!=0) {
					texto = texto.replace(parts[0], textNombreUser.getText());
				} else {

					cont++;
				}
				if (txtPasswordUses.getText().length()!=0&&cont<1) {
					texto = texto.replace(parts[1], txtPasswordUses.getText());
				} else {

					cont++;
				}
				if (textURLconexion.getText().length()!=0&&cont<1) {
					texto = texto.replace(parts[2], textURLconexion.getText());
				} else {
					cont++;
				}
				
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(texto);
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			if (cont<1) {
				lblResultado.setForeground(Color.GREEN);
				lblResultado.setText("Se ha guardado correctamente");
				miControlador.SoundAcceso();
			}else {
				lblResultado.setForeground(Color.YELLOW);
				lblResultado.setText("No puedes dejar espacios en blanco");
			}
			

		} else {
			lblResultado.setForeground(Color.YELLOW);
			lblResultado.setText("Seleccione Fichero");
			miControlador.SoundLogAtras();

		}

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
