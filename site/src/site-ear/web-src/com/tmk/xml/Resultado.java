package com.tmk.xml;

import java.util.Vector;

public class Resultado {
	private boolean valor;
	private String [] mensaje;
	private String [] campo;
	private String [] aux;
	private String targetRedirect;
	private boolean fallaSistema;
	private Vector respuesta;

	public Resultado(boolean valor, String mensaje[], String campo[]) {
		this.valor = valor;
		this.mensaje = mensaje;
		this.campo = campo;
	}

	public void setAux(String [] aux ) {
		this.aux = aux;
	}

	public void setTargetRedirect(String targetRedirect) {
		this.targetRedirect = targetRedirect;
	}

	public void setFallaSistema(boolean fallaSistema) {
		this.fallaSistema = fallaSistema;
	}

	public void setRespuesta(Vector respuesta){
		this.respuesta = respuesta;
	}
	public boolean getFallaSistema() {
		return this.fallaSistema;
	}
	public boolean getValor() {
		return this.valor;
	}
}
