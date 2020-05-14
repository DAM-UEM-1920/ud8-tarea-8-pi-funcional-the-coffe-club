package controller;

import java.awt.Checkbox;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.BusquedaPersonalizada;
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
	private BusquedaPersonalizada miBusqueda;
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

	public void setBusqueda(BusquedaPersonalizada miBusqueda) {
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
		tutores.setVisible(true);

	}

	public void personalizadaAtras() {
		miBusqueda.setVisible(false);
		menuAdmin.setVisible(true);

	}

	public void atrasTutores() {
		tutores.setVisible(false);
		menuAdmin.setVisible(true);
	}

	public void busquedaPersonalizada() {
		menuAdmin.setVisible(false);
		miBusqueda.setVisible(true);

	}

	public void personalizadaAtrasTutor() {
		miBusqueda.setVisible(false);
		menuTutor.setVisible(true);

	}

	public void asgGrupo(String dni) {
		tutores.setVisible(false);
		asgGrupo.setdni(dni);
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

	public void personalizadaFin() {
		miBusqueda.setVisible(false);
		menuAdmin.setVisible(true);

	}

	public void buscarEmpre() {
		menuAdmin.setVisible(false);
		buscEmpresa.setVisible(true);

	}

	public void buscarEmpreAtras() {
		buscEmpresa.setVisible(false);
		menuAdmin.setVisible(true);

	}

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
		if (mes < 6) {
			return String.valueOf(año - 1) + "-" + String.valueOf(año);
		} else
			return String.valueOf(año) + "-" + String.valueOf(año + 1);

	}

	public DefaultTableModel cargarFichero(File fichero) {
		return miModelo.cargarObjeto(fichero);
		
	}

	public void guardarObjetoTutor(String user) {
		miModelo.guardarObjetoTutor(user);
		
	}
	
	public int insertar(String tabla, String values) {
		return miModelo.insert(tabla, values);
		
	}
	public void update(String tabla, String valores, String pk, String cod) {
		miModelo.update(tabla, valores, pk, cod);
	}
	
	public int delete (String tabla, String pk, String cod) {
		return miModelo.delete(tabla, pk, cod);
		
	}
	
	public String[] getGrupos(String user) {
		ArrayList<String> grup = miModelo.getGrupos(user);
		String[] grupos = new String[grup.size()];
		for (int i = 0; i < grupos.length; i++) {
			grupos[i] = grup.get(i);
		}
		return grupos;
		
	}

}
