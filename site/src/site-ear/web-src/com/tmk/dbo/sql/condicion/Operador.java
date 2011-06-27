package com.tmk.dbo.sql.condicion;

public class Operador {
	public static Operador AND;
	public static Operador OR;
	
	static {  
		AND = new Operador("and");
		OR = new Operador("OR");		
	};
	
	private String operador;
	
	private Operador(String operador){
		this.operador = operador;
	}

	public String toString() {		
		return operador; 
	}
	
}
