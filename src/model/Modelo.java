package model;

import java.awt.Checkbox;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Vector;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

//import com.sun.java.util.jar.pack.Attribute.Layout.Element;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.HistoricoAlumnos;
import Ventanas.Historico_Tutor;
import Ventanas.Empresa;
import Ventanas.IniTutor;
import Ventanas.Login;
import Ventanas.MenuDirector;
import Ventanas.Tutores;
import Ventanas.buscarEmpresa;
import Ventanas.Opciones;
import Ventanas.Registro;

import java.sql.SQLException;

public class Modelo {
	private Login miLogin;

	private String resultado;
	private IniTutor menuTutor;
	private MenuDirector menuAdmin;
	private Tutores tutores;
	private HistoricoAlumnos miHistoricoAlumnos;
	private Historico_Tutor miHistoricoTutor;
	private AsignarGrupo asgGrupo;
	private AsignarEmpresa asgEmpresa;
	private Alumno alumno;
	private int fallos;
	private buscarEmpresa buscEmpresa;
	private Empresa empresa;
	private DefaultTableModel miTabla;
	private Connection conexion;
	private Checkbox checkbox;
	private Opciones opciones;
	private Registro registro;
	private String texto, usuario, passwd, url;
	private File fichero;
	private String[] parts;
	private JTable table;

	public Modelo() {

	}
/**
 * Inicializa la conexi�n a la BBDD Oracle
 */
	public void conexion() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usuario, passwd);
			System.out.println("-> Conexi�n con ORACLE establecida");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BD");
		} catch (Exception e) {
			System.out.println("Error general de Conexi�n");
		}
	}
/**
 * Finaliza la conexi�n con la BBDD Oracle
 */
	public void terminar() {
		try {
			conexion.close();
		} catch (SQLException e) {
		}
	}


	// Cambiar la palabra COFFE por el workspace de cada base de datos!!!
	/**
	 * Devuelve el rol del usuario logueado
	 * 
	 * @param usr el usuario que se loguea
	 * @param pwd la constrase�a del user
	 * @return devuelve el rol si se ha logueado correctamente y si hay un fallo devuelve ERROR
	 */
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

	/**
	 * Devuelve toda la tabla seleccionada
	 * 
	 * @param tabla nombre de la tabla de la BBDD que se quiere extraer
	 * @return
	 */
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

	/**
	 * Devuelve los alumnos que supervisa el usuario
	 * 
	 * @param user usuario logueado
	 * @return tabla con los alumnos y todos sus datos
	 */
	public DefaultTableModel getAlumnosTutor(String user) {

		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas("alumno");
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT alumno.* FROM alumno " + "LEFT JOIN pertenece "
					+ "ON alumno.num_exp = pertenece.alumno_num_exp " + "LEFT JOIN GRUPO "
					+ "ON pertenece.grupo_cod_grupo = grupo.cod_grupo " + "LEFT JOIN GESTIONA "
					+ "ON grupo.cod_grupo = gestiona.grupo_cod_grupo " + "LEFT JOIN TUTOR "
					+ "ON gestiona.tutor_dni_tutor = tutor.dni_tutor " + "LEFT JOIN EJERCE "
					+ "ON tutor.dni_tutor = ejerce.e_dni_tutor "
					+ "WHERE e_dni_tutor = (SELECT tutor.dni_tutor FROM tutor, users, ejerce WHERE tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr = '"
					+ user + "')");
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

	/**
	 * Obtiene el numero de columnas de una tabla
	 * 
	 * @param tabla nombre de la tabla en la BBDD que se quiere extraer el n�mero de las columnas
	 * @return int la cantidad de columnas de la tabla especificada
	 */
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

	/**
	 * Devuelve un dato cualquiera de la base de datos
	 * 
	 * @param tabla  a la que realizamos la consulta
	 * @param pk     nombre de la Primary Key de la tabla
	 * @param cod    valor de busqueda de la Primary Key
	 * @param colum, columna en la que se encuentra el dato buscado
	 * @return
	 */
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

	/**
	 * Devuelve la empresa en la que el alumno esta realizando sus practicas
	 * 
	 * @param alumno nombre del alumno del que se quiere obtener la empresa
	 * @return nombre de empresa
	 */
	public String getEmpresa(String alumno) {
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT empresa.nombre FROM empresa, practica, alumno"
					+ " WHERE alumno.num_exp = practica.alumno_num_exp AND practica.empresa_cif = empresa.cif "
					+ "AND alumno.nombre= '" + alumno + "'");
			rset.next();
			String empresa = rset.getString(1);
			return empresa;
		} catch (SQLException e) {
			return "ERROR";
		}
	}

	/**
	 * devuelve los nombres de los grupos que supervisa el tutos a traves del nombre
	 * de usuario
	 * 
	 * @param user el nombre de usuario
	 * @return arraylist de nombres de grupos que supervisa un usuario
	 */
	public ArrayList<String> getGrupos(String user) {
		ArrayList<String> grupos = new ArrayList<String>();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT grupo.nom_grupo FROM grupo, gestiona, tutor, ejerce, users"
					+ " WHERE grupo.cod_grupo = gestiona.grupo_cod_grupo AND gestiona.tutor_dni_tutor = tutor.dni_tutor AND "
					+ "tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr= '" + user
					+ "'");

			while (rset.next()) {
				grupos.add(rset.getString(1));
			}
			return grupos;
		} catch (SQLException e) {
			return grupos;
		}

	}

	/**
	 * deelve los codigos de los centros que se encuentran en la base de datos
	 * 
	 * @return ArrayList de los centros almacenados en la BBDD
	 */
	public ArrayList<String> getCentros() {
		ArrayList<String> centro = new ArrayList<String>();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT cod_centro FROM centro");
			do {
				rset.next();
				centro.add(rset.getString(1));

			} while (rset.next());
			return centro;
		} catch (SQLException e) {
			return centro;
		}
	}

	/**
	 * devuelve el codigo del grupo a traves de su nombre
	 * 
	 * @param nomgrupo nombre del grupo del que se quiere obtener el c�digo
	 * @return codigo del grupo
	 */

	public String getCodigoGrupo(String nomgrupo) {
		String codigo = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT cod_grupo FROM grupo WHERE nom_grupo = '" + nomgrupo + "'");
			rset.next();
			codigo = rset.getString(1);
			return codigo;
		} catch (SQLException e) {
			return codigo;
		}

	}

	/**
	 * Obtenemos la tabla de alumnos filtrando por grupo y usuario(tutor) logueado
	 * 
	 * @param user el nombre de usuario
	 * @param grupo el nombre del grupo del que extraer los alumnos
	 * @return
	 */
	public DefaultTableModel getAlumnosByGrupo(String user, String grupo) {
		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas("alumno");
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT alumno.* FROM alumno " + "LEFT JOIN pertenece "
					+ "ON alumno.num_exp = pertenece.alumno_num_exp " + "LEFT JOIN GRUPO "
					+ "ON pertenece.grupo_cod_grupo = grupo.cod_grupo " + "LEFT JOIN GESTIONA "
					+ "ON grupo.cod_grupo = gestiona.grupo_cod_grupo " + "LEFT JOIN TUTOR "
					+ "ON gestiona.tutor_dni_tutor = tutor.dni_tutor " + "LEFT JOIN EJERCE "
					+ "ON tutor.dni_tutor = ejerce.e_dni_tutor "
					+ "WHERE e_dni_tutor = (SELECT tutor.dni_tutor FROM tutor, users, ejerce WHERE tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr = '"
					+ user + "') AND grupo.cod_grupo = " + grupo);
			System.out.println(grupo);
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

	/**
	 * devuelve tabla filtrando por el tutor, el grupo y el a�o al que los alumnos
	 * pertenecieron a un grupo
	 * 
	 * @param user nombre de usuario logueado
	 * @param grupo nombre del grupo a extraer datos
	 * @param a�o a�o por el que filtrar
	 * @return DefaultTableModel el modelo de la tabla
	 */
	public DefaultTableModel getAlumnosByGrupoYAnio(String user, String grupo, String anio) {
		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas("alumno");
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT alumno.* FROM alumno " + "LEFT JOIN pertenece "
					+ "ON alumno.num_exp = pertenece.alumno_num_exp " + "LEFT JOIN GRUPO "
					+ "ON pertenece.grupo_cod_grupo = grupo.cod_grupo " + "LEFT JOIN GESTIONA "
					+ "ON grupo.cod_grupo = gestiona.grupo_cod_grupo " + "LEFT JOIN TUTOR "
					+ "ON gestiona.tutor_dni_tutor = tutor.dni_tutor " + "LEFT JOIN EJERCE "
					+ "ON tutor.dni_tutor = ejerce.e_dni_tutor "
					+ "WHERE e_dni_tutor = (SELECT tutor.dni_tutor FROM tutor, users, ejerce WHERE tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr = '"
					+ user + "') AND grupo.cod_grupo = " + grupo + " AND pertenece.ano_acad = '" + anio + "'");
			System.out.println(grupo);
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
			System.out.println("error");

		}
		return miTabla;
	}

	/**
	 * obtiene tabla filtrando por tutor y por a�o al que un alumno pertenecio al
	 * grupo
	 * 
	 * @param user
	 * @param a�o
	 * @return DefaultTableMode
	 */
	public DefaultTableModel getAlumnosByTutorYanio(String user, String anio) {
		miTabla = new DefaultTableModel();
		int numColumnas = getNumColumnas("alumno");
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement("SELECT alumno.* FROM alumno " + "LEFT JOIN pertenece "
					+ "ON alumno.num_exp = pertenece.alumno_num_exp " + "LEFT JOIN GRUPO "
					+ "ON pertenece.grupo_cod_grupo = grupo.cod_grupo " + "LEFT JOIN GESTIONA "
					+ "ON grupo.cod_grupo = gestiona.grupo_cod_grupo " + "LEFT JOIN TUTOR "
					+ "ON gestiona.tutor_dni_tutor = tutor.dni_tutor " + "LEFT JOIN EJERCE "
					+ "ON tutor.dni_tutor = ejerce.e_dni_tutor "
					+ "WHERE e_dni_tutor = (SELECT tutor.dni_tutor FROM tutor, users, ejerce WHERE tutor.dni_tutor = ejerce.e_dni_tutor AND ejerce.e_usr_users = users.usr AND users.usr = '"
					+ user + "') AND pertenece.ano_acad = '" + anio + "'");
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
			System.out.println("error");

		}
		return miTabla;
	}

	/**
	 * inserta en la base de datos la fila en la tabla correspondiente, es
	 * importante que a los valores le pongamos las comillas y los espacios al
	 * String que introducimos en values ya que se introduce tal cual en la qwery de
	 * esta funcion.
	 * 
	 * @param tabla  tabla en la que actuamos
	 * @param values parte del insert que corresponde a la fila de TODOS los valores
	 * 
	 */
	public int insert(String tabla, String values) {
		int resultado = 0;
		try {
			String qwery = "INSERT INTO COFFEE." + tabla + " VALUES (" + values + ")";
			PreparedStatement pstmt = conexion.prepareStatement(qwery);
			resultado = pstmt.executeUpdate();
			System.out.println(tabla + " insertado con exito");
		} catch (SQLException e) {
			System.out.println(values);
			System.out.println("error de insertado");
		}
		return resultado;
	}

	/**
	 * Actualiza en la base de datos en la tabla que se le pase por par�metro y
	 * rellena el resto del UPDATE con el resto de par�metros
	 * 
	 * @param tabla   tabla en la que se act�a
	 * @param valores el cuerpo del UPDATE, incluye todas las columnas
	 * @param pk      Primary Key de la tabla
	 * @param cod     identificador de la fila en la que queremos actuar, coincide
	 *                con el campo PK
	 */
	public int update(String tabla, String valores, String pk, String cod) {
		int resultado = 0;

		try {
			String query = "UPDATE " + tabla + " SET " + valores + " WHERE " + pk + " = " + cod;
			PreparedStatement pstmt = conexion.prepareStatement(query);
			resultado = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(valores);
			System.out.println("error de update");
			e.printStackTrace();

		}
		return resultado;
	}

	/**
	 * Lanza una sentencia delete a la BBDD con los par�metros establecidos
	 * @param tabla tabla objetivo del delete
	 * @param pk Primary Key de la tabla espec�fica
	 * @param cod valor de la PK para elegir el borrado de un dato en concreto
	 * @return
	 */
	public int delete(String tabla, String pk, String cod) {
		int resultado = 0;
		try {
			String query = "DELETE FROM " + tabla + " WHERE " + pk + " = " + cod;
			PreparedStatement pstmt = conexion.prepareStatement(query);
			resultado = pstmt.executeUpdate();
			System.out.println(tabla + " eliminado con �xito");
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * elige a que ventana mandaremos al usuario segun sus permisos o si cerrara la
	 * aplicacicio por fallar varias veces
	 * 
	 * @param usr usuario logueado en al app
	 * @param pwd contrase�a del usuario logueado
	 */
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

		miLogin.actualaizar(resultado);
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

	public void metodoLectura() {

		texto = "";
		fichero = new File(System.getProperty("user.dir") + "/Users.ini");
		if (fichero.exists()) {
			usuario = "";
			try {
				Scanner sc = new Scanner(fichero);

				texto = sc.nextLine();
				parts = texto.split("-");
				usuario = parts[0];
				passwd = parts[1];
				url = parts[2];

				sc.close();
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else
			System.out.println("El fichero no existe");
	}

	/**
	 * Guarda una tabla cualquiera en un archivo en local
	 * 
	 * @param tabla
	 */
//	public void guardarObjeto(String tabla) {
//		File rutaProyecto = new File(System.getProperty("user.dir"));
//		JFileChooser fc = new JFileChooser(rutaProyecto);
//		int seleccion = fc.showSaveDialog(table);
//		if (seleccion == JFileChooser.APPROVE_OPTION) {
//			File fichero = fc.getSelectedFile();
//			try {
//				FileOutputStream fos = new FileOutputStream(fichero);
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
//				Tablas miTabla = new Tablas(getTabla(tabla));
//				oos.writeObject(miTabla);
//				fos.close();
//				oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	/**
	 * guarda una tabla con todos los alumnos del usuario logueado
	 * 
	 * @param user
	 */
	public void guardarObjetoTutor(String user) {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(table);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				Tablas miTabla = new Tablas(getAlumnosTutor(user));
				oos.writeObject(miTabla);
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarObjetoTutorYGrupo(String user, String grupo) {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(table);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				Tablas miTabla = new Tablas(getAlumnosByGrupo(user, grupo));
				oos.writeObject(miTabla);
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * carga una tabla guardada anteriormente en local, se selecciona dicho archivo
	 * en una ventana emergente
	 * 
	 * @param fichero
	 * @return
	 */
//	public DefaultTableModel cargarObjeto(File fichero) {
//		FileInputStream fis;
//		DefaultTableModel result = null;
//		try {
//			fis = new FileInputStream(fichero);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			Tablas miTabla = (Tablas) ois.readObject();
//			result = miTabla.getTabla();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//
//	}

	public void setMenuTutor(IniTutor menuTutor) {
		this.menuTutor = menuTutor;
	}

	public void setLogin(Login miLogin) {
		this.miLogin = miLogin;
	}

	public void setMenuAdmin(MenuDirector menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	public void setTutores(Tutores tutores) {
		this.tutores = tutores;
	}

	public void setMiBusqueda(HistoricoAlumnos miBusqueda) {
		this.miHistoricoAlumnos = miBusqueda;
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

	public void setOpciones(Opciones opciones) {
		this.opciones = opciones;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public void setMiHistoricoAlumnos(HistoricoAlumnos miHistoricoAlumnos) {
		this.miHistoricoAlumnos = miHistoricoAlumnos;
	}

	public void setMiHistoricoTutor(Historico_Tutor miHistoricoTutor) {
		this.miHistoricoTutor = miHistoricoTutor;
	}

}
