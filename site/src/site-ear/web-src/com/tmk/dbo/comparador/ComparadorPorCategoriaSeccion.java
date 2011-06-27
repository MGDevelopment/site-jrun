package com.tmk.dbo.comparador;

import java.util.Comparator;

import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.dbo.DBO;
import com.tmk.soa.servicios.ConstantesService;

public class ComparadorPorCategoriaSeccion implements Comparator<DBO> {
	public int compare(DBO o1, DBO o2) {
		
		Integer a = ((ComentarioArticulos)o1).getArticulo().getCategoria_seccion();
		Integer b=  ((ComentarioArticulos)o2).getArticulo().getCategoria_seccion();
		
		int compararacion =  ConstantesService.getInstance().index[a].compareTo(ConstantesService.getInstance().index[b]);
		return compararacion == 0 ? 1 : compararacion; 
	} 
}
