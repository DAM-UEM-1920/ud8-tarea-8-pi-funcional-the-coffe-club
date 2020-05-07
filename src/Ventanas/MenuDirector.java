package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

import controller.Controlador;
import model.Modelo;

import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuDirector {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private String user;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @param launcher
	 */
	public MenuDirector() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);

		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenuDirector.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setTitle("P\u00E1gina principal");
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(550, 250, 818, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(MenuDirector.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(46, 35, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		JLabel lblNewLabel = new JLabel("Binvenid@ $Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(275, 70, 297, 58);
		frame.getContentPane().add(lblNewLabel);

		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setFocusable(false);
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(77, 362, 695, 6);
		frame.getContentPane().add(label_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(125, 224, 60, 141);
		frame.getContentPane().add(progressBar);
		progressBar.setValue(50);
		progressBar.setOrientation(SwingConstants.VERTICAL);

		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(269, 225, 60, 141);
		frame.getContentPane().add(progressBar_1);
		progressBar_1.setValue(30);
		progressBar_1.setOrientation(SwingConstants.VERTICAL);

		JProgressBar progressBar_1_1 = new JProgressBar();
		progressBar_1_1.setBounds(412, 224, 60, 141);
		frame.getContentPane().add(progressBar_1_1);
		progressBar_1_1.setValue(70);
		progressBar_1_1.setOrientation(SwingConstants.VERTICAL);

		JProgressBar progressBar_1_2 = new JProgressBar();
		progressBar_1_2.setBounds(541, 224, 60, 141);
		frame.getContentPane().add(progressBar_1_2);
		progressBar_1_2.setValue(30);
		progressBar_1_2.setOrientation(SwingConstants.VERTICAL);

		JLabel lblNewLabel_1_3 = new JLabel("Alumnos Becados");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(515, 364, 110, 26);
		frame.getContentPane().add(lblNewLabel_1_3);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundLogAtras();
			}
		});
		btnNewButton.setToolTipText("Desconectarse de la sesion");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(663, 33, 96, 26);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miModelo.terminar();
				miControlador.salirAdmin();
			}

		});

		JButton btnNewButton_1 = new JButton("Busqueda Personalizada");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}
		});
		btnNewButton_1.setToolTipText("Busqueda avanzada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.busquedaPersonalizada();
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(119, 401, 181, 35);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnTutores = new JButton("Buscar Tutor\r\n");
		btnTutores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}
		});
		btnTutores.setToolTipText("Busqueda de tutores");
		btnTutores.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnTutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				miControlador.buscarTutores();
			}
		});
		btnTutores.setBackground(Color.BLACK);
		btnTutores.setForeground(Color.WHITE);
		btnTutores.setBounds(371, 401, 150, 35);
		frame.getContentPane().add(btnTutores);

		JButton btnBuscarEmpresas = new JButton("Buscar Empresa");
		btnBuscarEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}
		});
		btnBuscarEmpresas.setToolTipText("Busqueda de Empresas");
		btnBuscarEmpresas
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnBuscarEmpresas.setBackground(Color.BLACK);
		btnBuscarEmpresas.setForeground(Color.WHITE);
		btnBuscarEmpresas.setBounds(599, 401, 162, 35);
		btnBuscarEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.buscarEmpre();
			}
		});
		frame.getContentPane().add(btnBuscarEmpresas);

		JLabel lblbarra = new JLabel("");
		lblbarra.setBackground(Color.BLACK);
		lblbarra.setOpaque(true);
		lblbarra.setBounds(74, 198, 9, 170);
		frame.getContentPane().add(lblbarra);

		JProgressBar progressBar_1_2_1 = new JProgressBar();
		progressBar_1_2_1.setValue(50);
		progressBar_1_2_1.setOrientation(SwingConstants.VERTICAL);
		progressBar_1_2_1.setBounds(663, 225, 60, 141);
		frame.getContentPane().add(progressBar_1_2_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("Alumnos aptos");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblNewLabel_1_3_1.setBounds(635, 364, 119, 26);
		frame.getContentPane().add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Alumnos trabajando");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_2.setForeground(Color.WHITE);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		lblNewLabel_1_3_2.setBounds(378, 363, 127, 26);
		frame.getContentPane().add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_3_2_1 = new JLabel("Alumnos sin empresa");
		lblNewLabel_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblNewLabel_1_3_2_1.setBounds(230, 364, 138, 26);
		frame.getContentPane().add(lblNewLabel_1_3_2_1);

		JLabel lblNewLabel_1_3_2_2 = new JLabel("Realizando practicas");
		lblNewLabel_1_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		lblNewLabel_1_3_2_2.setBounds(93, 364, 127, 26);
		frame.getContentPane().add(lblNewLabel_1_3_2_2);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MenuDirector.class.getResource("/Img/Fondogrande.jpg")));
		lblFondo.setBounds(0, 0, 812, 473);
		frame.getContentPane().add(lblFondo);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				lblNewLabel.setText("Welcome " + user);
			}
		});
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	public void setUser(String user) {
		this.user = user;
		
	}
}
