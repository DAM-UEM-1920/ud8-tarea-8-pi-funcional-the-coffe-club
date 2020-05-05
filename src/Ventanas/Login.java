package Ventanas;

import javax.swing.JFrame;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controller.Controlador;
import model.Modelo;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.*;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private Controlador miControlador;
	private Modelo miModelo;
	private JPasswordField passwordField;
	private JLabel lblrespuesta;
	private JLabel lblusrimg_1;
	private JCheckBox checkbox;

	/**
	 * Create the application.
	 * 
	 * @param launcher
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setResizable(false);
		frame.setTitle("Iniciar sesi\u00F3n");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setMaximumSize(new Dimension(701, 394));
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.RED);
		frame.getContentPane().setLayout(null);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Login.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(29, 29, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		lblusrimg_1 = new JLabel("");
		lblusrimg_1.setIcon(new ImageIcon(Login.class.getResource("/Img/LlaveLogin.png")));
		lblusrimg_1.setBounds(132, 239, 54, 56);
		frame.getContentPane().add(lblusrimg_1);

		lblrespuesta = new JLabel("");
		lblrespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblrespuesta.setForeground(Color.RED);
		lblrespuesta.setBounds(164, 306, 257, 14);
		frame.getContentPane().add(lblrespuesta);

		passwordField = new JPasswordField();
		passwordField.setCaretColor(Color.CYAN);
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);

		passwordField.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));

		passwordField.setToolTipText("Introduzca su contrase\u00F1a");

		passwordField.setBounds(199, 247, 191, 48);
		frame.getContentPane().add(passwordField);

		txtUsuario = new JTextField();
		txtUsuario.setCaretColor(Color.CYAN);
		txtUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setOpaque(false);
		txtUsuario.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nombre de Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtUsuario.setBounds(201, 167, 189, 47);
		txtUsuario.setToolTipText("Introduza su numero de DNI y la letra en mayusculas");
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseMotionListener(new MouseMotionAdapter() {

		});
		btnLogin.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				if (checkbox.isSelected()==true) {
					miControlador.setSonidos(true);

					miControlador.SoundSobreBoton();

				}else {
					miControlador.setSonidos(false);
				}
			}

		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, new Color(192, 192, 192), null, null));
		btnLogin.setBounds(427, 211, 146, 47);
		btnLogin.setToolTipText("Pulse para acceder");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miControlador.login();
			}
		});

		frame.getContentPane().add(btnLogin);

		JLabel lblTitulo = new JLabel("Iniciar Sesion");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(230, 69, 231, 41);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblTitulo);

		JLabel lblusrimg = new JLabel("");
		lblusrimg.setBounds(131, 149, 64, 78);
		lblusrimg.setIcon(new ImageIcon(Login.class.getResource("/Img/LoginUser60.png")));
		frame.getContentPane().add(lblusrimg);

		checkbox = new JCheckBox("Sonido");
		checkbox.addMouseListener(new MouseAdapter() {
		});
		checkbox.setSelected(true);
		checkbox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkbox.setForeground(Color.WHITE);
		checkbox.setContentAreaFilled(false);
		checkbox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkbox.setOpaque(false);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setBounds(534, 354, 76, 22);
		frame.getContentPane().add(checkbox);
/////////////////////////////////////////////////////////////////////////////////////////////////////
		// Boton de Opciones (Proximamente)
//		JButton lblOpciones = new JButton("");
//		lblOpciones.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				miControlador.Opciones();
//			}
//		});
//		lblOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		lblOpciones.setContentAreaFilled(false);
//		lblOpciones.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		lblOpciones.setBorderPainted(false);
//		lblOpciones.setOpaque(false);
//		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
//		lblOpciones.setIcon(new ImageIcon(Login.class.getResource("/Img/rueda.png")));
//		lblOpciones.setBounds(555, 306, 49, 48);
//		frame.getContentPane().add(lblOpciones);
////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(Login.class.getResource("/Img/Fondogrande.jpg")));
		lblbackground.setBounds(0, 0, 626, 392);
		frame.getContentPane().add(lblbackground);
		frame.setBounds(550, 250, 632, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getUsr() {
		return txtUsuario.getText();
	}

	public String getPwd() {
		return String.valueOf(passwordField.getPassword());
	}

	public void actualaizar() {
		String resultado = miModelo.getResultado();
		String user = getUsr();
		if (resultado.equals("TUTOR")) {
			miControlador.SoundActivo();
			miControlador.menuTutor(user);
			miModelo.limpiar(lblrespuesta);
		} else if (resultado.equals("ADMIN")) {
			miControlador.SoundActivo();
			miControlador.menuDirector(user);
			miModelo.limpiar(lblrespuesta);
		} else if (resultado.contentEquals("ERROR")) {
			miControlador.SoundError();
			lblrespuesta.setText("Usuario o contraseña incorrectos");
			miModelo.limpiar(passwordField);
		} else {
			System.exit(0);

		}
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
