package com.tmk.dbo.sql;

import java.util.HashSet;
import java.util.Iterator;

public class OrderBYDBO extends HashSet {
	public OrderBYDBO () {
		super();
	}

	public void agregarCampoAOrden(String campo){
		this.add(campo.toLowerCase());
	}

	public boolean incluirEnOrden(String campo) {
		return this.contains(campo.toLowerCase());
	}
	
	public String aString() {
		StringBuffer orden = new StringBuffer("");
		Iterator it = this.iterator();
		while(it.hasNext()) {
			orden.append(it.next().toString()).append(",");
		}
		return orden.toString().substring(0,orden.length()-1);
	}
}
