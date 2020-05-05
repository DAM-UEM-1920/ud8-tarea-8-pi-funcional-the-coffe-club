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

public class BusquedaPersonalizada {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JCheckBox checkbox;

	/**
	 * Create the application.
	 */
	public BusquedaPersonalizada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("B\u00FAsqueda Personalizada");

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BusquedaPersonalizada.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setMinimumSize(new Dimension(75, 23));
		frame.getContentPane().setMaximumSize(new Dimension(75, 23));
		frame.getContentPane().setBackground(Color.ORANGE);
		
		JButton btnNombre = new JButton("Nombre");
		btnNombre.setBounds(229, 211, 103, 23);
		btnNombre.setMinimumSize(new Dimension(75, 23));
		btnNombre.setMaximumSize(new Dimension(75, 23));
		btnNombre.setPreferredSize(new Dimension(75, 23));
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().setLayout(null);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				miControlador.SoundSend();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (checkbox.isSelected()==true) {
					miControlador.setSonidos(true);

					miControlador.SoundSobreBoton();

				}else {
					miControlador.setSonidos(false);
				}
			
				
			}
		});
		btnFiltrar.setToolTipText("Filtra las opciones seleccionadas");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.personalizadaFin();
			}
		});
		
		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(BusquedaPersonalizada.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		frame.getContentPane().add(lblLogoBoton);
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnFiltrar.setBackground(Color.BLACK);
		btnFiltrar.setBounds(281, 447, 273, 45);
		frame.getContentPane().add(btnFiltrar);
		
		JLabel lblFiltrados = new JLabel("Filtrado");
		lblFiltrados.setFont(new Font("Tahoma", Font.BOLD, 58));
		lblFiltrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrados.setForeground(Color.WHITE);
		lblFiltrados.setBackground(Color.WHITE);
		lblFiltrados.setBounds(229, 71, 387, 93);
		frame.getContentPane().add(lblFiltrados);
		frame.getContentPane().add(btnNombre);
		
		JButton btnNumExp = new JButton("Num Exp");

		btnNumExp.setBounds(425, 210, 87, 23);

		frame.getContentPane().add(btnNumExp);
		
		JButton btnEmpresa = new JButton("Empresa");

		btnEmpresa.setBounds(595, 211, 100, 23);


		btnEmpresa.setMinimumSize(new Dimension(75, 23));
		btnEmpresa.setMaximumSize(new Dimension(75, 23));
		btnEmpresa.setPreferredSize(new Dimension(75, 23));
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, btnEmpresa, 592, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnEmpresa);
		
		JButton btnNombre_1 = new JButton("Nombre");
		btnNombre_1.setBounds(229, 278, 103, 23);
		btnNombre_1.setMinimumSize(new Dimension(75, 23));
		btnNombre_1.setMaximumSize(new Dimension(75, 23));
		btnNombre_1.setPreferredSize(new Dimension(75, 23));
		frame.getContentPane().add(btnNombre_1);
		
		JButton btnCodGrupo = new JButton("Cod Grupo");
		btnCodGrupo.setBounds(425, 278, 87, 23);
		btnCodGrupo.setMinimumSize(new Dimension(75, 23));
		btnCodGrupo.setMaximumSize(new Dimension(75, 23));
		btnCodGrupo.setPreferredSize(new Dimension(75, 23));
		springLayout.putConstraint(SpringLayout.NORTH, btnCodGrupo, 207, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNumExp, -44, SpringLayout.NORTH, btnCodGrupo);
		springLayout.putConstraint(SpringLayout.EAST, btnNumExp, 0, SpringLayout.EAST, btnCodGrupo);
		springLayout.putConstraint(SpringLayout.WEST, btnCodGrupo, 426, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCodGrupo, -275, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNumExp, 0, SpringLayout.WEST, btnCodGrupo);
		frame.getContentPane().add(btnCodGrupo);
		
		JButton btnCiclo = new JButton("Ciclo");
		btnCiclo.setBounds(595, 278, 100, 23);
		btnCiclo.setMinimumSize(new Dimension(75, 23));
		btnCiclo.setMaximumSize(new Dimension(75, 23));
		btnCiclo.setPreferredSize(new Dimension(75, 23));
		springLayout.putConstraint(SpringLayout.NORTH, btnCiclo, 207, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnEmpresa, -44, SpringLayout.NORTH, btnCiclo);
		springLayout.putConstraint(SpringLayout.EAST, btnEmpresa, 0, SpringLayout.EAST, btnCiclo);
		frame.getContentPane().add(btnCiclo);
		
		JButton button = new JButton("");
		button.setBounds(229, 345, 103, 20);
		button.setMinimumSize(new Dimension(75, 23));
		button.setMaximumSize(new Dimension(75, 23));
		button.setPreferredSize(new Dimension(75, 23));

		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(425, 345, 87, 20);
		button_1.setMinimumSize(new Dimension(75, 23));
		button_1.setMaximumSize(new Dimension(75, 23));
		button_1.setPreferredSize(new Dimension(75, 23));
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 44, SpringLayout.SOUTH, btnCodGrupo);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 426, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_1, 0, SpringLayout.EAST, btnNumExp);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(595, 345, 100, 20);
		button_2.setMinimumSize(new Dimension(75, 23));
		button_2.setMaximumSize(new Dimension(75, 23));
		button_2.setPreferredSize(new Dimension(75, 23));
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 44, SpringLayout.SOUTH, btnCiclo);
		springLayout.putConstraint(SpringLayout.EAST, btnCiclo, 0, SpringLayout.EAST, button_2);
		springLayout.putConstraint(SpringLayout.WEST, button_2, 596, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, button_2, -117, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCiclo, 0, SpringLayout.WEST, button_2);
		frame.getContentPane().add(button_2);
		
		JButton btnDni = new JButton("DNI");
		btnDni.setBounds(229, 406, 103, 23);
		btnDni.setMinimumSize(new Dimension(75, 23));
		btnDni.setMaximumSize(new Dimension(75, 23));
		btnDni.setPreferredSize(new Dimension(75, 23));
		frame.getContentPane().add(btnDni);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setBounds(425, 406, 87, 23);
		btnEmail.setMinimumSize(new Dimension(75, 23));
		btnEmail.setMaximumSize(new Dimension(75, 23));
		btnEmail.setPreferredSize(new Dimension(75, 23));
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -41, SpringLayout.NORTH, btnEmail);
		springLayout.putConstraint(SpringLayout.NORTH, btnEmail, 0, SpringLayout.NORTH, btnDni);
		springLayout.putConstraint(SpringLayout.WEST, btnEmail, 426, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnEmail, 0, SpringLayout.EAST, btnNumExp);
		frame.getContentPane().add(btnEmail);
		
		JButton btnTelfono = new JButton("Tel\u00E9fono");
		btnTelfono.setBounds(591, 406, 107, 23);
		frame.getContentPane().add(btnTelfono);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 212, 126, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alumnos", "Grupo", "Tutores", "Centro", "Empresa"}));
		comboBox.setToolTipText("Alumnos");
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(51, 279, 126, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Grupo", "Alumnos", "Tutores", "Centro", "Empresa"}));
		comboBox_1.setToolTipText("Alumnos");
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(51, 345, 125, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Make a Selection", "Grupo", "Alumnos", "Tutores", "Centro", "Empresa"}));
		comboBox_2.setToolTipText("Alumnos");
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(51, 407, 126, 20);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Tutores", "Grupo", "Alumnos", "Centro", "Empresa"}));
		comboBox_3.setToolTipText("Alumnos");
		frame.getContentPane().add(comboBox_3);
		
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
		btnAtrs.setBounds(37, 447, 140, 45);
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.personalizadaAtras();
				
			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBackground(Color.BLACK);
		frame.getContentPane().add(btnAtrs);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setOpaque(false);
		checkBox.setBounds(202, 280, 21, 21);
		checkBox.setBackground(Color.LIGHT_GRAY);
		checkBox.setForeground(Color.BLACK);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setOpaque(false);
		checkBox_1.setBounds(202, 213, 21, 21);
		checkBox_1.setBackground(Color.LIGHT_GRAY);
		checkBox_1.setForeground(Color.BLACK);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setOpaque(false);
		checkBox_3.setBounds(202, 408, 21, 21);
		checkBox_3.setBackground(Color.LIGHT_GRAY);
		checkBox_3.setForeground(Color.BLACK);
		frame.getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setOpaque(false);
		checkBox_6.setBounds(398, 280, 21, 21);
		checkBox_6.setBackground(Color.LIGHT_GRAY);
		springLayout.putConstraint(SpringLayout.EAST, checkBox_6, -6, SpringLayout.WEST, btnCodGrupo);
		checkBox_6.setForeground(Color.BLACK);
		frame.getContentPane().add(checkBox_6);
		
		JLabel lblBusquedaPersonalizada = new JLabel("B\u00FAsqueda Personalizada");
		lblBusquedaPersonalizada.setBounds(176, 20, 422, -24);
		lblBusquedaPersonalizada.setForeground(Color.WHITE);
		lblBusquedaPersonalizada.setFont(new Font("Dialog", Font.BOLD, 40));
		frame.getContentPane().add(lblBusquedaPersonalizada);
		
		JCheckBox checkBox_1_1 = new JCheckBox("");
		checkBox_1_1.setOpaque(false);
		checkBox_1_1.setBounds(202, 345, 21, 21);
		checkBox_1_1.setForeground(Color.BLACK);
		checkBox_1_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_1);
		
		JCheckBox checkBox_1_2 = new JCheckBox("");
		checkBox_1_2.setOpaque(false);
		checkBox_1_2.setBounds(398, 345, 21, 21);
		checkBox_1_2.setForeground(Color.BLACK);
		checkBox_1_2.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_2);
		
		JCheckBox checkBox_1_3 = new JCheckBox("");
		checkBox_1_3.setOpaque(false);
		checkBox_1_3.setBounds(398, 211, 21, 21);
		checkBox_1_3.setForeground(Color.BLACK);
		checkBox_1_3.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_3);
		
		JCheckBox checkBox_1_4 = new JCheckBox("");
		checkBox_1_4.setOpaque(false);

		checkBox_1_4.setBounds(568, 211, 21, 21);

		checkBox_1_4.setForeground(Color.BLACK);
		checkBox_1_4.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_4);
		
		JCheckBox checkBox_1_5 = new JCheckBox("");
		checkBox_1_5.setOpaque(false);
		checkBox_1_5.setBounds(568, 280, 21, 21);
		checkBox_1_5.setForeground(Color.BLACK);
		checkBox_1_5.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_5);
		
		JCheckBox checkBox_1_6 = new JCheckBox("");
		checkBox_1_6.setOpaque(false);
		checkBox_1_6.setBounds(568, 345, 21, 21);
		checkBox_1_6.setForeground(Color.BLACK);
		checkBox_1_6.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_6);
		
		JCheckBox checkBox_1_7 = new JCheckBox("");
		checkBox_1_7.setOpaque(false);
		checkBox_1_7.setBounds(398, 408, 21, 21);
		checkBox_1_7.setForeground(Color.BLACK);
		checkBox_1_7.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_7);
		JCheckBox checkBox_1_8 = new JCheckBox("");
		checkBox_1_8.setOpaque(false);
		checkBox_1_8.setBounds(564, 408, 21, 21);
		checkBox_1_8.setForeground(Color.BLACK);
		checkBox_1_8.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(checkBox_1_8);
		
		checkbox = new JCheckBox("Sonido");
		checkbox.setSelected(true);
		checkbox.setOpaque(false);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setForeground(Color.WHITE);
		checkbox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkbox.setContentAreaFilled(false);
		checkbox.setBounds(652, 477, 76, 22);
		frame.getContentPane().add(checkbox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1050, 699);
		lblNewLabel.setIcon(new ImageIcon(BusquedaPersonalizada.class.getResource("/Img/Fondogrande.jpg")));
		frame.getContentPane().add(lblNewLabel);
		frame.setBackground(Color.ORANGE);
		frame.setBounds(550, 250, 740, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public boolean SoundActivo() {
		boolean Activo = true;
		if (checkbox.isSelected()) {
			Activo = true;
		}else {
			Activo = false;
		}
		return Activo;
		
	}
}
