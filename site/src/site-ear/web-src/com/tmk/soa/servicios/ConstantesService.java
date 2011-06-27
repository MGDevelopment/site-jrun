package com.tmk.soa.servicios;

import java.util.HashMap;

import com.tmk.kernel.Globals;

public class ConstantesService {
	private HashMap<String, HashMap<String, String>> estrellas = new HashMap<String, HashMap<String, String>>(2,1) ;
	public Integer[] index = new Integer[6];	
	private static ConstantesService instance = new ConstantesService();	
	public final static String ESTRELLAS_CHICAS = "estrellasChicas";
	public final static String ESTRELLAS_GRANDES = "estrellasGrandes";
	private ConstantesService(){
		HashMap<String, String> aux = new HashMap<String, String>(3,1);
		aux.put("estrellaLlena","dInfoCalifStar");
		aux.put("estrellaMedia","dInfoCalifStarMed");
		aux.put("estrellaDes","dInfoCalifStarDes");		
		estrellas.put(ESTRELLAS_GRANDES, aux);
		
		aux = new HashMap<String, String>(3,1);		
		aux.put("estrellaLlena","calificacionStar");
		aux.put("estrellaMedia","calificacionStarMed");
		aux.put("estrellaDes","calificacionStarDes");
		estrellas.put(ESTRELLAS_CHICAS, aux);
		
		//usado en el el comparador por categoria_seccion, necesario para la mesa de home
		index[Globals.SECCION_LIBRO] = 0;
		index[Globals.SECCION_MUSICA] = 1;
		index[Globals.SECCION_PELICULA] = 2;
		index[Globals.SECCION_JUGUETES] = 3;
	}
	
	public static  ConstantesService getInstance() {
		return instance;
	}
	public HashMap<String,String> getEstrellas(String tamanoDeEstrella) {
		return estrellas.get(tamanoDeEstrella);
	}	
}
