package com.tmk.soa.servicios.interfaces;

import java.util.Collection;

import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.src.socio.SocioPK;

public interface SocioDomiciliosService {
	public final static String TIPO_FACTURACION = "";
	public final static String TIPO_ENVIO = "";
	
	public Collection getDomiciliosByPkSocio(SocioPK socioPk);
	
	public String getDireccionFormateada (SocioDomicilios domicilio);
	
	public Collection findByTipoEnvio (SocioPK socioPk);
	
	public Collection findByTipoFacturacion (SocioPK socioPk);
	
	public SocioDomicilios getByPKYTipoDomicilio (SocioPK socioPk,String tipoDomicilio);
	
	
}
