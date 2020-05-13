package model;

import java.io.Serializable;

import javax.swing.JTable;

public class Tablas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columnas;
	private int filas;
	private String nombre;
	private JTable tabla;
	private String user;


	public Tablas(int columnas, int filas, String nombre, JTable tabla, String user) {
		super();
		this.columnas = columnas;
		this.filas = filas;
		this.nombre = nombre;
		this.tabla = tabla;
		this.user = user;
	}


	public int getColumnas() {
		return columnas;
	}


	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}


	public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public JTable getTabla() {
		return tabla;
	}


	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	

}
