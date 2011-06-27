package com.tmk.service.buscador;

import com.tmk.kernel.Globals; 
 
public class InfoBuscador {
	public static final int CONSULTAS_OK = 0;
	public static final int CONSULTAS_SIN_RESULTADO = 1;
	public static final int CONSULTAS_TIMEOUT = 2;
	public static final int CONSULTAS_ERROR = 3;
	
	private int [] consultasXTiempo = new int[(BusquedaGenerica.SEGUNDOS_TIMEOUT * Globals.SECCIONES.length) + 1];
	private int [] registro = new int[4];
	private String nombre;
	
	public InfoBuscador(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void sumCantidadConsulta(int consulta) {
		registro [consulta]++;
	}
	
	public void resCantidadConsulta(int consulta) {
		registro [consulta]--;
	}
	
	public int getCantidadConsulta(int consulta) {
		return registro[consulta];
	}
	
	public int getTotal() {
		int total = 0;
		for (int i=0; i<registro.length; i++) {
			total += registro[i];
		}
		return total;
	}
	
	public static String getNombreDeValor(int consulta) {
		switch (consulta) {
			case CONSULTAS_OK: return "Correctas";
			case CONSULTAS_SIN_RESULTADO: return "Sin resultado";
			case CONSULTAS_TIMEOUT: return "Timeout";
			case CONSULTAS_ERROR: return "Error";
			default: return "NO DEFINIDO";
		}
	}
	
	public int getTamanioRegistro() {
		return registro.length;
	}
	
	public void setTiempo(int tiempo) {
		if (tiempo >= 0) {
			consultasXTiempo[tiempo]++;
		}
	}
	
	public int[] getConsultasXTiempo() {
		return consultasXTiempo;
	}
}