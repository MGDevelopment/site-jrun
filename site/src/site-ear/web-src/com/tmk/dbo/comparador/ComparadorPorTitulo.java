package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;

public class ComparadorPorTitulo implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		int comparacion = ((Articulo)o1).getTitulo().compareTo(((Articulo)o2).getTitulo());
		return (comparacion==0)?1:comparacion;
	} 
}
