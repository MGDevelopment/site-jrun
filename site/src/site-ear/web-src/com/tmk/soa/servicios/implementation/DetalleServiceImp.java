package com.tmk.soa.servicios.implementation;

import java.util.Hashtable;
import java.util.Vector;

import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.servicios.interfaces.DetalleService;

public class DetalleServiceImp implements DetalleService {

	public String getTemplate(Articulo articulo,String path) throws Exception{
		return DAOFactory.getDetalleDAO().getDatosDetalle(articulo,path);
	}

	/**
	 * Cara en un Vector los autores
	 * tiene seteado el nombre del autor y link de busqueda para ese autor  
	 */
	public Vector<Hashtable<String, Object>> getAutores(Object autores) {		
		Articulo articulo = (Articulo)autores;
		Vector<Hashtable<String, Object>> vecAutores = new Vector<Hashtable<String, Object>>(articulo.getArticuloAutor().length);
		articulo.setUrlBusquedaAutor();// seteo la url como en GetArticuloByIDnvl1,
		for (int j = 0; j < articulo.getArticuloAutor().length; j++) {
			Hashtable<String, Object> hashAutores = new Hashtable<String, Object>();
			hashAutores.put("autor", Convert.nombrePropio(articulo.getArticuloAutor()[j].getAutor().getNombre(
					articulo.getCategoria_seccion()), false));
			hashAutores.put("urlAutor", articulo.getArticuloAutor()[j].getAutor().getCls_urlBusqueda());
			vecAutores.add(hashAutores);
		}
		return vecAutores;
	}
	
	
}
