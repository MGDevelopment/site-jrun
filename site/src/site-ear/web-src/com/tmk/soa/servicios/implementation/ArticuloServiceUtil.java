package com.tmk.soa.servicios.implementation;

import com.tmk.bus.categoria.Categoria;
import com.tmk.controllers.buscador.BuscadorHelper;
import com.tmk.controllers.buscador.BusquedaPorCategorias;

/***
 * Encapsula metodos utiles para resolver cuestiones relacionadas<br>
 * con artiuclo como :
 * obtener si es productora, editorial o interprete.
 * etc...
 * @author oclopez
 *
 */

public class ArticuloServiceUtil {
	/**
	 * Devuelve para cada seccion que le corresponde si es:
	 * <pre>
	 * 		Editorial para libros
	 * 		Productora para peliculas
	 * 		Interprete para musica
	 * 	</pre>	
	 */
	public static String getDescripcionXSeccion(Integer idSeccion) {		
		String valor = "";
		switch(idSeccion) {
			case 1: valor = "Editorial"; break;
			case 5: valor = "Productora";break;
			case 3: valor = "Editorial";break;
			//case 4: valor = "Interprete";break;
			case 4: valor = "Sello discogr&aacute;fico";break;
		}
		return valor;
	}
	
	public static String getPaginaXSeccion(Integer idSeccion) {
		String valor = "";
		switch(idSeccion) {
			case 1: valor = "Paginas"; break;
			case 3: valor = "Paginas";break;
			case 5: valor = "Duraci&oacute;n";break;
			//case 3: valor = "Editorial";break;
			//case 4: valor = "Interprete";break;
		}
		return valor;
	}

	public static String gerUrl(Categoria cat) {
		String url = "";
		if(cat.getCategoriaPK().getPK().length == 2) {
			BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
					cat.getDescripcion(), 
					cat.getCategoriaPK().getPK()[0],
					cat.getCategoriaPK().getPK()[1], 
					(Integer) null,
					(Integer) null, 
					new Integer(1),
					new Integer(10),
					BuscadorHelper.CRIT_MAS_VENDIDOS, 
					false
			);
			url = busquedaPorCategoria.salto().toString();
		}
		if(cat.getCategoriaPK().getPK().length == 3) {
			BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
					cat.getDescripcion(), 
					cat.getCategoriaPK().getPK()[0],
					cat.getCategoriaPK().getPK()[1], 
					cat.getCategoriaPK().getPK()[2],
					(Integer) null, 
					new Integer(1),
					new Integer(10),
					BuscadorHelper.CRIT_MAS_VENDIDOS, 
					false
			);
			url = busquedaPorCategoria.salto().toString();
		}
		if(cat.getCategoriaPK().getPK().length == 4) {
			BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
					cat.getDescripcion(), 
					cat.getCategoriaPK().getPK()[0],
					cat.getCategoriaPK().getPK()[1], 
					cat.getCategoriaPK().getPK()[2],
					cat.getCategoriaPK().getPK()[3], 
					new Integer(1),
					new Integer(10),
					BuscadorHelper.CRIT_MAS_VENDIDOS, 
					false
			);
			url = busquedaPorCategoria.salto().toString();
		}
		return url;
	}
}
