package com.tmk.soa.servicios.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.util.HTML.Template;

public interface TemplateService {
	/**
	 * Varibale que indica el nombre de la template para ver el carrito de compras 
	 */
	public final String TMP_CARRITO_COMPRAS = "tmpCarrito";
	public final String TMP_PAPEL_DE_REGALO = "tmpPapelDeRegalo";
	/**
	 * Crea una template en base al nombre que recibe por parametros.	 * 
	 * @param nombre
	 * @return Object, debe ser castedo al tipo de template a usar
	 */
	//public Object getTemplate(String nombre) ;
	public Object getTemplate(String nombre) throws FileNotFoundException, IllegalStateException, IOException;
	
	public void setSemplate(CamposABuscarDBO camposAAgregar,Class<?> clase,Object objecto,Template template) throws Exception;
}
