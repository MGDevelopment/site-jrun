package com.tmk.dbo.sql;

import java.util.HashMap;
import java.util.Map;

import com.tmk.bus.listas.ListasTmk;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.bus.orden.EstadoOrden;
import com.tmk.bus.orden.ItemOrden;
import com.tmk.bus.orden.NivelDeRiesgo;
import com.tmk.bus.orden.Orden;
import com.tmk.bus.orden.PagoOrden;
import com.tmk.bus.socio.Socios2;

public class RelacionCamposInsertDBO {

	private static RelacionCamposInsertDBO relaciones = new RelacionCamposInsertDBO();
	private HashMap<String, String[]> camposInsert = null;
	private Map<String,String> camposCambiados = null;
	private RelacionCamposInsertDBO() {
		camposInsert = new HashMap<String, String[]>();
		//camposInsert.put(Orden.class.getSimpleName()+"-"+ItemOrden.class.getSimpleName(), new String[]{});
		//camposInsert.put(Orden.class.getSimpleName()+"-"+Socios2.class.getSimpleName(), getCampos(Socios2.getCamposPK()));
		//camposInsert.put(Orden.class.getSimpleName()+"-"+EstadoOrden.class.getSimpleName(), getCampos(EstadoOrden.getCamposPK()));
		//camposInsert.put(Orden.class.getSimpleName()+"-"+NivelDeRiesgo.class.getSimpleName(), getCampos(NivelDeRiesgo.getCamposPK()));
		
		camposInsert.put(ListasTmk.class.getSimpleName()+"-"+Socios2.class.getSimpleName(), getCampos(Socios2.getCamposPK()));
		
		//los campos que se que en mi negocio necesitan ser cambiados de nombre cuando se hace el insert
		camposCambiados = new  HashMap<String,String>(3);
		camposCambiados.put("precio_promocion_sin_impue", "precio_promocion_sin_impuestos");
	}
	
	public static RelacionCamposInsertDBO getInstance(){
		return relaciones;
		//return new RelacionCamposInsertDBO();
	}
	
	public String[] getCamosInsert(String relacionDeDBO) {
		return camposInsert.get(relacionDeDBO);
	}
	private String[] getCampos(String[]campos){
		String[] aux = new String[campos.length];
		for(int i=0;i<campos.length;i++) {
			aux[i]=campos[i].split("__")[1];
		}
		return aux;
	}

	public Map<String, String> getCamposCambiados() {
		return camposCambiados;
	}
	
}
