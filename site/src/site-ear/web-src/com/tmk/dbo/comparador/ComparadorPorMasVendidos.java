package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.articulo.Articulo;
import com.tmk.dbo.DBO;

public class ComparadorPorMasVendidos implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		if(null!=((Articulo)o1).getMasVendidoSeccion() && null!=((Articulo)o2).getMasVendidoSeccion()) {
			int comparacion = ((Articulo)o1).getMasVendidoSeccion().getMasVendidoOrden().compareTo(((Articulo)o2).getMasVendidoSeccion().getMasVendidoOrden());			
			return (comparacion==0)?1:comparacion;
		}
		return 1;
	} 
}
