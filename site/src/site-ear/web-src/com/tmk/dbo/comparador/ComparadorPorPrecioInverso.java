package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;

public class ComparadorPorPrecioInverso implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		int comparacion = (new Double(((Articulo)o1).getPrecio()).compareTo(new Double(((Articulo)o2).getPrecio())))*(-1);
		return (comparacion==0)?1:comparacion;	
	} 
}
