package controller;

import java.awt.Checkbox;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.HistoricoAlumnos;
import Ventanas.Historico_Tutor;
import Ventanas.Empresa;
import Ventanas.IniTutor;
import Ventanas.Login;
import Ventanas.MenuDirector;
import Ventanas.Opciones;
import Ventanas.Registro;
import Ventanas.Tutores;
import Ventanas.buscarEmpresa;
import model.Modelo;
import model.Tablas;

public class Controlador {
	private Modelo miModelo;
	private Login miLogin;
	private IniTutor menuTutor;
	private MenuDirector menuAdmin;
	private Tutores tutores;
	private HistoricoAlumnos miHistoricoAlumnos;
	private Historico_Tutor historico_Tutor;
	private AsignarGrupo asgGrupo;
	private AsignarEmpresa asgEmpresa;
	private Alumno alumno;
	private buscarEmpresa buscEmpresa;
	private JTextField text;
	private Empresa empresa;
	private Opciones opciones;
	private Registro registro;
	private boolean activo = true;

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setLogin(Login miLogin) {
		this.miLogin = miLogin;
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

	public void setHistoricoAlumnos(HistoricoAlumnos miHistoricoAlumnos) {
		this.miHistoricoAlumnos = miHistoricoAlumnos;
	}

	public void setHistoricoTutor(Historico_Tutor miHistoricoTutor) {
		this.historico_Tutor = miHistoricoTutor;
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

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setOpciones(Opciones opciones) {
		this.opciones = opciones;
	}

	public void login() {
		String usr = miLogin.getUsr();
		String pwd = miLogin.getPwd();
		miModelo.login(usr, pwd);

	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public void menuTutor(String user) {
		miLogin.setVisible(false);
		menuTutor.setTutor(user);
		menuTutor.refrescar();
		menuTutor.setVisible(true);
	}

	public void menuDirector(String user) {
		menuAdmin.setVisible(true);
		menuAdmin.setUser(user);
		miLogin.setVisible(false);

	}

	public void salirTutor() {
		miLogin.setVisible(true);
		menuTutor.setVisible(false);

	}

	public void salirAdmin() {
		miLogin.setVisible(true);
		menuAdmin.setVisible(false);

	}

	public void vistaAlumno(String numexp) {
		alumno.setexp(numexp);
		alumno.setVisible(true);
		menuTutor.setVisible(false);

	}

	public void atrasAlumno() {
		menuTutor.refrescar();
		menuTutor.setVisible(true);
		alumno.setVisible(false);

	}

	public void asignarEmpresa(String numexp) {
		alumno.setVisible(false);
		asgEmpresa.setNumExp(numexp);
		asgEmpresa.setVisible(true);

	}

	public void atrasAsgEmpresa() {
		asgEmpresa.setVisible(false);
		alumno.setVisible(true);

	}

	public void terminarAsgEmpresa() {
		asgEmpresa.setVisible(false);
		menuTutor.setVisible(true);

	}

	public void buscarTutores() {
		menuAdmin.setVisible(false);
		tutores.refrescar();
		tutores.setVisible(true);

	}

	public void HistoricoAlumnos() {
		menuAdmin.setVisible(false);
		miHistoricoAlumnos.setVisible(true);

	}

	public void HistoricoAlumnosAtras() {
		miHistoricoAlumnos.setVisible(false);
		menuAdmin.setVisible(true);

	}

	public void HistoricoTurtor(String user) {
		menuTutor.setVisible(false);
		historico_Tutor.setUser(user);
		historico_Tutor.setVisible(true);

	}

	public void HistoricoTurtorAtras() {
		historico_Tutor.setVisible(false);
		menuTutor.setVisible(true);

	}

	public void atrasTutores() {
		tutores.setVisible(false);
		menuAdmin.setVisible(true);
	}

	public void asgGrupo(String dni) {
		tutores.setVisible(false);
		asgGrupo.setdni(dni);
		tutores.refrescar();
		asgGrupo.setVisible(true);

	}

	public void atrasAsgGrupo() {
		asgGrupo.setVisible(false);
		tutores.setVisible(true);

	}

	public void asgGrupoFin() {
		asgGrupo.setVisible(false);
		menuAdmin.setVisible(true);

	}

	public void buscarEmpre() {
		menuAdmin.setVisible(false);
		buscEmpresa.refrescar();
		buscEmpresa.setVisible(true);

	}

	public void buscarEmpreAtras() {
		buscEmpresa.setVisible(false);
		menuAdmin.setVisible(true);

	}

	;

	public void Opciones() {
		miLogin.setVisible(false);
		opciones.setVisible(true);

	}

	public void OpcionesAtras() {
		opciones.setVisible(false);
		miLogin.setVisible(true);

	}

	public void asignarGrupoFin() {
		asgGrupo.setVisible(false);
		menuAdmin.setVisible(true);
	}

	public void limpiar(JTextField text) {
		this.text = text;
		miModelo.limpiar(text);

	}

	public void EmpresaAtras() {
		empresa.setVisible(false);
		buscEmpresa.refrescar();
		buscEmpresa.setVisible(true);

	}

	public void Registro() {
		miLogin.setVisible(false);
		registro.setVisible(true);
	}

	public void RegistroAtras() {
		registro.setVisible(false);
		miLogin.setVisible(true);

	}

	public void Empresa(String cif) {
		buscEmpresa.setVisible(false);
		empresa.setCif(cif);
		empresa.setVisible(true);
	}

	public void setSonidos(boolean activo) {
		this.activo = activo;

	}

	public void SoundAcceso() {

		if (activo == true) {
			miModelo.soundAcceso();
		}

	}

	public void SoundSobreBoton() {
		if (activo == true) {
			miModelo.soundSobreBoton();
		}
	}

	public void SoundError() {
		if (activo == true) {
			miModelo.soundErrorAcceso();
		}
	}

	public void SoundSend() {
		if (activo == true) {
			miModelo.soundSend();
		}
	}

	public void SoundLogAtras() {
		if (activo == true) {
			miModelo.soundLogAtras();
		}
	}

	public boolean getBoxselect() {
		return activo;

	}

	public String getYear() {
		int mes = LocalDate.now().getMonthValue();
		int año = LocalDate.now().getYear();
		if (mes < 8) {
			return String.valueOf(año - 1) + "/" + String.valueOf(año);
		} else
			return String.valueOf(año) + "/" + String.valueOf(año + 1);

	}

	public DefaultTableModel cargarFichero(File fichero) {
		return miModelo.cargarObjeto(fichero);

	}

	public void guardarObjetoTutor(String user) {
		miModelo.guardarObjetoTutor(user);

	}

	public void guardarObjetoTutorYGrupo(String user, String grupo) {
		miModelo.guardarObjetoTutorYGrupo(user, grupo);

	}

	public void guardarObjeto(String tabla) {
		miModelo.guardarObjeto(tabla);

	}

	public int insertar(String tabla, String values) {
		return miModelo.insert(tabla, values);

	}

	public int update(String tabla, String valores, String pk, String cod) {

		return miModelo.update(tabla, valores, pk, cod);
	}

	public int delete(String tabla, String pk, String cod) {
		return miModelo.delete(tabla, pk, cod);

	}

	public String[] getGrupos(String user) {
		ArrayList<String> grup = miModelo.getGrupos(user);
		int a = grup.size() + 1;
		String[] grupos = new String[a];
		grupos[0] = "Todos";
		for (int i = 1; i < grupos.length; i++) {
			grupos[i] = grup.get(i - 1);
		}
		grupos[grupos.length - 1] = grup.get(grup.size() - 1);
		System.out.println(grup.toString());
		System.out.println(Arrays.toString(grupos));
		return grupos;

	}

	/**
	 * Método que convierte el arraylist que hemos creado y que coge los datos del arrayList generado previamente con el métod getGruposNoTutor()
	 * El método getGruposNoTutor devuelve nombre del grupo sin tutor
	 * @return String []
	 */
	public String[] getGruposNoTutor() {
		ArrayList<String> grup = miModelo.getGruposNoTutor();
		int a = grup.size() + 1;
		String[] grupos = new String[a];
		grupos[0] = "Todos";
		for (int i = 1; i < grupos.length; i++) {
			grupos[i] = grup.get(i - 1);
		}
		grupos[grupos.length - 1] = grup.get(grup.size() - 1);
		System.out.println(grup.toString()+"FALLO!-1");
		System.out.println(Arrays.toString(grupos)+"FALLO!0");
		return grupos;

	}

	/**
	 * Método que convierte a String el arraylist que hemos creado y que coge los
	 * datos del Arraylist generado previamente con el método getTutor()
	 * El método getTutor devuelve el nombre del tutor
	 * 
	 * @return String[]
	 */
	public String[] getTutores() {
		ArrayList<String> tutores = miModelo.getTutor();
		int a = tutores.size() + 1;
		String[] tutor = new String[a];
		tutor[0] = "Todos";
		for (int i = 1; i < tutor.length; i++) {
			tutor[i] = tutores.get(i - 1);
		}
		tutor[tutor.length - 1] = tutores.get(tutores.size() - 1);
		System.out.println(tutores.toString()+"FALLO!");
		System.out.println(Arrays.toString(tutor)+"FALLO!2");
		return tutor;

	}

	public String[] getAños() {
		String[] añosAcad = new String[10];
		int mes = LocalDate.now().getMonthValue();
		int año = LocalDate.now().getYear();
		for (int i = 0; i < añosAcad.length; i++) {
			if (mes < 7) {
				añosAcad[i] = String.valueOf(año - i - 1) + "/" + String.valueOf(año - i);
			} else {
				añosAcad[i] = String.valueOf(año - i) + "/" + String.valueOf(año - i + 1);
			}
		}

		return añosAcad;

	}

	public DefaultTableModel getAlumnosByGrupo(String user, String grupo) {
		return miModelo.getAlumnosByGrupo(user, grupo);

	}

	public DefaultTableModel getAlumnosByNombreTutorYAño(String tutor, String grupo, String año) {
		return miModelo.getAlumnosByNombreTutorYAño(tutor, grupo, año);
	}

	public boolean askWindow(Component parentComponent) {
		int i = JOptionPane.showConfirmDialog(parentComponent, "Estas Seguro", "ventana de seguridad", 0);
		if (i == 0)
			return true;
		else
			return false;

	}

	public TableModel getAlumnosByTutor(String user) {
		return miModelo.getAlumnosTutor(user);
	}

	public String getCodigoGrupo(String nomgrupo) {
		return miModelo.getCodigoGrupo(nomgrupo);
	}

	public DefaultTableModel getAlumnosByGrupoYAño(String user, String codigoGrupo, String año) {
		return miModelo.getAlumnosByGrupoYAño(user, codigoGrupo, año);
	}

	public DefaultTableModel getAlumnosByTutorYaño(String user, String año) {

		return miModelo.getAlumnosByTutorYaño(user, año);
	}

//	public int closeAplication(Component parentComponent) {
//		int i = JOptionPane.showConfirmDialog(parentComponent, "¿Quiere cerrar la aplicacion?", "ventana de cierre", 0);
//		System.out.println(JFrame.EXIT_ON_CLOSE);
//		return JFrame.EXIT_ON_CLOSE;
//
//	}

}
