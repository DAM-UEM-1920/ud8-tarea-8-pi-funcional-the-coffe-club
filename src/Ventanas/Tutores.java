package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Controlador;
import model.Modelo;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class Tutores {

	private JFrame frame;
	private JTable table;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textEmail;
	private JTextField textArea;
	private JButton btnEliminarTutor;
	private JButton btnAadirTutor;
	private JButton btnEditarTutor;
	private JTextField txtDniTutor;
	private JLabel lblLogoBoton;
	private JTextField textFieldCentro;
	private boolean carga = true;
	private JButton btnGuardarTabla;
	private JButton btnCargarTabla;

	/**
	 * Create the application.
	 * 
	 * @param launcherWindow
	 */
	public Tutores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Tutores");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Tutores.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);

		JButton btnGuardarTabla = new JButton("Guardar Tabla");
		btnGuardarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnGuardarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.guardarObjeto("tutor");
			}
		});
		btnGuardarTabla.setToolTipText("Guarda la tabla en un fichero");
		btnGuardarTabla.setForeground(Color.WHITE);
		btnGuardarTabla.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardarTabla.setBackground(Color.BLACK);
		btnGuardarTabla.setBounds(756, 180, 110, 31);
		frame.getContentPane().add(btnGuardarTabla);

		JButton btnCargarTabla = new JButton("Cargar Tabla");
		btnCargarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnCargarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carga = false;
				refrescar();

			}
		});
		btnCargarTabla.setToolTipText("Carga la tabla de un fichero seleccionado");
		btnCargarTabla.setForeground(Color.WHITE);
		btnCargarTabla.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnCargarTabla.setBackground(Color.BLACK);
		btnCargarTabla.setBounds(756, 243, 110, 31);
		frame.getContentPane().add(btnCargarTabla);

		textFieldCentro = new JTextField();
		textFieldCentro.setToolTipText("\u00C1rea academica del tutor");
		textFieldCentro.setOpaque(false);
		textFieldCentro.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCentro.setForeground(Color.WHITE);
		textFieldCentro.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldCentro.setColumns(10);
		textFieldCentro
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Centro", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldCentro.setBounds(725, 328, 124, 47);
		frame.getContentPane().add(textFieldCentro);
		textFieldCentro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Tutores.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(42, 36, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		btnAadirTutor = new JButton("A\u00F1adir Tutor");
		btnAadirTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnAadirTutor.setToolTipText("A\u00F1ade un tutor al registro");
		btnAadirTutor.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAadirTutor.setBackground(Color.BLACK);
		btnAadirTutor.setForeground(Color.WHITE);
		btnAadirTutor.setBounds(79, 401, 156, 37);
		btnAadirTutor.setEnabled(false);
		frame.getContentPane().add(btnAadirTutor);
		btnAadirTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tabla = (DefaultTableModel) table.getModel();
				miControlador.insertar("tutor",
						"'" + txtDniTutor.getText() + "', '" + textNombre.getText() + "', '" + textApellidos.getText()
								+ "', " + textFieldCentro.getText() + ", '" + textEmail.getText() + "', '"
								+ textArea.getText() + "'");
				miControlador.limpiar(textNombre);
				miControlador.limpiar(textApellidos);
				miControlador.limpiar(textEmail);
				miControlador.limpiar(textArea);
				miControlador.limpiar(textFieldCentro);
				miControlador.limpiar(txtDniTutor);
				table.setModel(miModelo.getTabla("tutor"));
				btnEliminarTutor.setEnabled(false);
				btnEditarTutor.setEnabled(false);
				btnAadirTutor.setEnabled(false);
			}
		});

		btnEliminarTutor = new JButton("Eliminar Tutor");
		btnEliminarTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnEliminarTutor.setToolTipText("Elimina un tutor del registro");
		btnEliminarTutor.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnEliminarTutor.setEnabled(false);
		btnEliminarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miControlador.askWindow(frame)) {
					miControlador.delete("ejerce", "e_dni_tutor ", "'" + txtDniTutor.getText() + "'");
					miControlador.delete("gestiona", "tutor_dni_tutor ", "'" + txtDniTutor.getText() + "'");
					miControlador.delete("tutor", "dni_tutor ", "'" + txtDniTutor.getText() + "'");
					btnEliminarTutor.setEnabled(false);
					btnEditarTutor.setEnabled(false);
					btnAadirTutor.setEnabled(false);
					miControlador.limpiar(textNombre);
					miControlador.limpiar(textApellidos);
					miControlador.limpiar(textEmail);
					miControlador.limpiar(textArea);
					table.setModel(miModelo.getTabla("tutor"));

				}
			}
		});
		btnEliminarTutor.setBackground(Color.BLACK);
		btnEliminarTutor.setForeground(Color.WHITE);
		btnEliminarTutor.setBounds(350, 401, 156, 37);
		frame.getContentPane().add(btnEliminarTutor);

		btnEditarTutor = new JButton("Guardar cambios");
		btnEditarTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miControlador.SoundSobreBoton();
			}
		});
		btnEditarTutor.setToolTipText("Actualiza los datos");
		btnEditarTutor.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnEditarTutor.setEnabled(false);
		btnEditarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (miControlador.askWindow(frame)) {
					int fila = table.getSelectedRow();
					miControlador.update("tutor",
							"nombre= '" + textNombre.getText() + "' , apellidos= '" + textApellidos.getText()
									+ "' , e_mail= '" + textEmail.getText() + "' , area= '" + textArea.getText()
									+ "' ,CENTRO_COD_CENTRO= " + Integer.parseInt(textFieldCentro.getText()),
							"dni_tutor", "'" + txtDniTutor.getText() + "'");
					miControlador.limpiar(textNombre);
					miControlador.limpiar(textApellidos);
					miControlador.limpiar(textEmail);
					miControlador.limpiar(textArea);
					miControlador.limpiar(textFieldCentro);
					miControlador.limpiar(txtDniTutor);
					btnEliminarTutor.setEnabled(false);
					btnEditarTutor.setEnabled(false);
					btnAadirTutor.setEnabled(false);

					table.setModel(miModelo.getTabla("tutor"));

				}
			}
		});
		btnEditarTutor.setBackground(Color.BLACK);
		btnEditarTutor.setForeground(Color.WHITE);
		btnEditarTutor.setBounds(615, 401, 156, 37);
		frame.getContentPane().add(btnEditarTutor);

		JButton btnAtrs = new JButton("Atras");
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
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.setBackground(Color.BLACK);
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBounds(42, 473, 123, 37);
		frame.getContentPane().add(btnAtrs);
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.limpiar(textNombre);
				miControlador.limpiar(textApellidos);
				miControlador.limpiar(textEmail);
				miControlador.limpiar(textArea);
				miControlador.limpiar(textFieldCentro);
				miControlador.limpiar(txtDniTutor);
				miControlador.atrasTutores();
			}

		});

		JLabel lblTutores = new JLabel("Tutores");
		lblTutores.setForeground(Color.WHITE);
		lblTutores.setFont(new Font("Dialog", Font.BOLD, 49));
		lblTutores.setBounds(237, 71, 240, 66);
		frame.getContentPane().add(lblTutores);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 168, 706, 126);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = table.getSelectedRow();
				textNombre.setText((String) table.getValueAt(fila, 1));
				textApellidos.setText((String) table.getValueAt(fila, 2));
				textEmail.setText((String) table.getValueAt(fila, 4));
				textArea.setText((String) table.getValueAt(fila, 5));
				txtDniTutor.setText((String) table.getValueAt(fila, 0));
				textFieldCentro.setText((String) table.getValueAt(fila, 3));
				updateBaja();

			}
		});
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		textNombre.setForeground(Color.WHITE);
		textNombre.setOpaque(false);
		textNombre
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Nombre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textNombre.setToolTipText("Introduzca el nombre");
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		textNombre.setColumns(10);
		textNombre.setBounds(26, 328, 123, 47);
		frame.getContentPane().add(textNombre);

		textApellidos = new JTextField();
		textApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		textApellidos.setFont(new Font("Tahoma", Font.BOLD, 16));
		textApellidos.setForeground(Color.WHITE);
		textApellidos.setOpaque(false);
		textApellidos
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Apellidos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textApellidos.setToolTipText("Introduzca los apellidos");
		textApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		textApellidos.setColumns(10);
		textApellidos.setBounds(156, 328, 189, 47);
		frame.getContentPane().add(textApellidos);

		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		textEmail.setForeground(Color.WHITE);
		textEmail.setOpaque(false);
		textEmail
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Email", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textEmail.setToolTipText("Introduzca el correo electronico");
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(350, 328, 227, 47);
		frame.getContentPane().add(textEmail);

		textArea = new JTextField();
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 16));
		textArea.setForeground(Color.WHITE);
		textArea.setOpaque(false);
		textArea.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"\u00C1rea", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textArea.setToolTipText("\u00C1rea academica del tutor");
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});
		textArea.setColumns(10);
		textArea.setBounds(589, 328, 124, 47);
		frame.getContentPane().add(textArea);

		txtDniTutor = new JTextField();
		txtDniTutor.setCaretColor(Color.CYAN);
		txtDniTutor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniTutor.setOpaque(false);
		txtDniTutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDniTutor.setForeground(Color.WHITE);
		txtDniTutor.setBorder(
				new TitledBorder(null, "Dni Tutor", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtDniTutor.setToolTipText("DNI del tutor que se quiere asignar");
		txtDniTutor.setBounds(533, 89, 147, 47);
		frame.getContentPane().add(txtDniTutor);
		txtDniTutor.setColumns(10);
		txtDniTutor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAlta();
				updateModificar();
			}
		});

		JButton btnAsignar = new JButton("Asignar Grupo");
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
		btnAsignar.setToolTipText("Asigna un grupo al dni del tutor");
		btnAsignar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = txtDniTutor.getText();
				miControlador.limpiar(textNombre);
				miControlador.limpiar(textApellidos);
				miControlador.limpiar(textEmail);
				miControlador.limpiar(textArea);
				miControlador.limpiar(textFieldCentro);
				miControlador.limpiar(txtDniTutor);
				miControlador.asgGrupo(dni);
			}
		});
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setBackground(Color.BLACK);
		btnAsignar.setBounds(716, 95, 123, 44);
		frame.getContentPane().add(btnAsignar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tutores.class.getResource("/Img/Fondogrande.jpg")));
		lblNewLabel.setBounds(0, 0, 996, 659);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(550, 250, 882, 562);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
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

	private void updateModificar() {
		if (textNombre.getText().length() == 0 || textApellidos.getText().length() == 0
				|| textEmail.getText().length() == 0 || textArea.getText().length() == 0
				|| table.getSelectedRow() == -1) {
			btnEditarTutor.setEnabled(false);
		} else {
			btnEditarTutor.setEnabled(true);
		}

	}

	private void updateAlta() {
		if (textNombre.getText().length() == 0 || textApellidos.getText().length() == 0
				|| textEmail.getText().length() == 0 || textArea.getText().length() == 0
				|| textFieldCentro.getText().length() == 0 || txtDniTutor.getText().length() == 0) {
			btnAadirTutor.setEnabled(false);
		} else {
			btnAadirTutor.setEnabled(true);
		}
	}

	private void updateBaja() {
		if (table.getSelectedRow() == -1) {
			btnEliminarTutor.setEnabled(false);
		} else {
			btnEliminarTutor.setEnabled(true);

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

	public void refrescar() {
		if (carga) {
			table.setModel(miModelo.getTabla("tutor"));

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
