package com.tmk.soa.dao.interfaces;

import com.tmk.bus.articulo.Articulo;
import com.tmk.util.HTML.Template;

public interface DetalleDAO {
	
	public String getDatosDetalle(Articulo articulo,String articulos) throws Exception;
	
	/**
	 * Setea todos los datos en la template para el detalle.
	 * @param Articulo
	 * @param tmpListaArticulo
	 */	
	public void setListaArticulo(Articulo articulo,Template tmpListaArticulo);
		
}
