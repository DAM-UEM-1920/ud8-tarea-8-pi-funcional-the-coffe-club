package Ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AsignarGrupo {

	private JFrame frame;
	private JTable table_1, table_2;
	private final JPanel panel = new JPanel();
	private Controlador miControlador;
	private Modelo miModelo;
	private String tutor, apellido, dni;

	public AsignarGrupo() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Asignar Grupo");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(AsignarGrupo.class.getResource("/Img/UEM-simbolo.jpg")));
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);

		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 996, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreTutor = new JLabel();
		lblNombreTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTutor.setForeground(Color.WHITE);
		lblNombreTutor.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNombreTutor.setBounds(200, 18, 546, 76);
		panel.add(lblNombreTutor);

		JLabel lblApellido = new JLabel();
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblApellido.setBounds(210, 95, 546, 76);
		panel.add(lblApellido);

		JLabel lblLogoBoton = new JLabel("");
		lblLogoBoton.setIcon(new ImageIcon(AsignarGrupo.class.getResource("/Img/LoUEBoton.png")));
		lblLogoBoton.setToolTipText("Volver al menu principal");
		lblLogoBoton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,
				Color.LIGHT_GRAY));
		lblLogoBoton.setBounds(51, 41, 110, 110);
		panel.add(lblLogoBoton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(110, 261, 759, 186);
		panel.add(scrollPane);

		table_1 = new JTable();
		table_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table_1);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int fila = table_1.getSelectedRow();

			}
		});

		table_2 = new JTable();
		table_2.setBounds(498, 5, 0, 0);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_2.setBorder(UIManager.getBorder("Tree.editorBorder"));
		panel.add(table_2);

		JButton btnAsignar = new JButton("Asignar");
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
		btnAsignar.setToolTipText("Asigna el tutor al grupo elegido");
		
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAsignar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAsignar.setBackground(Color.BLACK);
		btnAsignar.setBounds(307, 472, 424, 45);
		panel.add(btnAsignar);

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
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, null, null));
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtras.setBackground(Color.BLACK);
		btnAtras.setBounds(32, 490, 160, 45);
		panel.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.atrasAsgGrupo();

			}

		});

		JLabel lblNewLabel_Foto_1 = new JLabel("");
		lblNewLabel_Foto_1.setToolTipText("Foto");
		lblNewLabel_Foto_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Foto_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_Foto_1.setBackground(Color.BLACK);
		lblNewLabel_Foto_1.setBounds(69, 10, 0, 141);
		panel.add(lblNewLabel_Foto_1);

		JLabel lblNewLabel_Foto = new JLabel("");
		lblNewLabel_Foto.setBounds(802, 46, 150, 141);
		panel.add(lblNewLabel_Foto);
		lblNewLabel_Foto.setIcon(new ImageIcon(AsignarGrupo.class.getResource("/Img/usuario.png")));
		lblNewLabel_Foto.setToolTipText("Foto");
		lblNewLabel_Foto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Foto.setFont(new Font("Tahoma", Font.BOLD, 32));

		JLabel lblNewLabel_Grupos = new JLabel("Grupos");
		lblNewLabel_Grupos.setBounds(340, 190, 253, 60);
		panel.add(lblNewLabel_Grupos);
		lblNewLabel_Grupos.setForeground(Color.WHITE);
		lblNewLabel_Grupos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Grupos.setFont(new Font("Tahoma", Font.BOLD, 34));

		JLabel lbldni = new JLabel();
		lbldni.setToolTipText("Numero de Expediente del Alumno");
		lbldni.setHorizontalAlignment(SwingConstants.CENTER);
		lbldni.setForeground(Color.WHITE);
		lbldni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbldni.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DNI", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		lbldni.setBounds(23, 173, 190, 68);
		panel.add(lbldni);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(AsignarGrupo.class.getResource("/Img/Fondogrande.jpg")));
		lblFondo.setBounds(0, 0, 996, 573);
		panel.add(lblFondo);
		frame.setBounds(550, 250, 997, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table_1.getSelectedRow();
				miModelo.insert("gestiona", "'" + lbldni.getText() + "', " +(String) table_1.getValueAt(fila, 0) + 
						", EXTRACT(YEAR FROM sysdate), '22/03/2015'");
				miControlador.asignarGrupoFin();
			}
		});

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table_1.setModel(miModelo.getTabla("grupo"));
				tutor = miModelo.getDato("tutor", "dni_tutor", dni, 2);
				apellido = miModelo.getDato("tutor", "dni_tutor", dni, 3);
				lblNombreTutor.setText(tutor);
				lblApellido.setText(apellido);
				lbldni.setText(dni);
			}
		});

	}

	public void setdni(String dni) {
		this.dni = dni;
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
