package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
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

public class Opciones {

	private JFrame Opcio;
	private Controlador miControlador;
	private Modelo miModelo;
	private JCheckBox chckbxSonidoTeclas;

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
		
		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Opciones.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		Opcio.getContentPane().add(lblLogoBoton);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setForeground(Color.WHITE);
		lblOpciones.setBackground(Color.WHITE);
		lblOpciones.setBounds(204, 39, 221, 84);
		Opcio.getContentPane().add(lblOpciones);
		SpringLayout springLayout = new SpringLayout();
		
		JButton btnAtrs = new JButton("Volver");
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
		btnAtrs.setBounds(49, 244, 140, 45);
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
		chckbxSonidoTeclas.setSelected(true);
		chckbxSonidoTeclas.setOpaque(false);
		chckbxSonidoTeclas.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas.setForeground(Color.WHITE);
		chckbxSonidoTeclas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas.setContentAreaFilled(false);
		chckbxSonidoTeclas.setBounds(239, 130, 124, 22);
		Opcio.getContentPane().add(chckbxSonidoTeclas);
		
		JCheckBox chckbxSonidoTeclas_1 = new JCheckBox("Sonido teclas");
		chckbxSonidoTeclas_1.setSelected(true);
		chckbxSonidoTeclas_1.setOpaque(false);
		chckbxSonidoTeclas_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoTeclas_1.setForeground(Color.WHITE);
		chckbxSonidoTeclas_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoTeclas_1.setContentAreaFilled(false);
		chckbxSonidoTeclas_1.setBounds(239, 155, 124, 22);
		Opcio.getContentPane().add(chckbxSonidoTeclas_1);
		
		JCheckBox chckbxSonidoMandar = new JCheckBox("Sonido mandar");
		chckbxSonidoMandar.setSelected(true);
		chckbxSonidoMandar.setOpaque(false);
		chckbxSonidoMandar.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoMandar.setForeground(Color.WHITE);
		chckbxSonidoMandar.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoMandar.setContentAreaFilled(false);
		chckbxSonidoMandar.setBounds(239, 180, 134, 22);
		Opcio.getContentPane().add(chckbxSonidoMandar);
		
		JCheckBox chckbxSonidoVolver = new JCheckBox("Sonido volver");
		chckbxSonidoVolver.setSelected(true);
		chckbxSonidoVolver.setOpaque(false);
		chckbxSonidoVolver.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSonidoVolver.setForeground(Color.WHITE);
		chckbxSonidoVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSonidoVolver.setContentAreaFilled(false);
		chckbxSonidoVolver.setBounds(249, 205, 109, 22);
		Opcio.getContentPane().add(chckbxSonidoVolver);
		
		JLabel lblfondo = new JLabel("");
		lblfondo.setBounds(0, -24, 543, 337);
		lblfondo.setIcon(new ImageIcon(Opciones.class.getResource("/Img/Fondogrande.jpg")));
		Opcio.getContentPane().add(lblfondo);
		Opcio.setBackground(Color.ORANGE);
		Opcio.setBounds(550, 250, 549, 342);
		Opcio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		}else {
			Activo = false;
		}
		return Activo;
		
	}
}
