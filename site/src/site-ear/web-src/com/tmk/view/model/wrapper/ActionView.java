package com.tmk.view.model.wrapper;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.tmk.dbo.comparador.ComparadorPorDefecto;

public class ActionView {

	private String funcion;
	private String descripcion;	
	//ordenados por si necesitamos generar funcion
	private SortedMap <String,String>  parametros;
	private boolean estaActivo;//indica si se puede clickear
	private boolean estaSeleccionado;//indica tiene algun recuadro sobre el texto
	
	public ActionView(String descripcion) {
		this.descripcion = descripcion;
		this.estaActivo = false;
		this.estaSeleccionado = false;
		parametros = new TreeMap<String, String>();
	}
	
	public String buildHref(){
		StringBuffer strParam = new StringBuffer();
		Iterator itNombres = parametros.keySet().iterator();
		
		while(itNombres.hasNext()) {
			strParam.append("&");
			String clave = (String)itNombres.next();
			strParam.append(clave).append("=").append(parametros.get(clave));
		}		
		
		return (strParam.length() > 0 ) ?  
				(funcion + "?" + strParam.substring(1, strParam.length())) : 
					funcion;		
	}
	
	public String buildJsFuncion() {
		//javascript:mostrarBuscarPor('optBus3','optBusqueda','listaBuscador','0','4','En Musica');
		//javascript:buscador_setBusqueda('En Libros','almanaque','0','1','En Libros');
		StringBuffer funcion = new StringBuffer("javascript:");
		funcion.append(this.funcion);
		funcion.append("(");
		Iterator<String> itNombres = parametros.keySet().iterator();
		while(itNombres.hasNext()) {
			String clave = itNombres.next();
			funcion.append("'");
			funcion.append(parametros.get(clave));
			funcion.append("',");
		}		
		funcion = new StringBuffer(funcion.toString().substring(0,funcion.length()-1));
		funcion.append(");");
		return funcion.toString();
	}

	public void addParametros(String nombre, String valor) {
		this.parametros.put(nombre, valor);
	}

	public boolean isEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public boolean estaSeleccionado() {
		return estaSeleccionado;
	}

	public void setEstaSeleccionado(boolean estaSeleccionado) {
		this.estaSeleccionado = estaSeleccionado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SortedMap<String, String> getParametros() {
		return parametros;
	}

	public void setParametros(SortedMap<String, String> parametros) {
		this.parametros = parametros;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	
	public void addParametros(Map<String, String> map) {
		this.parametros.putAll(map);
	}

	/**
	 * creado para mostrar las decipciones cortas de los criterios de busquedas
	 * convierte por ej: Precio Venta + costosos en "+Costoso"
	 * @param descripcionOriginal
	 * @param SortedMap parametros
	 * @return
	 */
	public static String getDescripcionOpcional(String descripcionOriginal,SortedMap parametros) {
		if(parametros.containsKey("criterioDeOrden")) {
			Integer clave = Integer.parseInt((String)parametros.get("criterioDeOrden"));
			switch(clave.intValue()) {
				case 0: return "(A-Z)";
				case 1: return "(Z-A)";
				case 2: return "+ Recientes";
				case 3: return "+ Antiguos";
				case 4: return "+ Económicos";
				case 5: return "+ Costosos";
				default : return "+ Vendidos";
			}
		}else {
			return descripcionOriginal;
		}
	}	
	
}
