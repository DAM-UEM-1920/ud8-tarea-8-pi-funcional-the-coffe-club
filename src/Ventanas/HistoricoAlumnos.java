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
import javax.swing.JOptionPane;

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

public class HistoricoAlumnos {

	private JFrame frame;
	private Controlador miControlador;
	private Modelo miModelo;
	private JTable table;
	private int selectedValueAño = 0;
	private int selectedgrupo = 0;
	private int selectedValueTutor = 0;
	private String tutor;

	/**
	 * Create the application.
	 */
	public HistoricoAlumnos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("B\u00FAsqueda Personalizada");

		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(HistoricoAlumnos.class.getResource("/Img/UEM-simbolo.jpg")));
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
				;

				miControlador.SoundSobreBoton();

			}
		});
		btnFiltrar.setToolTipText("Filtra las opciones seleccionadas");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.SoundSend();
				miControlador.HistoricoAlumnosAtras();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 218, 551, 192);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);

		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);

		JComboBox comboBox_2_tutor = new JComboBox();
		comboBox_2_tutor.setBounds(507, 178, 140, 29);
		frame.getContentPane().add(comboBox_2_tutor);

		JComboBox comboBox_1_grupo = new JComboBox();
		comboBox_1_grupo.setBounds(306, 178, 140, 29);
		frame.getContentPane().add(comboBox_1_grupo);

		JComboBox comboBox_anio = new JComboBox();
		comboBox_anio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.SoundSend();
			}
		});	
		
		comboBox_anio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedValueAño = comboBox_anio.getSelectedIndex();
				if (comboBox_anio.getSelectedItem().toString().equals("Todos")) {
					table.setModel(
							miControlador.getAlumnosByNombreTutorYAño(comboBox_2_tutor.getSelectedItem().toString(),comboBox_1_grupo.getSelectedItem().toString() ,comboBox_anio.getSelectedItem().toString()));
				} else {
					table.setModel(miControlador.getAlumnosByGrupoYAño(tutor,
							miControlador.getCodigoGrupo(comboBox_1_grupo.getSelectedItem().toString()),
							comboBox_anio.getSelectedItem().toString()));
				}
			}
		});	

		comboBox_anio.setBounds(96, 178, 140, 29);
		frame.getContentPane().add(comboBox_anio);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(HistoricoAlumnos.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(49, 40, 110, 110);
		frame.getContentPane().add(lblLogoBoton);
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnFiltrar.setBackground(Color.BLACK);
		btnFiltrar.setBounds(281, 447, 273, 45);
		frame.getContentPane().add(btnFiltrar);

		JLabel lblFiltrados = new JLabel("Historico Academico");
		lblFiltrados.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblFiltrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrados.setForeground(Color.WHITE);
		lblFiltrados.setBackground(Color.WHITE);
		lblFiltrados.setBounds(169, 40, 529, 93);
		frame.getContentPane().add(lblFiltrados);
		SpringLayout springLayout = new SpringLayout();

		JButton btnAtrs = new JButton("Atras");
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 20));
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
		btnAtrs.setBounds(49, 453, 140, 45);
		btnAtrs.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.HistoricoAlumnosAtras();

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1050, 699);
		lblNewLabel.setIcon(new ImageIcon(HistoricoAlumnos.class.getResource("/Img/Fondogrande.jpg")));
		frame.getContentPane().add(lblNewLabel);
		frame.setBackground(Color.ORANGE);
		frame.setBounds(550, 250, 740, 547);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comboBox_anio.setModel(new DefaultComboBoxModel<String>(miControlador.getAños()));
				comboBox_1_grupo.setModel(new DefaultComboBoxModel<String>(miControlador.getGruposNoTutor()));
				comboBox_2_tutor.setModel(new DefaultComboBoxModel<String>(miControlador.getTutores()));
				comboBox_anio.setSelectedIndex(selectedValueAño);
				comboBox_1_grupo.setSelectedIndex(selectedgrupo);
				comboBox_2_tutor.setSelectedIndex(selectedValueTutor);
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
