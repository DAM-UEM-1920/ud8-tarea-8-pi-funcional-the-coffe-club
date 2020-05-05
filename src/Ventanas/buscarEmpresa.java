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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
				tblEmpresas.setModel(miModelo.getTabla("empresa"));
			}
		});
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(buscarEmpresa.class.getResource("/Img/UEM-simbolo.jpg")));

		frame.setTitle("Empresas");
		frame.setBounds(550, 250, 800, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
		lblEmpresas.setBounds(271, 59, 244, 70);
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
		txtBuscarEmpresa.setBounds(455, 130, 137, 51);
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
				DefaultTableModel tabla = (DefaultTableModel) tblEmpresas.getModel();
				String[] arr = { txtAddEmpNombre.getText(), txtAddEmpDireccion.getText(),
						txtAddEmpTelefono.getText(), txtAddEmpLocalidad.getText() };
				tabla.addRow(arr);
				txtAddEmpDireccion.setText("");
				txtAddEmpLocalidad.setText("");
				txtAddEmpNombre.setText("");
				txtAddEmpTelefono.setText("");
				miControlador.limpiar(txtAddEmpNombre);
				miControlador.limpiar(txtAddEmpDireccion);
				miControlador.limpiar(txtAddEmpTelefono);
				miControlador.limpiar(txtAddEmpLocalidad);
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
				DefaultTableModel tabla = (DefaultTableModel) tblEmpresas.getModel();
				tabla.removeRow(tblEmpresas.getSelectedRow());
				miControlador.limpiar(txtAddEmpNombre);
				miControlador.limpiar(txtAddEmpDireccion);
				miControlador.limpiar(txtAddEmpTelefono);
				miControlador.limpiar(txtAddEmpLocalidad);
				btnEliminarEmpresa.setEnabled(false);
				btnAniadirEmpresa.setEnabled(false);

			}
		});
		btnEliminarEmpresa.setToolTipText("Elimina la empresa seleccionada");
		btnEliminarEmpresa.setBounds(388, 491, 127, 31);
		frame.getContentPane().add(btnEliminarEmpresa);
		btnAniadirEmpresa.setBounds(195, 491, 117, 31);
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
				int fila = tblEmpresas.getSelectedRow();
				tblEmpresas.setValueAt(txtAddEmpNombre.getText(), fila, 1);
				tblEmpresas.setValueAt(txtAddEmpDireccion.getText(), fila, 2);
				tblEmpresas.setValueAt(txtAddEmpTelefono.getText(), fila, 3);
				tblEmpresas.setValueAt(txtAddEmpLocalidad.getText(), fila, 4);
				miControlador.limpiar(txtAddEmpNombre);
				miControlador.limpiar(txtAddEmpDireccion);
				miControlador.limpiar(txtAddEmpTelefono);
				miControlador.limpiar(txtAddEmpLocalidad);
				btnGuardarCambios.setEnabled(false);
				btnAniadirEmpresa.setEnabled(false);
				btnEliminarEmpresa.setEnabled(false);
			}
		});

		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setToolTipText("Actualiza los datos modificados");
		btnGuardarCambios.setBounds(602, 491, 127, 31);
		frame.getContentPane().add(btnGuardarCambios);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		scrollPane.setBounds(68, 191, 644, 219);

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
		txtAddEmpNombre.setBounds(36, 421, 127, 45);
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
		txtAddEmpDireccion.setBounds(162, 421, 209, 45);
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
		btnAtras.setBounds(26, 483, 109, 39);
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
		txtAddEmpTelefono.setBounds(371, 421, 137, 45);
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
		txtAddEmpLocalidad.setBounds(508, 421, 127, 45);
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
				miControlador.Empresa(cif);
			}
		});
		btnBuscarEmpresas.setToolTipText("Busca la Empresa que corresponda la NIF introducido");
		btnBuscarEmpresas.setForeground(Color.WHITE);
		btnBuscarEmpresas
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnBuscarEmpresas.setBackground(Color.BLACK);
		btnBuscarEmpresas.setBounds(602, 136, 110, 45);
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
		textRepresentante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Representante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textRepresentante.setBounds(635, 421, 117, 45);
		frame.getContentPane().add(textRepresentante);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(buscarEmpresa.class.getResource("/Img/Fondogrande.jpg")));
		lblBackground.setBounds(0, 0, 784, 559);
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
		if (txtAddEmpDireccion.getText().length() == 0
				|| txtAddEmpLocalidad.getText().length() == 0 || txtAddEmpNombre.getText().length() == 0
				|| txtAddEmpTelefono.getText().length() == 0) {
			btnAniadirEmpresa.setEnabled(false);
		} else {
			btnAniadirEmpresa.setEnabled(true);
		}
	}

	private void updateModificar() {
		if (txtAddEmpDireccion.getText().length() == 0
				|| txtAddEmpLocalidad.getText().length() == 0 || txtAddEmpNombre.getText().length() == 0
				|| txtAddEmpTelefono.getText().length() == 0 || tblEmpresas.getSelectedRow() == -1) {
			btnGuardarCambios.setEnabled(false);
		} else {
			btnGuardarCambios.setEnabled(true);
		}
	}
}
