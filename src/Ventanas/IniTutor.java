package Ventanas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpringLayout;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import controller.Controlador;
import model.Modelo;
import model.Tablas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class IniTutor {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JButton btnLogOut;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private Controlador miControlador;
	private Modelo miModelo;
	private JButton btnNewButton_1;
	private JLabel lblFondo;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmpresa;
	private JButton btnAadir;
	private JButton btnEliminar;
	private JButton btnGuardarCambios;
	private JLabel lblLogoBoton;
	private JTextField textFieldExp;
	private Login miLogin;
	private String user;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JTextField textFieldNacionalidad;
	private JTextField textFieldFechaNacimiento;
	private Tablas tabla;
	private boolean carga = true;

	/**
	 * Create the application.
	 */

	public IniTutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();

		frame.setTitle("P\u00E1gina Principal");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(IniTutor.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);

		JButton btnCargarTabla = new JButton("Cargar Tabla");
		btnCargarTabla.setToolTipText("Buscar por numero de expediente del alumno");
		btnCargarTabla.setForeground(Color.WHITE);
		btnCargarTabla.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnCargarTabla.setBackground(Color.BLACK);
		btnCargarTabla.setBounds(606, 212, 90, 28);
		frame.getContentPane().add(btnCargarTabla);

		JButton btnGuardarTabla = new JButton("Guardar Tabla");

		btnGuardarTabla.setToolTipText("Buscar por numero de expediente del alumno");
		btnGuardarTabla.setForeground(Color.WHITE);
		btnGuardarTabla.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardarTabla.setBackground(Color.BLACK);
		btnGuardarTabla.setBounds(606, 165, 90, 28);
		frame.getContentPane().add(btnGuardarTabla);

		JComboBox<String> comboBoxGrupos = new JComboBox();
		comboBoxGrupos.setBackground(Color.WHITE);
		comboBoxGrupos.setBounds(134, 95, 110, 22);
		frame.getContentPane().add(comboBoxGrupos);

		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setToolTipText("Introduzca los apellidos del alumno");
		textFieldFechaNacimiento.setOpaque(false);
		textFieldFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFechaNacimiento.setForeground(Color.WHITE);
		textFieldFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFechaNacimiento.setColumns(10);
		textFieldFechaNacimiento
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Fecha Nacimiento", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldFechaNacimiento.setBounds(381, 369, 131, 48);
		frame.getContentPane().add(textFieldFechaNacimiento);

		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setToolTipText("Introduzca los apellidos del alumno");
		textFieldNacionalidad.setOpaque(false);
		textFieldNacionalidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNacionalidad.setForeground(Color.WHITE);
		textFieldNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNacionalidad.setColumns(10);
		textFieldNacionalidad
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Nacionalidad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldNacionalidad.setBounds(517, 369, 160, 48);
		frame.getContentPane().add(textFieldNacionalidad);
		textFieldNacionalidad.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		textFieldTelefono = new JTextField();
		textFieldTelefono.setToolTipText("Introduzca los apellidos del alumno");
		textFieldTelefono.setOpaque(false);
		textFieldTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTelefono.setForeground(Color.WHITE);
		textFieldTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTelefono.setColumns(10);
		textFieldTelefono
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Telefono", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldTelefono.setBounds(237, 369, 138, 48);
		frame.getContentPane().add(textFieldTelefono);

		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("Introduzca los apellidos del alumno");
		textFieldEmail.setOpaque(false);
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"E-mail", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEmail.setBounds(12, 369, 217, 48);
		frame.getContentPane().add(textFieldEmail);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel.setBounds(193, 11, 293, 72);
		frame.getContentPane().add(lblNewLabel);

		lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(IniTutor.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(12, 11, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		table_1 = new JTable();
		table_1.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(table_1);

		btnLogOut = new JButton("Logout");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnLogOut.setToolTipText("Desconectarse de la sesion");
		btnLogOut.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnLogOut.setBounds(581, 13, 83, 28);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(Color.BLACK);
		frame.getContentPane().add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				miControlador.limpiar(textFieldDni);
				miControlador.limpiar(textFieldNombre);
				miControlador.limpiar(textFieldApellidos);
				miControlador.limpiar(textFieldEmpresa);
				miControlador.limpiar(textFieldExp);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textFieldNacionalidad);
				miControlador.limpiar(textFieldTelefono);
				miControlador.limpiar(textFieldFechaNacimiento);
				miModelo.terminar();
				miControlador.salirTutor();
			}

		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(507, 422, 117, 35);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.delete("pertenece", "ALUMNO_NUM_EXP ", textFieldExp.getText());
				miModelo.delete("practica", "ALUMNO_NUM_EXP ", textFieldExp.getText());
				miModelo.delete("alumno", "NUM_EXP ", textFieldExp.getText());
				miControlador.limpiar(textFieldDni);
				miControlador.limpiar(textFieldNombre);
				miControlador.limpiar(textFieldApellidos);
				miControlador.limpiar(textFieldEmpresa);
				miControlador.limpiar(textFieldExp);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textFieldNacionalidad);
				miControlador.limpiar(textFieldTelefono);
				miControlador.limpiar(textFieldFechaNacimiento);
				btnEliminar.setEnabled(false);
				btnGuardarCambios.setEnabled(false);
				btnAadir.setEnabled(false);

			}
		});
		frame.getContentPane().add(btnEliminar);

		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardarCambios.setBackground(Color.BLACK);
		btnGuardarCambios.setBounds(280, 422, 168, 35);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();
				miModelo.update("alumno",
						"num_exp= '" + textFieldExp.getText() + "' , nombre = '" + textFieldNombre.getText()
								+ "' , apellidos= '" + textFieldApellidos.getText() + "' , dni= '"
								+ textFieldDni.getText() + "' , nacionalidad= '" + textFieldNacionalidad.getText()
								+ "', fecha_nacimiento= '1-1-1', e_mail= '" + textFieldEmail.getText()
								+ "' , telefono= " + Integer.parseInt(textFieldTelefono.getText()),
						"num_exp", "'" + textFieldExp.getText() + "'");

				miControlador.limpiar(textFieldDni);
				miControlador.limpiar(textFieldNombre);
				miControlador.limpiar(textFieldApellidos);
				miControlador.limpiar(textFieldEmpresa);
				miControlador.limpiar(textFieldExp);
				miControlador.limpiar(textFieldFechaNacimiento);
				miControlador.limpiar(textFieldNacionalidad);
				miControlador.limpiar(textFieldTelefono);

				btnGuardarCambios.setEnabled(false);
				btnAadir.setEnabled(false);
				btnEliminar.setEnabled(false);

			}
		});
		frame.getContentPane().add(btnGuardarCambios);

		textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNombre
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Nombre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldNombre.setForeground(Color.WHITE);
		textFieldNombre.setOpaque(false);
		textFieldNombre.setToolTipText("Introduzca el nombre del alumno");
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(167, 308, 114, 48);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		textFieldApellidos = new JTextField();
		textFieldApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldApellidos
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Apellidos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldApellidos.setForeground(Color.WHITE);
		textFieldApellidos.setOpaque(false);
		textFieldApellidos.setToolTipText("Introduzca los apellidos del alumno");
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(287, 308, 217, 48);
		frame.getContentPane().add(textFieldApellidos);
		textFieldApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmpresa.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmpresa
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Empresa", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEmpresa.setForeground(Color.WHITE);
		textFieldEmpresa.setOpaque(false);
		textFieldEmpresa.setToolTipText("Introduzca en nombre de la empresa");
		textFieldEmpresa.setColumns(10);
		textFieldEmpresa.setBounds(507, 308, 157, 48);
		frame.getContentPane().add(textFieldEmpresa);
		textFieldEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		textFieldDni = new JTextField();
		textFieldDni.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDni.setOpaque(false);
		textFieldDni
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"DNI", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldDni.setForeground(Color.WHITE);
		textFieldDni.setToolTipText("Introduzca el numero de expediente del alumno");
		textFieldDni.setBounds(12, 307, 150, 49);
		frame.getContentPane().add(textFieldDni);
		textFieldDni.setColumns(10);
		textFieldDni.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		btnAadir = new JButton("Agregar");
		btnAadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAadir.setEnabled(false);
		btnAadir.setForeground(Color.WHITE);
		btnAadir.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAadir.setBackground(Color.BLACK);
		btnAadir.setBounds(97, 421, 117, 37);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tabla = (DefaultTableModel) table.getModel();
				miModelo.insert("alumno",
						"'" + textFieldDni.getText() + "', '" + textFieldNombre.getText() + "', '"
								+ textFieldApellidos.getText() + "', " + textFieldExp.getText() + ", '"
								+ textFieldNacionalidad.getText() + "', '" + textFieldFechaNacimiento.getText() + "', '"
								+ textFieldEmail.getText() + "', " + textFieldTelefono.getText());
				miModelo.insert("pertenece",
						textFieldExp.getText() + ", "
								+ miModelo.getCodigoGrupo(comboBoxGrupos.getSelectedItem().toString()) + ",'"
								+ miControlador.getYear() + "'");
				miControlador.limpiar(textFieldDni);
				miControlador.limpiar(textFieldNombre);
				miControlador.limpiar(textFieldApellidos);
				miControlador.limpiar(textFieldEmpresa);
				miControlador.limpiar(textFieldExp);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textFieldNacionalidad);
				miControlador.limpiar(textFieldTelefono);
				miControlador.limpiar(textFieldFechaNacimiento);
				table.setModel(miModelo.getAlumnosTutor(user));
				btnAadir.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnGuardarCambios.setEnabled(false);
			}
		});
		frame.getContentPane().add(btnAadir);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 159, 582, 135);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = table.getSelectedRow();
				textFieldDni.setText((String) table.getValueAt(fila, 0));
				textFieldNombre.setText((String) table.getValueAt(fila, 1));
				textFieldApellidos.setText((String) table.getValueAt(fila, 2));
				textFieldEmpresa.setText(miModelo.getEmpresa(textFieldNombre.getText()));
				textFieldExp.setText((String) table.getValueAt(fila, 3));
				textFieldEmail.setText((String) table.getValueAt(fila, 6));
				textFieldTelefono.setText((String) table.getValueAt(fila, 7));
				textFieldNacionalidad.setText((String) table.getValueAt(fila, 4));
				textFieldFechaNacimiento.setText((String) table.getValueAt(fila, 5));
				updateEliminar();
				updateAlta();
				updateModificar();
			}
		});

		JLabel lblGrupo = new JLabel("Mi Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGrupo.setBounds(237, 131, 160, 25);
		frame.getContentPane().add(lblGrupo);

		JButton btnAlumno = new JButton("Buscar");
		btnAlumno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAlumno.setToolTipText("Buscar por numero de expediente del alumno");
		btnAlumno.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAlumno.setBackground(Color.BLACK);
		btnAlumno.setForeground(Color.WHITE);
		btnAlumno.setBounds(536, 85, 131, 43);
		frame.getContentPane().add(btnAlumno);

		textFieldExp = new JTextField();
		textFieldExp.setCaretColor(Color.CYAN);
		textFieldExp.setToolTipText("Escriba el numero de expediente del alumno");
		textFieldExp.setOpaque(false);
		textFieldExp.setName("");
		textFieldExp.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldExp.setForeground(Color.WHITE);
		textFieldExp.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldExp.setColumns(10);
		textFieldExp.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Introduzca N\u00BA Expediente", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		textFieldExp.setBounds(358, 77, 168, 51);
		frame.getContentPane().add(textFieldExp);
		textFieldExp.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		lblFondo = new JLabel("");
		lblFondo.setForeground(Color.WHITE);
		lblFondo.setToolTipText("Escriba aqu\u00ED el Numero de Expediente del Alumno a buscar");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setIcon(new ImageIcon(IniTutor.class.getResource("/Img/Fondogrande.jpg")));
		lblFondo.setBounds(0, 0, 703, 492);
		frame.getContentPane().add(lblFondo);

		btnGuardarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.guardarObjeto(user);
			}
		});

		btnCargarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carga = false;
				refrescar();
			}
		});

		JLabel lblNewLabelCod_grupo = new JLabel("New label");
		lblNewLabelCod_grupo.setBounds(22, 130, 56, 16);
		frame.getContentPane().add(lblNewLabelCod_grupo);
		btnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numexp = textFieldExp.getText();
				miControlador.limpiar(textFieldDni);
				miControlador.limpiar(textFieldNombre);
				miControlador.limpiar(textFieldApellidos);
				miControlador.limpiar(textFieldEmpresa);
				miControlador.limpiar(textFieldExp);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textFieldNacionalidad);
				miControlador.limpiar(textFieldTelefono);
				miControlador.limpiar(textFieldFechaNacimiento);
				miControlador.vistaAlumno(numexp);

			}

		});

		frame.setBounds(550, 250, 710, 510);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				refrescar();
				lblNewLabel.setText("Welcome " + user);
				comboBoxGrupos.setModel(new DefaultComboBoxModel<String>(miControlador.getGrupos(user)));
			}
		});

	}

	protected void updateModificar() {
		if (textFieldDni.getText().length() == 0 || textFieldNombre.getText().length() == 0
				|| textFieldApellidos.getText().length() == 0 || textFieldEmpresa.getText().length() == 0
				|| table.getSelectedRow() == -1) {
			btnGuardarCambios.setEnabled(false);
		} else {
			btnGuardarCambios.setEnabled(true);
		}
	}

	private void updateEliminar() {
		if (table.getSelectedRow() == -1) {
			btnEliminar.setEnabled(false);
		} else {
			btnEliminar.setEnabled(true);

		}
	}

	private void updateAlta() {
		if (textFieldDni.getText().length() == 0 || textFieldNombre.getText().length() == 0
				|| textFieldApellidos.getText().length() == 0 || textFieldExp.getText().length() == 0
				|| textFieldFechaNacimiento.getText().length() == 0 || textFieldNacionalidad.getText().length() == 0) {
			btnAadir.setEnabled(false);
		} else {
			btnAadir.setEnabled(true);
		}

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

	public void setTutor(String user) {
		this.user = user;
	}
	

	public void refrescar() {
		if (this.carga) {
			table.setModel(miModelo.getAlumnosTutor(user));

		} else {
			File rutaProyecto = new File(System.getProperty("user.dir"));
			JFileChooser fc = new JFileChooser(rutaProyecto);
			int seleccion = fc.showOpenDialog(frame);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File fichero = fc.getSelectedFile();
				table.setModel(miControlador.cargarFichero(fichero));
			}
		}
		
	}

}
