package controller;

import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
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
		int anio = LocalDate.now().getYear();
		if (mes < 8) {
			return String.valueOf(anio - 1) + "/" + String.valueOf(anio);
		} else
			return String.valueOf(anio) + "/" + String.valueOf(anio + 1);

	}

//	public DefaultTableModel cargarFichero(File fichero) {
//		return miModelo.cargarObjeto(fichero);
//
//	}

//	public void guardarObjetoTutor(String user) {
//		miModelo.guardarObjetoTutor(user);
//
//	}
//
//	public void guardarObjetoTutorYGrupo(String user, String grupo) {
//		miModelo.guardarObjetoTutorYGrupo(user, grupo);
//
//	}

//	public void guardarObjeto(String tabla) {
//		miModelo.guardarObjeto(tabla);
//
//	}

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

	public String[] getAnios() {
		String[] aniosAcad = new String[10];
		int mes = LocalDate.now().getMonthValue();
		int anio = LocalDate.now().getYear();
		for (int i = 0; i < aniosAcad.length; i++) {
			if (mes < 6) {
				aniosAcad[i] = String.valueOf(anio - i - 1) + "/" + String.valueOf(anio - i);
			} else {
				aniosAcad[i] = String.valueOf(anio - i) + "/" + String.valueOf(anio - i + 1);
			}
		}

		return aniosAcad;

	}

	public DefaultTableModel getAlumnosByGrupo(String user, String grupo) {
		return miModelo.getAlumnosByGrupo(user, grupo);

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

	public DefaultTableModel getAlumnosByGrupoYAnio(String user, String codigoGrupo, String anio) {
		return miModelo.getAlumnosByGrupoYAnio(user, codigoGrupo, anio);
	}

	public DefaultTableModel getAlumnosByTutorYanio(String user, String anio) {

		return miModelo.getAlumnosByTutorYanio(user, anio);
	}

//	public int closeAplication(Component parentComponent) {
//		int i = JOptionPane.showConfirmDialog(parentComponent, "�Quiere cerrar la aplicacion?", "ventana de cierre", 0);
//		System.out.println(JFrame.EXIT_ON_CLOSE);
//		return JFrame.EXIT_ON_CLOSE;
//
//	}

}
