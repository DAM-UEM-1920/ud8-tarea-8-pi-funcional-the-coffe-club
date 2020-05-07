package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
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
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AsignarEmpresa {

	private JFrame frame;
	private JTable table_1;
	private Controlador miControlador;
	private Modelo miModelo;
	String numexp;

	public AsignarEmpresa() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Asignar Empresa");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AsignarEmpresa.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.ORANGE);

		JLabel lblNewLabel_Empresa = new JLabel("Empresa");
		lblNewLabel_Empresa.setForeground(Color.WHITE);
		lblNewLabel_Empresa.setBounds(366, 180, 202, 61);
		lblNewLabel_Empresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Empresa.setFont(new Font("Dialog", Font.BOLD, 34));

		JLabel lblNewLabel_NombreDelAlumno = new JLabel("");
		lblNewLabel_NombreDelAlumno.setForeground(Color.WHITE);
		lblNewLabel_NombreDelAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_NombreDelAlumno.setBounds(205, 25, 546, 54);
		lblNewLabel_NombreDelAlumno.setFont(new Font("Dialog", Font.BOLD, 48));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AsignarEmpresa.class.getResource("/Img/usuario.png")));
		lblNewLabel_3.setToolTipText("Foto");
		lblNewLabel_3.setBounds(823, 88, 134, 138);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().setLayout(null);

		JButton btnAsignar = new JButton("Asignar Empresa");
		btnAsignar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAsignar.setToolTipText("Asigna la empresa con el alumno");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				miModelo.insert("practica", "");
				miControlador.terminarAsgEmpresa();
			}
		});
		
		JLabel lblNewLabel_ApellidoAlumno = new JLabel("");
		lblNewLabel_ApellidoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_ApellidoAlumno.setForeground(Color.WHITE);
		lblNewLabel_ApellidoAlumno.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel_ApellidoAlumno.setBounds(215, 88, 546, 54);
		frame.getContentPane().add(lblNewLabel_ApellidoAlumno);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(AsignarEmpresa.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(46, 25, 110, 110);
		frame.getContentPane().add(lblLogoBoton);
		btnAsignar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAsignar.setBackground(Color.BLACK);
		btnAsignar.setBounds(329, 486, 414, 45);
		frame.getContentPane().add(btnAsignar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 252, 758, 200);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table_1);
		
		table_1.setBorder(UIManager.getBorder("Menu.border"));
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(lblNewLabel_NombreDelAlumno);
		frame.getContentPane().add(lblNewLabel_Empresa);

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
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtras.setBackground(Color.BLACK);
		btnAtras.setBounds(18, 486, 172, 45);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miControlador.atrasAsgEmpresa();

			}

		});

		JLabel lblExpedienteNumber = new JLabel("");
		lblExpedienteNumber.setToolTipText("Numero de Expediente del Alumno");
		lblExpedienteNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpedienteNumber.setForeground(Color.WHITE);
		lblExpedienteNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExpedienteNumber.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Numero de Expediente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblExpedienteNumber.setBounds(18, 162, 190, 68);
		frame.getContentPane().add(lblExpedienteNumber);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AsignarEmpresa.class.getResource("/Img/Fondogrande.jpg")));
		lblNewLabel.setBounds(0, 0, 1008, 659);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(550, 250, 1012, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table_1.setModel(miModelo.getTabla("empresa"));
				lblNewLabel_NombreDelAlumno.setText(miModelo.getDato("alumno", "num_exp", numexp, 2));
				lblNewLabel_ApellidoAlumno.setText(miModelo.getDato("alumno", "num_exp", numexp, 3));
				lblExpedienteNumber.setText(miModelo.getDato("alumno", "num_exp", numexp, 4));
				
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
	
	public void setNumExp(String numexp) {
		this.numexp = numexp;
	}
}
