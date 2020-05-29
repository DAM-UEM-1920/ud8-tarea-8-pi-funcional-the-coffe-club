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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

public class Alumno {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTable AlumTable;
	private String nombre, apellidos, numexp, nacionalidad, telefono, email, dni;
	private final JPanel panel = new JPanel();

	public Alumno() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Alumno");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Alumno.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.ORANGE);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
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
				miControlador.atrasAlumno();
			}
		});

		JLabel lblApellidoalumno = new JLabel();
		lblApellidoalumno.setForeground(Color.WHITE);
		lblApellidoalumno.setBounds(134, 90, 591, 63);
		lblApellidoalumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoalumno.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblApellidoalumno);

		JLabel lblNewLabel_Foto = new JLabel("");
		lblNewLabel_Foto.setToolTipText("Foto");
		lblNewLabel_Foto.setIcon(new ImageIcon(Alumno.class.getResource("/Img/usuario.png")));
		lblNewLabel_Foto.setBackground(new Color(0, 0, 0));
		lblNewLabel_Foto.setBounds(700, 39, 112, 138);
		lblNewLabel_Foto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Foto.setFont(new Font("Tahoma", Font.BOLD, 32));
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_NombreDelAlumno = new JLabel();
		lblNewLabel_NombreDelAlumno.setForeground(Color.WHITE);
		lblNewLabel_NombreDelAlumno.setBounds(176, 13, 490, 63);
		lblNewLabel_NombreDelAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_NombreDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel_NombreDelAlumno);

		JLabel lblNewLabel_NombreApellido = new JLabel();
		lblNewLabel_NombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_NombreApellido.setForeground(Color.WHITE);
		lblNewLabel_NombreApellido.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_NombreApellido.setBounds(176, 87, 514, 63);
		frame.getContentPane().add(lblNewLabel_NombreApellido);

		JLabel lblDNI2 = new JLabel();
		lblDNI2.setToolTipText("Documento Nacional de indentidad");
		lblDNI2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DNI",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		lblDNI2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI2.setForeground(Color.WHITE);
		lblDNI2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDNI2.setBounds(24, 207, 114, 45);
		frame.getContentPane().add(lblDNI2);
		frame.getContentPane().add(lblNewLabel_Foto);
		frame.getContentPane().add(btnAtras);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Completado");
		rdbtnNewRadioButton.setForeground(Color.GREEN);
		rdbtnNewRadioButton.setOpaque(false);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(128, 309, 95, 45);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Completado");
		rdbtnNewRadioButton_1.setOpaque(false);
		rdbtnNewRadioButton_1.setForeground(Color.GREEN);
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBackground(Color.GREEN);
		rdbtnNewRadioButton_1.setBounds(255, 309, 95, 45);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnPendienteAprobacioon = new JRadioButton("Pendiente");
		rdbtnPendienteAprobacioon.setForeground(Color.YELLOW);
		rdbtnPendienteAprobacioon.setOpaque(false);
		rdbtnPendienteAprobacioon.setBackground(new Color(255, 255, 0));
		rdbtnPendienteAprobacioon.setBounds(374, 309, 95, 45);
		frame.getContentPane().add(rdbtnPendienteAprobacioon);

		JRadioButton rdbtnIncompleto = new JRadioButton("Incompleto");
		rdbtnIncompleto.setForeground(Color.WHITE);
		rdbtnIncompleto.setOpaque(false);
		rdbtnIncompleto.setSelected(true);
		rdbtnIncompleto.setBackground(new Color(255, 0, 0));
		rdbtnIncompleto.setBounds(497, 309, 88, 45);
		frame.getContentPane().add(rdbtnIncompleto);

		JRadioButton rdbtnIncompleto_1 = new JRadioButton("Incompleto");
		rdbtnIncompleto_1.setForeground(Color.WHITE);
		rdbtnIncompleto_1.setOpaque(false);
		rdbtnIncompleto_1.setSelected(true);
		rdbtnIncompleto_1.setBackground(Color.RED);
		rdbtnIncompleto_1.setBounds(621, 309, 95, 45);
		frame.getContentPane().add(rdbtnIncompleto_1);

		JLabel lblAnexo = new JLabel("Anexo 1.1");
		lblAnexo.setForeground(Color.WHITE);
		lblAnexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAnexo.setBounds(118, 292, 88, 23);
		frame.getContentPane().add(lblAnexo);

		JLabel lblAnexo_5 = new JLabel("Anexo 2.1");
		lblAnexo_5.setForeground(Color.WHITE);
		lblAnexo_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexo_5.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAnexo_5.setBounds(246, 292, 88, 23);
		frame.getContentPane().add(lblAnexo_5);

		JLabel lblAnexo_1 = new JLabel("Anexo 2.2");
		lblAnexo_1.setForeground(Color.WHITE);
		lblAnexo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexo_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAnexo_1.setBounds(364, 292, 88, 23);
		frame.getContentPane().add(lblAnexo_1);

		JLabel lblAnexo_2 = new JLabel("Anexo 2.3");
		lblAnexo_2.setForeground(Color.WHITE);
		lblAnexo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexo_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAnexo_2.setBounds(487, 292, 88, 23);
		frame.getContentPane().add(lblAnexo_2);

		JLabel lblAnexo_3 = new JLabel("Anexo 3.2");
		lblAnexo_3.setForeground(Color.WHITE);
		lblAnexo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnexo_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAnexo_3.setBounds(611, 292, 88, 23);
		frame.getContentPane().add(lblAnexo_3);

		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnAsignar.setToolTipText("Te dirige a la asinacion de alumno empresa");
		btnAsignar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAsignar.setBackground(Color.BLACK);
		btnAsignar.setBounds(661, 386, 160, 45);
		frame.getContentPane().add(btnAsignar);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setIcon(new ImageIcon(Alumno.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBounds(40, 28, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		JLabel lblExpedienteNumber = new JLabel();
		lblExpedienteNumber.setToolTipText("Numero de Expediente del Alumno");
		lblExpedienteNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpedienteNumber.setForeground(Color.WHITE);
		lblExpedienteNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExpedienteNumber.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Numero de Expediente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblExpedienteNumber.setBounds(146, 207, 160, 45);
		frame.getContentPane().add(lblExpedienteNumber);

		JLabel lblNacion = new JLabel();
		lblNacion.setToolTipText("Pais de origen del alumno");
		lblNacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNacion.setForeground(Color.WHITE);
		lblNacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNacion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nacionalidad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblNacion.setBounds(313, 207, 132, 45);
		frame.getContentPane().add(lblNacion);

		JLabel lblDondevamosallies = new JLabel();
		lblDondevamosallies.setToolTipText("Direccion de correo electronico");
		lblDondevamosallies.setHorizontalAlignment(SwingConstants.CENTER);
		lblDondevamosallies.setForeground(Color.WHITE);
		lblDondevamosallies.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDondevamosallies.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "E-mail",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblDondevamosallies.setBounds(597, 207, 215, 45);
		frame.getContentPane().add(lblDondevamosallies);

		JLabel lblNacion_1 = new JLabel();
		lblNacion_1.setToolTipText("Telefono de contacto del alumno");
		lblNacion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNacion_1.setForeground(Color.WHITE);
		lblNacion_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNacion_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Telefono",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblNacion_1.setBounds(455, 207, 132, 45);
		frame.getContentPane().add(lblNacion_1);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Alumno.class.getResource("/Img/Fondogrande.jpg")));
		lblFondo.setBounds(0, 0, 863, 657);
		frame.getContentPane().add(lblFondo);

		JLabel lblNewLabel = new JLabel("Nombre Alumno");
		lblNewLabel.setBounds(359, 65, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(550, 250, 869, 495);
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.asignarEmpresa(numexp);
			}
		});
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lblNewLabel_NombreDelAlumno.setText(miModelo.getDato("alumno", "num_exp", numexp, 2));
				lblNewLabel_NombreApellido.setText(miModelo.getDato("alumno", "num_exp", numexp, 3));
				lblNacion.setText(miModelo.getDato("alumno", "num_exp", numexp, 5));
				lblDNI2.setText(miModelo.getDato("alumno", "num_exp", numexp, 1));
				lblDondevamosallies.setText(miModelo.getDato("alumno", "num_exp", numexp, 7));
				lblNacion_1.setText(miModelo.getDato("alumno", "num_exp", numexp, 8));
				lblExpedienteNumber.setText(miModelo.getDato("alumno", "num_exp", numexp, 4));
			}
			@Override
			public void windowClosing(WindowEvent e) {
				miControlador.SoundLogAtras();
				if (miControlador.askWindow(frame)) {

					JOptionPane.showMessageDialog(frame, "Recuerda, quedate en casa");
					System.exit(0);

				}
			}
		});

	}

	public void setexp(String numexp) {
		this.numexp = numexp;
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