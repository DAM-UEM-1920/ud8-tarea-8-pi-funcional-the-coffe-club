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
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

import controller.Controlador;
import model.Modelo;

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

public class Opciones {

	private JFrame Opcio;
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
	private boolean lectura;
	private JButton btnGuardar;
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
		Opcio = new JFrame();
		Opcio.setTitle("Opciones de la Aplicacion");

		Opcio.setIconImage(Toolkit.getDefaultToolkit().getImage(Opciones.class.getResource("/Img/UEM-simbolo.jpg")));
		Opcio.setResizable(false);
		Opcio.getContentPane().setMinimumSize(new Dimension(75, 23));
		Opcio.getContentPane().setMaximumSize(new Dimension(75, 23));
		Opcio.getContentPane().setBackground(Color.ORANGE);
		Opcio.getContentPane().setLayout(null);

		lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Opciones.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		Opcio.getContentPane().add(lblLogoBoton);

		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setForeground(Color.WHITE);
		lblOpciones.setBackground(Color.WHITE);
		lblOpciones.setBounds(321, 11, 221, 84);
		Opcio.getContentPane().add(lblOpciones);
		SpringLayout springLayout = new SpringLayout();

		btnAtrs = new JButton("Volver");
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAtrs.setToolTipText("Te lleva a la pantalla anterior");
		btnAtrs.setBounds(44, 352, 140, 45);
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.OpcionesAtras();

			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBackground(Color.BLACK);
		Opcio.getContentPane().add(btnAtrs);

		chckbxSonidoTeclas = new JCheckBox("Sonido intros");
		chckbxSonidoTeclas.setEnabled(false);
		chckbxSonidoTeclas.setSelected(true);
		chckbxSonidoTeclas.setOpaque(false);
		chckbxSonidoTeclas.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas.setForeground(Color.WHITE);
		chckbxSonidoTeclas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas.setContentAreaFilled(false);
		chckbxSonidoTeclas.setBounds(258, 397, 124, 22);
		Opcio.getContentPane().add(chckbxSonidoTeclas);

		JCheckBox chckbxSonidoTeclas_1 = new JCheckBox("Sonido teclas");
		chckbxSonidoTeclas_1.setEnabled(false);
		chckbxSonidoTeclas_1.setSelected(true);
		chckbxSonidoTeclas_1.setOpaque(false);
		chckbxSonidoTeclas_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas_1.setForeground(Color.WHITE);
		chckbxSonidoTeclas_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas_1.setContentAreaFilled(false);
		chckbxSonidoTeclas_1.setBounds(375, 397, 124, 22);
		Opcio.getContentPane().add(chckbxSonidoTeclas_1);

		JCheckBox chckbxSonidoMandar = new JCheckBox("Sonido mandar");
		chckbxSonidoMandar.setEnabled(false);
		chckbxSonidoMandar.setSelected(true);
		chckbxSonidoMandar.setOpaque(false);
		chckbxSonidoMandar.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoMandar.setForeground(Color.WHITE);
		chckbxSonidoMandar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoMandar.setContentAreaFilled(false);
		chckbxSonidoMandar.setBounds(500, 397, 134, 22);
		Opcio.getContentPane().add(chckbxSonidoMandar);

		JCheckBox chckbxSonidoVolver = new JCheckBox("Sonido volver");
		chckbxSonidoVolver.setEnabled(false);
		chckbxSonidoVolver.setSelected(true);
		chckbxSonidoVolver.setOpaque(false);
		chckbxSonidoVolver.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoVolver.setForeground(Color.WHITE);
		chckbxSonidoVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoVolver.setContentAreaFilled(false);
		chckbxSonidoVolver.setBounds(625, 397, 109, 22);
		Opcio.getContentPane().add(chckbxSonidoVolver);

		textNombreUser = new JTextField();
		textNombreUser.setToolTipText("Introduza  su nombre de acceso a la aplicacion");
		textNombreUser.setOpaque(false);
		textNombreUser.setHorizontalAlignment(SwingConstants.CENTER);
		textNombreUser.setForeground(Color.WHITE);
		textNombreUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		textNombreUser.setColumns(10);
		textNombreUser.setCaretColor(Color.CYAN);
		textNombreUser.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Nombre de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		textNombreUser.setBounds(459, 116, 191, 47);
		Opcio.getContentPane().add(textNombreUser);

		txtPasswordUses = new JPasswordField();
		txtPasswordUses.setToolTipText("Introduza  su contrase\u00F1a de acceso a la aplicacion");
		txtPasswordUses.setOpaque(false);
		txtPasswordUses.setHorizontalAlignment(SwingConstants.CENTER);
		txtPasswordUses.setForeground(Color.WHITE);
		txtPasswordUses.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPasswordUses.setCaretColor(Color.CYAN);
		txtPasswordUses.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPasswordUses.setBounds(459, 185, 191, 48);
		Opcio.getContentPane().add(txtPasswordUses);

		textURLconexion = new JTextField();
		textURLconexion.setToolTipText("Introduzca la URL de conexion a la base de datos");
		textURLconexion.setOpaque(false);
		textURLconexion.setHorizontalAlignment(SwingConstants.CENTER);
		textURLconexion.setForeground(Color.WHITE);
		textURLconexion.setFont(new Font("Tahoma", Font.BOLD, 20));
		textURLconexion.setColumns(10);
		textURLconexion.setCaretColor(Color.CYAN);
		textURLconexion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Direcci\u00F3n de la Base de Datos", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		textURLconexion.setBounds(379, 257, 355, 47);
		Opcio.getContentPane().add(textURLconexion);

		btnSelecionar = new JButton("Seleccionar");
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
		btnSelecionar.setBounds(204, 106, 153, 47);
		Opcio.getContentPane().add(btnSelecionar);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(368, 290, 299, 14);
		Opcio.getContentPane().add(lblResultado);

		txtRutaFichero = new JTextField();
		txtRutaFichero.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtRutaFichero.setCaretColor(Color.WHITE);
		txtRutaFichero.setForeground(Color.WHITE);
		txtRutaFichero.setOpaque(false);
		txtRutaFichero.setHorizontalAlignment(SwingConstants.CENTER);
		txtRutaFichero.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nombre Fichero", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtRutaFichero.setToolTipText("Inserta la ruta del fichero");
		txtRutaFichero.setColumns(10);
		txtRutaFichero.setBounds(166, 177, 235, 45);
		Opcio.getContentPane().add(txtRutaFichero);

		btnGuardar = new JButton("Guardar");
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
		Opcio.getContentPane().add(btnGuardar);

		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, -24, 780, 482);
		lblfondo.setIcon(new ImageIcon(Opciones.class.getResource("/Img/Fondogrande.jpg")));
		Opcio.getContentPane().add(lblfondo);
		Opcio.setBackground(Color.ORANGE);
		Opcio.setBounds(550, 250, 786, 487);
		Opcio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnGuardar.setEnabled(false);
		
	}

	private void seleccionaFichero() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.ini", "ini");
		fc.setFileFilter(filtro);
		int seleccion = fc.showOpenDialog(Opcio);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			txtRutaFichero.setText(fichero.getName());
			metodoLectura();
//			metodo2();
		}
	}

	private void metodoLectura() {
		
		lblResultado.setText("");
		 texto = "";
		File fichero = new File(txtRutaFichero.getText());
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
				
				btnGuardar.setEnabled(true);

			} catch (IOException e) {
				lblResultado.setText("Error de Entrada/Salida");
			}
		} else
			lblResultado.setText("El fichero no existe");
	}
	private void metodoEscritura() {
		
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(Opcio);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				if (textNombreUser.getText()!=null) {
					texto=texto.replace(parts[0], textNombreUser.getText());
				}
				if (txtPasswordUses.getText()!=null) {
					texto=texto.replace(parts[1], txtPasswordUses.getText());
				}
				if (textURLconexion.getText()!=null) {
					texto=texto.replace(parts[2],textURLconexion.getText());
				}
				PrintWriter pw = new PrintWriter(fichero);
				pw.println(texto);
				//pw.println(txtPasswordUses.getText());
				pw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setVisible(boolean b) {
		Opcio.setVisible(b);

	}

	public boolean SoundActivo() {
		boolean Activo = true;
		if (chckbxSonidoTeclas.isSelected()) {
			Activo = true;
		} else {
			Activo = false;
		}
		return Activo;

	}
}
