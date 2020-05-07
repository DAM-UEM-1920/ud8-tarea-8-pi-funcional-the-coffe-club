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

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

		lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Tutores.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(53, 35, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		btnAadirTutor = new JButton("A\u00F1adir Tutor");
		btnAadirTutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
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
				miModelo.insert("tutor",
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
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnEliminarTutor.setToolTipText("Elimina un tutor del registro");
		btnEliminarTutor.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnEliminarTutor.setEnabled(false);
		btnEliminarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tabla = (DefaultTableModel) table.getModel();
				tabla.removeRow(table.getSelectedRow());
				btnEliminarTutor.setEnabled(false);
				btnEditarTutor.setEnabled(false);
				btnAadirTutor.setEnabled(false);
				miControlador.limpiar(textNombre);
				miControlador.limpiar(textApellidos);
				miControlador.limpiar(textEmail);
				miControlador.limpiar(textArea);

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
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnEditarTutor.setToolTipText("Actualiza los datos");
		btnEditarTutor.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnEditarTutor.setEnabled(false);
		btnEditarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();
				miModelo.update("tutor",
						"nombre= '" + textNombre.getText() + "' , apellidos= '" + textApellidos.getText()
								+ "' , e_mail= '" + textEmail.getText() + "' , area= '" + textArea.getText()
								+ "' ,CENTRO_COD_CENTRO= " + Integer.parseInt(textFieldCentro.getText()),
						"dni_tutor", "'"+txtDniTutor.getText()+"'");
				miControlador.limpiar(textNombre);
				miControlador.limpiar(textApellidos);
				miControlador.limpiar(textEmail);
				miControlador.limpiar(textArea);
				btnEliminarTutor.setEnabled(false);
				btnEditarTutor.setEnabled(false);
				btnAadirTutor.setEnabled(false);

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
				miModelo.soundLogAtras();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
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
				miControlador.atrasTutores();
			}

		});

		JLabel lblTutores = new JLabel("Tutores");
		lblTutores.setForeground(Color.WHITE);
		lblTutores.setFont(new Font("Dialog", Font.BOLD, 49));
		lblTutores.setBounds(299, 69, 240, 66);
		frame.getContentPane().add(lblTutores);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 180, 706, 126);
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

		JButton btnAsignar = new JButton("Asignar Grupo");
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
		btnAsignar.setToolTipText("Asigna un grupo al dni del tutor");
		btnAsignar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = txtDniTutor.getText();
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

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(834, 58, 7, 20);
		frame.getContentPane().add(formattedTextField);
		frame.setBounds(550, 250, 865, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(miModelo.getTabla("tutor"));
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
				|| textEmail.getText().length() == 0 || textArea.getText().length() == 0) {
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
}
