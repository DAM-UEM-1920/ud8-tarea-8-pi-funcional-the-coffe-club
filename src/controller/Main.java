package controller;

import javax.swing.Icon;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.HistoricoAlumnos;
import Ventanas.Historico_Tutor;
import Ventanas.IniTutor;
import Ventanas.Login;
import Ventanas.MenuDirector;
import Ventanas.Tutores;
import Ventanas.buscarEmpresa;
import Ventanas.Opciones;
import Ventanas.Registro;
import Ventanas.Empresa;
import model.Modelo;


public class Main {
	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo();
		Login miLogin = new Login();
		IniTutor menuTutor = new IniTutor();
		MenuDirector menuAdmin = new MenuDirector();
		Tutores tutores = new Tutores();
		HistoricoAlumnos miHistoricoAlumnos = new HistoricoAlumnos();
		Historico_Tutor miHistoricoTutor = new Historico_Tutor();
		AsignarGrupo asgGrupo = new AsignarGrupo();
		AsignarEmpresa asgEmpresa = new AsignarEmpresa();
		Alumno alumno = new Alumno();
		buscarEmpresa buscEmpresa = new buscarEmpresa();
		Empresa empresa = new Empresa();
		Opciones opciones = new Opciones();
		Registro registro = new Registro();

		miControlador.setModelo(miModelo);
		miControlador.setLogin(miLogin);
		miControlador.setAlumno(alumno);
		miControlador.setAsgEmpresa(asgEmpresa);
		miControlador.setAsgGrupo(asgGrupo);
		miControlador.setMenuAdmin(menuAdmin);
		miControlador.setMenuTutor(menuTutor);
		miControlador.setHistoricoAlumnos(miHistoricoAlumnos);
		miControlador.setHistoricoTutor(miHistoricoTutor);
		miControlador.setTutores(tutores);
		miControlador.setBuscarEmpresa(buscEmpresa);
		miControlador.setEmpresa(empresa);
		miControlador.setOpciones(opciones);
		miControlador.setRegistro(registro);


		miModelo.setLogin(miLogin);
		miModelo.setAlumno(alumno);
		miModelo.setAsgEmpresa(asgEmpresa);
		miModelo.setAsgGrupo(asgGrupo);
		miModelo.setMenuAdmin(menuAdmin);
		miModelo.setMenuTutor(menuTutor);
		miModelo.setMiHistoricoAlumnos(miHistoricoAlumnos);
		miModelo.setMiHistoricoTutor(miHistoricoTutor);
		miModelo.setTutores(tutores);
		miModelo.setBuscarEmpresa(buscEmpresa);
		miModelo.setEmpresa(empresa);
		miModelo.setOpciones(opciones);
		miModelo.setRegistro(registro);

		
		
		empresa.setControlador(miControlador);
		empresa.setModelo(miModelo);
		miLogin.setControlador(miControlador);
		miLogin.setModelo(miModelo);
		menuTutor.setControlador(miControlador);
		menuTutor.setModelo(miModelo);
		menuAdmin.setControlador(miControlador);
		menuAdmin.setModelo(miModelo);
		tutores.setControlador(miControlador);
		tutores.setModelo(miModelo);
		miHistoricoAlumnos.setControlador(miControlador);
		miHistoricoAlumnos.setModelo(miModelo);
		miHistoricoTutor.setControlador(miControlador);
		miHistoricoTutor.setModelo(miModelo);
		asgGrupo.setControlador(miControlador);
		asgGrupo.setModelo(miModelo);
		asgEmpresa.setControlador(miControlador);
		asgEmpresa.setModelo(miModelo);
		alumno.setControlador(miControlador);
		alumno.setModelo(miModelo);
		buscEmpresa.setControlador(miControlador);
		buscEmpresa.setModelo(miModelo);
		opciones.setControlador(miControlador);
		opciones.setModelo(miModelo);
		registro.setModelo(miModelo);
		registro.setControlador(miControlador);

		miLogin.setVisible(true);
		
	}
}
