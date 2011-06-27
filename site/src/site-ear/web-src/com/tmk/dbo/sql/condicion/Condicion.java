package com.tmk.dbo.sql.condicion;

public class Condicion {//n extends HashMap<Condicion, Condicion> {
	private Condicion condIzq = null;	
	private Condicion condDer = null;
	private Operador operador = null;
	private String expIzq = null;
	private String expDer= null;
	private Comparador comparador;
	
	public Condicion(String expIzq,Comparador comparador,String expDer) {
		this.expIzq= expIzq;
		this.expDer= expDer;
		this.comparador = comparador;		
	}
	
	public Condicion(Condicion condIzq, Operador operador, Condicion condDer ) {
		this.condIzq = condIzq;
		this.condDer = condDer;
		this.operador = operador;
	}
	
	
	public Condicion (Operador operador, Condicion condicion){
		this.condDer = condicion;
		this.operador = operador;
		
	}		
	
	public String toString() {
		StringBuffer retorno = new StringBuffer();		
		
		if(expIzq != null) {
			retorno.append(this.expIzq);			
		} else {
			if(condIzq != null) {
				retorno.append("(").append(this.condIzq.toString());
			}
		}
		retorno.append(" ").append((this.operador!=null) ? this.operador:this.comparador).append(" ");
		if(expDer != null) {
			retorno.append(this.expDer);			
		} else {
			retorno.append(this.condDer.toString()).append( (condIzq!=null) ? ")" : "");
			
		}
	
		return retorno.toString();
	}

	
}
