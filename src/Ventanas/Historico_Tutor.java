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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class Historico_Tutor {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JCheckBox checkbox;
	private JTable table;

	/**
	 * Create the application.
	 */
	public Historico_Tutor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("B\u00FAsqueda Personalizada");

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Historico_Tutor.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.setResizable(false);
		frame.getContentPane().setMinimumSize(new Dimension(75, 23));
		frame.getContentPane().setMaximumSize(new Dimension(75, 23));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFiltrar = new JButton("Seleccionar");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 218, 551, 192);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(508, 178, 140, 29);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(96, 178, 140, 29);
		frame.getContentPane().add(comboBox);
		
		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(Historico_Tutor.class.getResource("/Img/LoUEBoton.png")));
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
		
		JLabel lblFiltrados = new JLabel("Historico Tutor");
		lblFiltrados.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblFiltrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrados.setForeground(Color.WHITE);
		lblFiltrados.setBackground(Color.WHITE);
		lblFiltrados.setBounds(166, 40, 514, 93);
		frame.getContentPane().add(lblFiltrados);
		SpringLayout springLayout = new SpringLayout();
		
		JButton btnAtrs = new JButton("Atras");
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 20));
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
		btnAtrs.setBounds(49, 453, 140, 45);
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.personalizadaAtras();
				
			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setBackground(Color.BLACK);
		frame.getContentPane().add(btnAtrs);
		
		JLabel lblBusquedaPersonalizada = new JLabel("B\u00FAsqueda Personalizada");
		lblBusquedaPersonalizada.setBounds(176, 20, 422, -24);
		lblBusquedaPersonalizada.setForeground(Color.WHITE);
		lblBusquedaPersonalizada.setFont(new Font("Dialog", Font.BOLD, 40));
		frame.getContentPane().add(lblBusquedaPersonalizada);
		
		checkbox = new JCheckBox("Sonido");
		checkbox.setOpaque(false);
		checkbox.setHorizontalAlignment(SwingConstants.CENTER);
		checkbox.setForeground(Color.WHITE);
		checkbox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkbox.setContentAreaFilled(false);
		checkbox.setBounds(652, 477, 76, 22);
		frame.getContentPane().add(checkbox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1050, 699);
		lblNewLabel.setIcon(new ImageIcon(Historico_Tutor.class.getResource("/Img/Fondogrande.jpg")));
		frame.getContentPane().add(lblNewLabel);
		frame.setBackground(Color.ORANGE);
		frame.setBounds(550, 250, 740, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (miControlador.getBoxselect()) {
					checkbox.setSelected(true);
					
					
				}else
					checkbox.setSelected(false);
					
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
