package com.tmk.xml.dm.ipn.consulta;

public class Consulta {
	String clave;
	Integer tipo;
	Id[] operaciones;
	
	public Consulta (String clave, Integer tipo, Id[] operaciones) {
		this.clave = clave;
		this.tipo = tipo;
		this.operaciones = operaciones;
	}
}
