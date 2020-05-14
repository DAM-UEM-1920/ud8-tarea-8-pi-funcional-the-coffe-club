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
	private DefaultTableModel tabla;
	


	public Tablas(DefaultTableModel tabla) {
		super();
		this.tabla = tabla;
	}


	public DefaultTableModel getTabla() {
		return tabla;
	}


	public void setTabla(DefaultTableModel tabla) {
		this.tabla = tabla;
	}
	

}
