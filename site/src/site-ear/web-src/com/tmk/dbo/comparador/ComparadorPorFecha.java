package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;

public class ComparadorPorFecha implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		int comparacion = ((Articulo)o2).getFechaAlta().compareTo(((Articulo)o1).getFechaAlta());		
		return (comparacion==0)?1:comparacion;			
	} 
}
