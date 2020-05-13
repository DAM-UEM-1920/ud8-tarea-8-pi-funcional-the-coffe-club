package model;

import java.io.Serializable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Tablas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columnas;
	private int filas;
	private String nombre;
	private DefaultTableModel tabla;
	private String user;


	public Tablas(DefaultTableModel tabla) {
		super();
		this.tabla = tabla;
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


	public DefaultTableModel getTabla() {
		return tabla;
	}


	public void setTabla(DefaultTableModel tabla) {
		this.tabla = tabla;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	

}
