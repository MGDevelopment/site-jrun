package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;

public class ComparadorPorFechaInverso implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		int comparacion = ((Articulo)o2).getFechaAlta().compareTo(((Articulo)o1).getFechaAlta())*(-1);
		return (comparacion==0)?1:comparacion;			
	} 
}
