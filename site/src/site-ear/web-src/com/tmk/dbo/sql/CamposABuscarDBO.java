package com.tmk.dbo.sql;

import java.util.HashSet;

public class CamposABuscarDBO extends HashSet {
	public CamposABuscarDBO () {
		super();
	}

	public void agregarCampoABusqueda(String campo){
		this.add(campo.toLowerCase());
	}

	public void agregarCampoABusqueda(String[] campos){
		//this.add(campo.toLowerCase());
		for(int i=0;i<campos.length;i++){
			this.add(campos[i].toLowerCase());	
		}
	}
	
	public boolean incluirEnBusqueda(String campo) {
		return this.contains(campo.toLowerCase());
	}
}
