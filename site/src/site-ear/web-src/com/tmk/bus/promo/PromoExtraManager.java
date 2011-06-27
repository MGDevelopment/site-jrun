package com.tmk.bus.promo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmk.controllers.MainHelper;
import com.tmk.controllers.filter.ExistInTableFilter;
import com.tmk.controllers.filter.FilterManager;
import com.tmk.controllers.filter.PurchaseAddressFilter;
import com.tmk.controllers.filter.PurchaseValueFilter;
import com.tmk.controllers.filter.DateFilter;
import com.tmk.controllers.filter.SocioFidelizadoFilter;
import com.tmk.orden.OrdenDAO;
import com.tmk.service.orden.OrdenService;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.bus.promo.PromoExtraManager;



public final class PromoExtraManager  {
	private static int valorMinimoPromoVC = 50;
	//promo VC para todo el pais excepto provincia
	private static Integer idPais = new Integer(Globals.ARGENTINA.getId()); 
	private static Integer idProvincia = new Integer(411); 
	
	public static boolean calificaPromoVC(OrdenDAO orden, HttpServletRequest request, HttpServletResponse response) {
		boolean retorno = false;
		
		StringBuffer cabecera = new StringBuffer();
		cabecera.append("com.tmk.bus.promo.PromoExtraManager.calificaPromoVC").append("(idOrden=").append(orden.getIdOrdenProcesada()).append(")]");
		try {
			FilterManager filterManager = new FilterManager();
			filterManager.addFilter(new PurchaseValueFilter(valorMinimoPromoVC, orden));
			filterManager.addFilter(new DateFilter("13/08/2007", "24/09/2007"));
			filterManager.addFilter(new PurchaseAddressFilter(idPais, (Integer)null, (Integer)null, orden, MainHelper.CONST_DOMICILIO_FACTURACION, false));
			filterManager.addFilter(new PurchaseAddressFilter(idPais, idProvincia, (Integer)null, orden, MainHelper.CONST_DOMICILIO_FACTURACION, true));
			filterManager.addFilter(new ExistInTableFilter("cupon_respuestas", "id_orden=" + orden.getIdOrdenProcesada(), true));
			filterManager.executeFilters(request, response);
			retorno = filterManager.getFiltersState();
		} catch (Exception e) {
			TmkLogger.error(cabecera.toString() + " " + e.toString() + MainHelper.getMessage(e));
			MainHelper.enviarMailDeError(cabecera.toString() + " " + e.toString() + MainHelper.getMessage(e));
		}
		return retorno;
	}
	
	
	public static boolean aplicarPormoVC(Integer idOrden, String respuesta1, String respuesta2, 
			String respuesta3, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean retorno = false;
		OrdenDAO orden = OrdenService.cargarOrden(idOrden.intValue());
			if (calificaPromoVC(orden, request, response)) {
				int cupon = new Double(orden.totalSitioCompleto()/valorMinimoPromoVC).intValue();
				SocioFidelizadoFilter socioFidelizadoFilter = new SocioFidelizadoFilter();
				socioFidelizadoFilter.execute(request, response);
				if (socioFidelizadoFilter.isSuccess()) {
					cupon = cupon * 2;
				}
				Connection conn = DBUtil.buildConnection();
				try {
					CuponRespuestasClass cuponRespuestas = new CuponRespuestasClass();
					cuponRespuestas.setCantidadCupones(new Integer(cupon));
					cuponRespuestas.setIDOrden(idOrden);
					cuponRespuestas.setRespuesta1(respuesta1);
					cuponRespuestas.setRespuesta2(respuesta2);
					cuponRespuestas.setRespuesta3(respuesta3);
					grabarCuponRespuestas(cuponRespuestas, conn);
					retorno = true;
				} finally {
					conn.close();
				}
			}	
		
		
		return retorno;
	}
	
	public static void grabarCuponRespuestas(CuponRespuestasClass cuponRespuestas, Connection conn) throws Exception {
		PreparedStatement ps = MainHelper.getInsertToDBByObject(cuponRespuestas, "cupon_respuestas", conn);
		try {
			ps.execute();
			TmkLogger.info("CUPON RESPUESTAS GRABADO");
		} finally {
			ps.close();
		}
	}

}
