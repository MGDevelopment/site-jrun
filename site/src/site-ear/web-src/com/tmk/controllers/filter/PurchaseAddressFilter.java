package com.tmk.controllers.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.TmkLogger;
import com.tmk.orden.OrdenDAO;

public class PurchaseAddressFilter extends Filter {
	private Integer idPais;
	private Integer idProvincia;
	private Integer idLocalidad;
	private OrdenDAO orden;
	private String tipo;
	private boolean negado;
	
	public PurchaseAddressFilter(Integer idPais, Integer idProvincia, Integer idLocalidad, OrdenDAO orden, String tipo, boolean negado) {
		this.idPais = idPais;
		this.idProvincia = idProvincia;
		this.idLocalidad = idLocalidad;
		this.orden = orden;
		this.negado = negado;
		this.tipo = tipo;
	}

	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws FilterException {
		OrdenDAO orden = (OrdenDAO)request.getSession().getAttribute(MainHelper.SESSION_ORDEN);
		if (orden == null) {
			orden = this.orden;
		}  
		if (orden != null) {
			DomicilioDAO domicilio = null;
			if (tipo.equals(MainHelper.CONST_DOMICILIO_ENVIO)) {
				domicilio = orden.getDomicilioEnvio();
			} else {
				domicilio = orden.getDomicilioFacturacion();
			}
			if (domicilio != null) {
				boolean resultado = true;
				resultado = resultado && new Integer(domicilio.getPais().getId()).equals(idPais);
				resultado = resultado && (idProvincia == null)? true: 
						new Integer(domicilio.getProvincia().getId()).equals(idProvincia);
				resultado = resultado && (idLocalidad == null)? true: 
					new Integer(domicilio.getLocalidad().getId()).equals(idLocalidad);
				resultado = (negado)?!resultado: resultado;
				this.state = (resultado)? SUCCESS: FAILURE;
			}	
		} else {
			this.state = FAILURE;
		}
		TmkLogger.info(toString());
	}

	public String getName() {
		return this.getClass().getName();
	}

}
