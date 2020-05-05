package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import controller.Controlador;
import model.Modelo;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Empresa {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private String cif, domicilio, localidad, social, telefono, contacto, mail;

	public Empresa() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Empresa");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Empresa.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.ORANGE);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAtras.setToolTipText("Te lleva a la pantalla anterior");
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(0, 0, 0));
		btnAtras.setBounds(36, 386, 160, 45);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.EmpresaAtras();
			}
		});

		JLabel lblNewLabel_Nombre_Empresa = new JLabel("*Nombre Empresa");
		lblNewLabel_Nombre_Empresa.setForeground(Color.WHITE);
		lblNewLabel_Nombre_Empresa.setBounds(108, 28, 591, 63);
		lblNewLabel_Nombre_Empresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Nombre_Empresa.setFont(new Font("Tahoma", Font.BOLD, 40));

		JLabel lblLogoEmpresa = new JLabel("");
		lblLogoEmpresa.setToolTipText("LogoEmpresa");
		lblLogoEmpresa.setIcon(new ImageIcon(Empresa.class.getResource("/Img/logoEmpresa.gif")));
		lblLogoEmpresa.setBackground(new Color(0, 0, 0));
		lblLogoEmpresa.setBounds(690, 0, 151, 138);
		lblLogoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoEmpresa.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().setLayout(null);

		JLabel lblDNI2 = new JLabel("B-43564366");
		lblDNI2.setToolTipText("N\u00FAmero de Identificaci\u00F3n Fiscal");
		lblDNI2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NIF", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblDNI2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI2.setForeground(Color.WHITE);
		lblDNI2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDNI2.setBounds(130, 153, 163, 45);
		frame.getContentPane().add(lblDNI2);
		frame.getContentPane().add(lblLogoEmpresa);
		frame.getContentPane().add(btnAtras);
		frame.getContentPane().add(lblNewLabel_Nombre_Empresa);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setIcon(new ImageIcon(Empresa.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBounds(40, 28, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		JLabel lblNombre = new JLabel("Indra");
		lblNombre.setToolTipText("Nombre de la Empresa");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Razon Social", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblNombre.setBounds(130, 225, 163, 45);
		frame.getContentPane().add(lblNombre);

		JLabel lblDirección = new JLabel("C/Falsa N\u00BA123");
		lblDirección.setToolTipText("Direccion fiscal de la Empresa");
		lblDirección.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirección.setForeground(Color.WHITE);
		lblDirección.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDirección.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Domicilio Fiscal", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblDirección.setBounds(338, 153, 191, 45);
		frame.getContentPane().add(lblDirección);

		JLabel lblEmail = new JLabel("TeVamos@TodoYloSab.es");
		lblEmail.setToolTipText("Direccion de correo electronico");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "E-mail",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblEmail.setBounds(252, 294, 324, 45);
		frame.getContentPane().add(lblEmail);

		JLabel lblNacion_1 = new JLabel("647556378");
		lblNacion_1.setToolTipText("Telefono de contacto de la Empresa");
		lblNacion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNacion_1.setForeground(Color.WHITE);
		lblNacion_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNacion_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Telefono",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblNacion_1.setBounds(338, 225, 191, 45);
		frame.getContentPane().add(lblNacion_1);

		JLabel lblLocalidad = new JLabel("Madrid");
		lblLocalidad.setToolTipText("Localidad donde esta situada la Empresa");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setForeground(Color.WHITE);
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLocalidad.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Localidad",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblLocalidad.setBounds(579, 153, 147, 45);
		frame.getContentPane().add(lblLocalidad);

		JLabel lblContacto = new JLabel("RR.HH");
		lblContacto.setToolTipText("Departamento o persona de contacto");
		lblContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto.setForeground(Color.WHITE);
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContacto.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Representante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblContacto.setBounds(579, 225, 148, 45);
		frame.getContentPane().add(lblContacto);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Empresa.class.getResource("/Img/obras.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(540, 276, 313, 190);
		frame.getContentPane().add(label);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Empresa.class.getResource("/Img/Fondogrande.jpg")));
		lblFondo.setBounds(0, 0, 863, 466);
		frame.getContentPane().add(lblFondo);
		frame.setBounds(550, 250, 869, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				domicilio = miModelo.getDato("empresa", "cif", cif, 3);
				localidad = miModelo.getDato("empresa", "cif", cif, 5);
				social = miModelo.getDato("empresa", "cif", cif, 2);
				telefono = miModelo.getDato("empresa", "cif", cif, 4);
				contacto = miModelo.getDato("empresa", "cif", cif, 7);
				mail = miModelo.getDato("empresa", "cif", cif, 6);
				lblNewLabel_Nombre_Empresa.setText(social);
				lblDNI2.setText(cif);
				lblDirección.setText(domicilio);
				lblLocalidad.setText(localidad);
				lblNombre.setText(social);
				lblNacion_1.setText(telefono);
				lblContacto.setText(contacto);
				lblEmail.setText(mail);
			}
		});

	}

	public void setCif(String cif) {
		this.cif = cif;
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
}