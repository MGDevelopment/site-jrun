package com.tmk.soa.dao.interfaces;

import java.util.Map;

public interface ArcashDAO {
	/**
	 * verifica el estado de la orden si esta o no aprobada para mostraro  no el formulario
	 * de pago de arcash
	 * @param idOrden
	 * @return
	 * @throws Exception
	 */
	public int getEstadoOrdenById(String idOrden)throws Exception;
	
	public void enviarMail(Map<String,String> datos)throws Exception;
	
	public String getLinkDeFormulario(Map<String,String> datos)throws Exception;
}
