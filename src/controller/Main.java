package controller;

import Ventanas.Alumno;
import Ventanas.AsignarEmpresa;
import Ventanas.AsignarGrupo;
import Ventanas.BusquedaPersonalizada;
import Ventanas.IniTutor;
import Ventanas.Login;
import Ventanas.MenuDirector;
import Ventanas.Tutores;
import Ventanas.buscarEmpresa;
import model.Modelo;


public class Main {
	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo();
		Login miLogin = new Login();
		IniTutor menuTutor = new IniTutor();
		MenuDirector menuAdmin = new MenuDirector();
		Tutores tutores = new Tutores();
		BusquedaPersonalizada miBusqueda = new BusquedaPersonalizada();
		AsignarGrupo asgGrupo = new AsignarGrupo();
		AsignarEmpresa asgEmpresa = new AsignarEmpresa();
		Alumno alumno = new Alumno();
		buscarEmpresa buscEmpresa = new buscarEmpresa();

		miControlador.setModelo(miModelo);
		miControlador.setLogin(miLogin);
		miControlador.setAlumno(alumno);
		miControlador.setAsgEmpresa(asgEmpresa);
		miControlador.setAsgGrupo(asgGrupo);
		miControlador.setMenuAdmin(menuAdmin);
		miControlador.setMenuTutor(menuTutor);
		miControlador.setBusqueda(miBusqueda);
		miControlador.setTutores(tutores);
		miControlador.setBuscarEmpresa(buscEmpresa);

		miModelo.setLogin(miLogin);
		miModelo.setAlumno(alumno);
		miModelo.setAsgEmpresa(asgEmpresa);
		miModelo.setAsgGrupo(asgGrupo);
		miModelo.setMenuAdmin(menuAdmin);
		miModelo.setMenuTutor(menuTutor);
		miModelo.setMiBusqueda(miBusqueda);
		miModelo.setTutores(tutores);
		miModelo.setBuscarEmpresa(buscEmpresa);

		miLogin.setControlador(miControlador);
		miLogin.setModelo(miModelo);
		menuTutor.setControlador(miControlador);
		menuTutor.setModelo(miModelo);
		menuAdmin.setControlador(miControlador);
		menuAdmin.setModelo(miModelo);
		tutores.setControlador(miControlador);
		tutores.setModelo(miModelo);
		miBusqueda.setControlador(miControlador);
		miBusqueda.setModelo(miModelo);
		asgGrupo.setControlador(miControlador);
		asgGrupo.setModelo(miModelo);
		asgEmpresa.setControlador(miControlador);
		asgEmpresa.setModelo(miModelo);
		alumno.setControlador(miControlador);
		alumno.setModelo(miModelo);
		buscEmpresa.setControlador(miControlador);
		buscEmpresa.setModelo(miModelo);
		

		miLogin.setVisible(true);

	}
}
