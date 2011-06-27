package com.tmk.dbo.sql;

import java.util.Vector;

import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;

public class WhereDBO {	
	private Vector<Condicion> condiciones = null;
	private int cantidadABuscar;
	
	public void add(Condicion condicion) {		
		this.condiciones.add(condicion);
	}
	
	public void add(Operador operador, Condicion condicion) {		
		this.condiciones.add(new Condicion(operador, condicion));
	}
	
	public WhereDBO() {
		condiciones = new Vector<Condicion>();
	}
				
	public String toString() {
		if(condiciones.size() == 0) {
			return "";
		}
		StringBuffer where = new StringBuffer("(");
		for(int i=0; i< condiciones.size();i++) {
			where.append(condiciones.get(i).toString());
		}
		return where.append(")").toString();
	}
	
	public int getCantidadABuscar() {
		return cantidadABuscar;
	}

	public void setCantidadABuscar(int cantidadABuscar) {
		this.cantidadABuscar = cantidadABuscar;
	}
	
	
}
