package com.tmk.service.comentario;

import com.tmk.bus.comentario.ComentarioArticulos;

public final class ComentarioService {
	
	/** 
	 * @param ComentarioArticulos[]
	 * @return int promedio de evaluacion de comentarios 
	*/	
	public static double getCalificacion(ComentarioArticulos[] comentarioArticulos) {
		if(comentarioArticulos == null)
			return 0;
		
		int canTotal = 0;
		int i;
		for(i = 0;i <  comentarioArticulos.length; i++ ) {
			canTotal += comentarioArticulos[i].getEvaluacion().intValue();
		}
		return (double)canTotal / i;				
	}
}
