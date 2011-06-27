package com.tmk.soa.servicios.interfaces;

import java.util.Map;

import com.tmk.orden.OrdenDAO;

public interface ArcashService {
	
	public int estadoDeOrden(String idOrden) throws Exception;
	
	public void enviarMail(Map<String, String> datosCliente) throws Exception;
	
	public String getPathArash();
	
	public String getToken(OrdenDAO ordenDao,String token);
	
	public String getIdMerchant();
	
	public String getPasword();
	
	public String getLogoArcash();
	
	public String getLinkDeFormulario(Map<String,String>datosFormulario);
	
	public String getLinkDePagoArcash();
}
