package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controlador;
import model.Modelo;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class buscarEmpresa {

	private JFrame frame;
	private JTable tblEmpresas;
	private JTextField txtBuscarEmpresa;
	private JTextField txtAddEmpNombre;
	private JTextField txtAddEmpDireccion;
	private JTextField txtAddEmpTelefono;
	private JTextField txtAddEmpLocalidad;
	private JButton btnGuardarCambios;
	private JButton btnEliminarEmpresa;
	private JButton btnAniadirEmpresa;
	private Modelo miModelo;
	private Controlador miControlador;
	private JButton btnAtras;
	private JLabel lblLogoBoton;
	private JButton btnBuscarEmpresas;
	private JTextField textRepresentante;
	private JTextField textFieldEmail;
	private boolean carga = true;

	/**
	 * Create the application.
	 */
	public buscarEmpresa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(buscarEmpresa.class.getResource("/Img/UEM-simbolo.jpg")));

		frame.setTitle("Empresas");
		frame.setBounds(550, 250, 852, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("Ingrese la direcci\u00F3n de la nueva empresa");
		textFieldEmail.setOpaque(false);
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.WHITE);
		textFieldEmail.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "E-mail",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setBounds(527, 441, 266, 45);
		frame.getContentPane().add(textFieldEmail);

		lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(buscarEmpresa.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(48, 39, 110, 110);
		frame.getContentPane().add(lblLogoBoton);

		JLabel lblEmpresas = new JLabel("Empresas");
		lblEmpresas.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblEmpresas.setForeground(Color.WHITE);
		lblEmpresas.setBounds(271, 13, 244, 70);
		frame.getContentPane().add(lblEmpresas);

		txtBuscarEmpresa = new JTextField();
		txtBuscarEmpresa.setCaretColor(Color.CYAN);
		txtBuscarEmpresa.setName("");
		txtBuscarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarEmpresa.setForeground(Color.WHITE);
		txtBuscarEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtBuscarEmpresa.setOpaque(false);
		txtBuscarEmpresa.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Introduzca El NIF", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtBuscarEmpresa.setToolTipText("Escriba aqu\u00ED el NIF de la empresa a buscar\r\n");
		txtBuscarEmpresa.setBounds(453, 78, 137, 51);
		frame.getContentPane().add(txtBuscarEmpresa);
		txtBuscarEmpresa.setColumns(10);

		btnAniadirEmpresa = new JButton("A\u00F1adir empresa");

		btnAniadirEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnAniadirEmpresa
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));

		btnAniadirEmpresa.setBackground(Color.BLACK);
		btnAniadirEmpresa.setForeground(Color.WHITE);
		btnAniadirEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAniadir();
			}
		});
		btnAniadirEmpresa.setEnabled(false);
		btnAniadirEmpresa.setToolTipText("A\u00F1ade la empresa con los datos introducidos en los campos");
		btnAniadirEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.insertar("empresa",
						"'" + txtBuscarEmpresa.getText() + "', '" + txtAddEmpNombre.getText() + "', '"
								+ txtAddEmpDireccion.getText() + "', " + txtAddEmpTelefono.getText() + ", '"
								+ txtAddEmpLocalidad.getText() + "', '" + textFieldEmail.getText() + "', '"
								+ textRepresentante.getText() + "'");
				tblEmpresas.setModel(miModelo.getTabla("empresa"));
				miControlador.limpiar(txtAddEmpNombre);
				miControlador.limpiar(txtAddEmpDireccion);
				miControlador.limpiar(txtAddEmpTelefono);
				miControlador.limpiar(txtAddEmpLocalidad);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textRepresentante);
				miControlador.limpiar(txtBuscarEmpresa);
				btnAniadirEmpresa.setEnabled(false);
			}
		});

		btnEliminarEmpresa = new JButton("Eliminar Empresa");

		btnEliminarEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnEliminarEmpresa
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));

		btnEliminarEmpresa.setBackground(Color.BLACK);
		btnEliminarEmpresa.setForeground(Color.WHITE);
		btnEliminarEmpresa.setEnabled(false);
		btnEliminarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miControlador.askWindow(frame)) {
					miControlador.delete("practica", "empresa_cif ", "'" + txtBuscarEmpresa.getText() + "'");
					miControlador.delete("colabora", "empresa_cif ", "'" + txtBuscarEmpresa.getText() + "'");
					miControlador.delete("empresa", "cif ", "'" + txtBuscarEmpresa.getText() + "'");
					miControlador.limpiar(txtAddEmpNombre);
					miControlador.limpiar(txtAddEmpDireccion);
					miControlador.limpiar(txtAddEmpTelefono);
					miControlador.limpiar(txtAddEmpLocalidad);
					btnEliminarEmpresa.setEnabled(false);
					btnAniadirEmpresa.setEnabled(false);
					tblEmpresas.setModel(miModelo.getTabla("empresa"));

				}
			}
		});
		btnEliminarEmpresa.setToolTipText("Elimina la empresa seleccionada");
		btnEliminarEmpresa.setBounds(388, 515, 127, 31);
		frame.getContentPane().add(btnEliminarEmpresa);
		btnAniadirEmpresa.setBounds(189, 515, 117, 31);
		frame.getContentPane().add(btnAniadirEmpresa);

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
		btnGuardarCambios
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));

		btnGuardarCambios.setBackground(Color.BLACK);
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (miControlador.askWindow(frame)) {
					int fila = tblEmpresas.getSelectedRow();
					miControlador.update("empresa",
							"cif= '" + txtBuscarEmpresa.getText() + "' , nombre= '" + txtAddEmpNombre.getText()
									+ "' , direccion= '" + txtAddEmpDireccion.getText() + "' , telefono= "
									+ txtAddEmpTelefono.getText() + " , localidad= '" + txtAddEmpLocalidad.getText()
									+ "', e_mail= '" + textFieldEmail.getText() + "', representantes= '"
									+ textRepresentante.getText() + "'",
							"cif", "'" + txtBuscarEmpresa.getText() + "'");
					miControlador.limpiar(txtAddEmpNombre);
					miControlador.limpiar(txtAddEmpDireccion);
					miControlador.limpiar(txtAddEmpTelefono);
					miControlador.limpiar(txtAddEmpLocalidad);
					miControlador.limpiar(textFieldEmail);
					miControlador.limpiar(textRepresentante);
					btnGuardarCambios.setEnabled(false);
					btnAniadirEmpresa.setEnabled(false);
					btnEliminarEmpresa.setEnabled(false);
					tblEmpresas.setModel(miModelo.getTabla("empresa"));

				}
			}
		});

		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setToolTipText("Actualiza los datos modificados");
		btnGuardarCambios.setBounds(603, 515, 127, 31);
		frame.getContentPane().add(btnGuardarCambios);

		JButton btnGuardarTabla = new JButton("Guardar Tabla");
		btnGuardarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.guardarObjeto("empresa");
			}
		});
		btnGuardarTabla.setToolTipText("Guarda la tabla en un fichero");
		btnGuardarTabla.setForeground(Color.WHITE);
		btnGuardarTabla.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnGuardarTabla.setBackground(Color.BLACK);
		btnGuardarTabla.setBounds(696, 218, 127, 31);
		frame.getContentPane().add(btnGuardarTabla);

		JButton btnCargarTabla = new JButton("Cargar Tabla");
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
		btnCargarTabla.setBounds(696, 260, 127, 31);
		frame.getContentPane().add(btnCargarTabla);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		scrollPane.setBounds(27, 160, 644, 219);

		frame.getContentPane().add(scrollPane);

		tblEmpresas = new JTable();
		tblEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblEmpresas.addFocusListener(new FocusAdapter() {

		});
		tblEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				eliminarEmp();
				txtAddEmpNombre.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 1).toString());
				txtAddEmpDireccion.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 2).toString());
				txtAddEmpTelefono.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 3).toString());
				txtAddEmpLocalidad.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 4).toString());
				textRepresentante.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 6).toString());
				txtBuscarEmpresa.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 0).toString());
				textFieldEmail.setText(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 5).toString());

			}
		});
		scrollPane.setViewportView(tblEmpresas);

		txtAddEmpNombre = new JTextField();
		txtAddEmpNombre.setBackground(Color.WHITE);
		txtAddEmpNombre.setDisabledTextColor(Color.GRAY);
		txtAddEmpNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddEmpNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddEmpNombre.setForeground(Color.WHITE);
		txtAddEmpNombre.setCaretColor(Color.WHITE);
		txtAddEmpNombre.setOpaque(false);
		txtAddEmpNombre.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nombre",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtAddEmpNombre.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				updateAniadir();
				updateModificar();
			}
		});
		txtAddEmpNombre.setToolTipText("Ingrese el nombre de la nueva empresa");
		txtAddEmpNombre.setColumns(10);
		txtAddEmpNombre.setBounds(48, 394, 180, 45);
		frame.getContentPane().add(txtAddEmpNombre);

		txtAddEmpDireccion = new JTextField();
		txtAddEmpDireccion.setBackground(Color.WHITE);
		txtAddEmpDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddEmpDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddEmpDireccion.setForeground(Color.WHITE);
		txtAddEmpDireccion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Direcci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtAddEmpDireccion.setCaretColor(Color.WHITE);
		txtAddEmpDireccion.setOpaque(false);
		txtAddEmpDireccion.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				updateAniadir();
				updateModificar();
			}
		});
		txtAddEmpDireccion.setToolTipText("Ingrese la direcci\u00F3n de la nueva empresa");
		txtAddEmpDireccion.setColumns(10);
		txtAddEmpDireccion.setBounds(527, 394, 266, 45);
		frame.getContentPane().add(txtAddEmpDireccion);

		btnAtras = new JButton("Atras");
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
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.buscarEmpreAtras();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBackground(Color.BLACK);
		btnAtras.setToolTipText("Te lleva a la pantalla anterior");
		btnAtras.setBounds(27, 511, 109, 39);
		frame.getContentPane().add(btnAtras);

		txtAddEmpTelefono = new JTextField();
		txtAddEmpTelefono.setBackground(Color.WHITE);
		txtAddEmpTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddEmpTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddEmpTelefono.setForeground(Color.WHITE);
		txtAddEmpTelefono.setBorder(
				new TitledBorder(null, "Telefono", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtAddEmpTelefono.setCaretColor(Color.WHITE);
		txtAddEmpTelefono.setOpaque(false);
		txtAddEmpTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateAniadir();
				updateModificar();
			}
		});
		txtAddEmpTelefono.setToolTipText("Ingrese el tel\u00E9fono de la nueva empresa");
		txtAddEmpTelefono.setColumns(10);
		txtAddEmpTelefono.setBounds(257, 441, 244, 45);
		frame.getContentPane().add(txtAddEmpTelefono);

		txtAddEmpLocalidad = new JTextField();
		txtAddEmpLocalidad.setBackground(Color.WHITE);
		txtAddEmpLocalidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddEmpLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddEmpLocalidad.setForeground(Color.WHITE);
		txtAddEmpLocalidad.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Localidad",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		txtAddEmpLocalidad.setCaretColor(Color.WHITE);
		txtAddEmpLocalidad.setOpaque(false);
		txtAddEmpLocalidad.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				updateAniadir();
				updateModificar();
			}
		});
		txtAddEmpLocalidad.setToolTipText("Ingrese la localidad de la nueva empresa");
		txtAddEmpLocalidad.setColumns(10);
		txtAddEmpLocalidad.setBounds(257, 394, 244, 45);
		frame.getContentPane().add(txtAddEmpLocalidad);
		btnBuscarEmpresas = new JButton("Buscar NIF");
		btnBuscarEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miModelo.soundSend();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				miModelo.soundSobreBoton();
			}
		});
		btnBuscarEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cif = txtBuscarEmpresa.getText();
				miControlador.limpiar(txtAddEmpNombre);
				miControlador.limpiar(txtAddEmpDireccion);
				miControlador.limpiar(txtAddEmpTelefono);
				miControlador.limpiar(txtAddEmpLocalidad);
				miControlador.limpiar(textFieldEmail);
				miControlador.limpiar(textRepresentante);
				miControlador.limpiar(txtBuscarEmpresa);
				miControlador.Empresa(cif);
			}
		});
		btnBuscarEmpresas.setToolTipText("Busca la Empresa que corresponda la NIF introducido");
		btnBuscarEmpresas.setForeground(Color.WHITE);
		btnBuscarEmpresas
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnBuscarEmpresas.setBackground(Color.BLACK);
		btnBuscarEmpresas.setBounds(602, 84, 110, 45);
		frame.getContentPane().add(btnBuscarEmpresas);

		textRepresentante = new JTextField();
		textRepresentante.setBackground(Color.WHITE);
		textRepresentante.setFont(new Font("Tahoma", Font.BOLD, 14));
		textRepresentante.setHorizontalAlignment(SwingConstants.CENTER);
		textRepresentante.setForeground(Color.WHITE);
		textRepresentante.setToolTipText("Departamento o persona de contacto");
		textRepresentante.setOpaque(false);
		textRepresentante.setColumns(10);
		textRepresentante.setCaretColor(Color.WHITE);
		textRepresentante.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Representante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textRepresentante.setBounds(48, 441, 180, 45);
		frame.getContentPane().add(textRepresentante);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(buscarEmpresa.class.getResource("/Img/Fondogrande.jpg")));
		lblBackground.setBounds(0, 0, 846, 559);
		frame.getContentPane().add(lblBackground);

	}

	private void eliminarEmp() {
		if (tblEmpresas.getSelectedRow() == -1) {
			btnEliminarEmpresa.setEnabled(false);
		} else {
			btnEliminarEmpresa.setEnabled(true);

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

	private void updateAniadir() {
		if (txtAddEmpDireccion.getText().length() == 0 || txtAddEmpLocalidad.getText().length() == 0
				|| txtAddEmpNombre.getText().length() == 0 || txtAddEmpTelefono.getText().length() == 0) {
			btnAniadirEmpresa.setEnabled(false);
		} else {
			btnAniadirEmpresa.setEnabled(true);
		}
	}

	private void updateModificar() {
		if (txtAddEmpDireccion.getText().length() == 0 || txtAddEmpLocalidad.getText().length() == 0
				|| txtAddEmpNombre.getText().length() == 0 || txtAddEmpTelefono.getText().length() == 0
				|| tblEmpresas.getSelectedRow() == -1) {
			btnGuardarCambios.setEnabled(false);
		} else {
			btnGuardarCambios.setEnabled(true);
		}
	}

	public void refrescar() {
		if (carga) {
			tblEmpresas.setModel(miModelo.getTabla("empresa"));

		} else {
			File rutaProyecto = new File(System.getProperty("user.dir"));
			JFileChooser fc = new JFileChooser(rutaProyecto);
			int seleccion = fc.showOpenDialog(frame);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File fichero = fc.getSelectedFile();
				tblEmpresas.setModel(miControlador.cargarFichero(fichero));
			}
		}

	}
}
