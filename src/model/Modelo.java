package model;

import java.awt.Checkbox;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import com.sun.java.util.jar.pack.Attribute.Layout.Element;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.BusquedaPersonalizada;
import Ventanas.Empresa;
import Ventanas.IniTutor;
import Ventanas.Login;
import Ventanas.MenuDirector;
import Ventanas.Tutores;
import Ventanas.buscarEmpresa;
import java.sql.SQLException;

public class Modelo {
	private Login miLogin;

	private String resultado;
	private IniTutor menuTutor;
	private MenuDirector menuAdmin;
	private Tutores tutores;
	private BusquedaPersonalizada miBusqueda;
	private AsignarGrupo asgGrupo;
	private AsignarEmpresa asgEmpresa;
	private Alumno alumno;
	private int fallos;
	private buscarEmpresa buscEmpresa;
	private String login = "coffee";
	private Empresa empresa;
	private String pwd = "root";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private DefaultTableModel miTabla;
	private Connection conexion;
	private Checkbox checkbox;

	public Modelo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("-> Conexión con ORACLE establecida");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BD");
		} catch (Exception e) {
			System.out.println("Error general de Conexión");
		}
	}

	public void terminar() {
		try {
			conexion.close();
		} catch (SQLException e) {
		}
	}

	public void consultaStatement(String query, int columna) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next())
				System.out.println(rset.getString(columna));
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void consultaPrepared(String query, int cod, int columna) {
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, cod);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				System.out.println(rset.getString(columna));
			rset.close();
			pstmt.close();
		} catch (SQLException s) {

		}
	}

	public int insertar(String usr, String pwd) {
		int resultado = 0;
		try {
			String query = "INSERT INTO COFFE.users (usr,pwd) VALUES (?,?)";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public int modificar(String pwd) {
		int resultado = 0;
		try {
			String query = "UPDATE COFFE.users SET pwd = ?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, pwd);
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public int borrar(String usr) {
		int resultado = 0;
		try {
			String query = "DELETE FROM COFFE.users WHERE usr = ?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public void infoBaseDatos() {
		try {
			DatabaseMetaData dbmd = conexion.getMetaData();
			System.out.println("URL: " + dbmd.getURL());
			System.out.println("Usuario: " + dbmd.getUserName());
			System.out.println("Driver: " + dbmd.getDriverName());
			// Catalogo - Esquema - Tabla - Tipo
			ResultSet misTablas = dbmd.getTables("COFFE", "COFFE", null, null);
			System.out.println("TABLAS");
			while (misTablas.next()) {
				System.out.println("-> " + misTablas.getString("TABLE_NAME"));
			}
			misTablas.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	// Cambiar la palabra COFFE por el workspace de cada base de datos!!!
	public String getRol(String usr, String pwd) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(
					"SELECT rol FROM COFFEE.users WHERE usr = " + "'" + usr + "'" + " AND pwd = " + "'" + pwd + "'");
			rset.next();
			String rol = rset.getString(1);
			return rol;
		} catch (SQLException e) {

			return "ERROR";
		}
	}

	public DefaultTableModel getTabla(String tabla) {

		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas(tabla);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT * FROM " + tabla);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();

			for (int i = 0; i < numColumnas; i++) {
				miTabla.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				miTabla.addRow(contenido);
			}
		} catch (SQLException e) {

		}
		return miTabla;

	}
	
	public DefaultTableModel getAlumnosTutor(String user) {

		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas("alumno");
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT alumno.* FROM alumno " +
				    "LEFT JOIN pertenece "+
				    "ON alumno.num_exp = pertenece.alumno_num_exp "+
				    "LEFT JOIN GRUPO "+
				    "ON pertenece.grupo_cod_grupo = grupo.cod_grupo "+
				    "LEFT JOIN GESTIONA "+
				    "ON grupo.cod_grupo = gestiona.grupo_cod_grupo "+
				    "LEFT JOIN TUTOR "+
				    "ON gestiona.tutor_dni_tutor = tutor.dni_tutor "+
				    "LEFT JOIN EJERCE "+
				    "ON tutor.dni_tutor = ejerce.e_dni_tutor "+
				    "WHERE e_dni_tutor = (SELECT tutor.dni_tutor FROM tutor, users, ejerce WHERE tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr = '"+user+"')");
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();

			for (int i = 0; i < numColumnas; i++) {
				miTabla.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				miTabla.addRow(contenido);
			}
		} catch (SQLException e) {

		}
		return miTabla;

	}
	

	private int getNumColumnas(String tabla) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM " + tabla);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {

		}
		return num;
	}

	public String getDato(String tabla, String pk, String cod, int colum) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM COFFEE." + tabla + " WHERE " + pk + " = '" + cod + "'");
			rset.next();
			return rset.getString(colum);
		} catch (SQLException e) {

			return "ERROR";
		}
	}

	public void setLogin(Login miLogin) {
		this.miLogin = miLogin;
	}

	public void login(String usr, String pwd) {
		String rol = getRol(usr, pwd);
		if (rol.toUpperCase().equals("TUTOR")) {
			resultado = "TUTOR";
			fallos = 0;
		} else if (rol.toUpperCase().equals("ADMIN")) {
			resultado = "ADMIN";
			fallos = 0;
		} else {
			fallos++;
			resultado = "ERROR";
		}
		if (fallos == 3) {
			resultado = "Cerrar";
		}

		miLogin.actualaizar();
	}

	// Sonido de acceso correcto
	public void soundAcceso() {

		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src/Sonidos/in7.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
//           sonido.loop(Clip.LOOP_CONTINUOUSLY);
			sonido.loop(0);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error de Sonido de Acceso");
		}
	}

	// Sonido de acceso incorrecto
	public void soundErrorAcceso() {

		try {
			AudioInputStream audio = AudioSystem
					.getAudioInputStream(new File("src/Sonidos/Error.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
//           sonido.loop(Clip.LOOP_CONTINUOUSLY);
			sonido.loop(0);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error de Sonido de acceso incorrecto");
		}

	}

	// Sonido pasar por el boton
	public void soundSobreBoton() {

		try {
			AudioInputStream audio = AudioSystem
					.getAudioInputStream(new File("src/Sonidos/move.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
//           sonido.loop(Clip.LOOP_CONTINUOUSLY);
			sonido.loop(0);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error de Sonido de pasar boton por encima");

		}
	}

	// Sonido logoff
	public void soundLogAtras() {
		try {
			AudioInputStream audio = AudioSystem
					.getAudioInputStream(new File("src/Sonidos/Logoff.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
//           sonido.loop(Clip.LOOP_CONTINUOUSLY);
			sonido.loop(0);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error de Sonido de logoff o boton de ir atras");
		}
	}

	// Sonido ClickBoton
	public void soundSend() {

		try {
			AudioInputStream audio = AudioSystem
					.getAudioInputStream(new File("src/Sonidos/Send.wav").getAbsoluteFile());
			Clip sonido = AudioSystem.getClip();
			sonido.open(audio);
			sonido.start();
//           sonido.loop(Clip.LOOP_CONTINUOUSLY);
			sonido.loop(0);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error de Sonido de hacer ClickBoton");
		}
	}

	public void setMenuTutor(IniTutor menuTutor) {
		this.menuTutor = menuTutor;
	}

	public void setMenuAdmin(MenuDirector menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	public void setTutores(Tutores tutores) {
		this.tutores = tutores;
	}

	public void setMiBusqueda(BusquedaPersonalizada miBusqueda) {
		this.miBusqueda = miBusqueda;
	}

	public void setAsgGrupo(AsignarGrupo asgGrupo) {
		this.asgGrupo = asgGrupo;
	}

	public void setAsgEmpresa(AsignarEmpresa asgEmpresa) {
		this.asgEmpresa = asgEmpresa;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setBuscarEmpresa(buscarEmpresa buscEmpresa) {
		this.buscEmpresa = buscEmpresa;
	}

	public String getResultado() {
		return resultado;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void limpiar(JTextField text) {
		text.setText(null);

	}

	public void limpiar(JLabel lblrespuesta) {
		lblrespuesta.setText(null);

	}

	public String getEmpresa(String alumno) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT empresa.nombre FROM empresa, practica, alumno"
					+ " WHERE alumno.num_exp = practica.alumno_num_exp AND practica.empresa_cif = empresa.cif "
					+ "AND alumno.nombre= '" + alumno + "'");
			rset.next();
			String rol = rset.getString(1);
			return rol;
		} catch (SQLException e) {
			return "ERROR";
		}
	}

}
