package com.tmk.soa.servicios.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.src.socio.SocioPK;

public class ProcesoCompraUtilImp  {
	private static ProcesoCompraUtilImp instancia = new ProcesoCompraUtilImp();	
	private Map<String, HashMap<String, String>> hashDirecciones = null;
	private List<HashMap<String, Object>> listaDeDatos = null;
	
	/**
	 * Crea el HashMap que contiene como clave la pagina donde esta parada dentro del proceso y
	 * has HashMap como calor donde esta la pagina siguente y la anterior
	 */
	private ProcesoCompraUtilImp() {
		hashDirecciones = new HashMap<String, HashMap<String,String>>();
		HashMap<String, String> direcciones = new HashMap<String, String>(2);
		//carrito
		direcciones.put("anterior",ProcesoCompraUtil.PAGINA_HOME_SITIO);
		direcciones.put("siguiente",ProcesoCompraUtil.PAPEL_REGALO);
		hashDirecciones.put(ProcesoCompraUtil.CARRITO_COMPRAS,direcciones);
		//papel de regalo
		direcciones = new HashMap<String, String>(2);
		direcciones.put("anterior",ProcesoCompraUtil.CARRITO_COMPRAS);
		direcciones.put("siguiente",ProcesoCompraUtil.FORM_ENTREGA);
		hashDirecciones.put(ProcesoCompraUtil.PAPEL_REGALO,direcciones);
		//entrega(domicilios de entrega o facturacion)
		direcciones = new HashMap<String, String>(2);
		direcciones.put("anterior",ProcesoCompraUtil.PAPEL_REGALO);
		direcciones.put("siguiente",ProcesoCompraUtil.MEDIO_DE_PAGO);
		hashDirecciones.put(ProcesoCompraUtil.ENTREGA,direcciones);
		//entrega(domicilios de entrega o facturacion)
		direcciones = new HashMap<String, String>(2);
		direcciones.put("anterior",ProcesoCompraUtil.ENTREGA);
		direcciones.put("siguiente",ProcesoCompraUtil.CONFIRMACION);
		hashDirecciones.put(ProcesoCompraUtil.MEDIO_DE_PAGO,direcciones);
		//vista previa
		direcciones = new HashMap<String, String>(2);
		direcciones.put("anterior",ProcesoCompraUtil.ENTREGA);
		direcciones.put("siguiente",ProcesoCompraUtil.CONFIRMACION);
		hashDirecciones.put(ProcesoCompraUtil.VISTA_PREVIA,direcciones);
		
		//has de datos de tiempo en el proceso de compras
		listaDeDatos = new ArrayList<HashMap<String,Object>>();
	}
	
	public static synchronized ProcesoCompraUtilImp getInstance(){		
		return instancia;
	}
	/**
	 * Retorna un Map<String,String> que indica las pantallas enterior y siguietne en base 
	 * a la que se encuatra. 
	 * @param Srting posicionActual
	 * @return Map<String, String> 
	 */
	public Map<String, String> getDirecciones(String posicionActual) {
		if(instancia==null){
			instancia = new ProcesoCompraUtilImp();
		}
		//instancia = new ProcesoCompraUtilImp();
		return hashDirecciones.get(posicionActual);
	}

	//DECIDE SI UNA ORDEN TIENE UN ARTICULO DE PASATIEMPO FUERA DEL GRUPO GS DEL TIEMPO
	public  boolean tienePasatiempos(OrdenDAO ordenDAO){
		Vector articulos = ordenDAO.getArticulos();
		boolean articuloPasatiempos = false;
        for (int j=0; j<articulos.size() && !articuloPasatiempos; j++) {
        	ArticuloDAO articulo = (ArticuloDAO)articulos.get(j);
        	//si es pasatiempo fuera del grupo gs del tiempo
        	if (articulo.getCategoriaSeccion() == Globals.SECCION_JUGUETES &&
        			articulo.getCategoriaGrupo() != 4) {
        		articuloPasatiempos = true;
        	}
        }	
        return articuloPasatiempos;
	}	
	
	//Metodos necesarios para el reporte de tiempos de compra por usuario
	public List getListaDeTiempoEnProcesoDeCompras() {
		return listaDeDatos;
	}	
	//usa el map que tiene el usario en la sesion 
	public void agregarAlMapa(HashMap<String,Object> mapa, String key,Object value){
		if(!mapa.containsKey(value)) {
			mapa.put(key, value);
		}
	}
	public void guardarLoginConSuMapa(String login,HashMap<String, Object> hashDeDatos) {
		if(hashDeDatos != null || hashDeDatos.size() > 0) {
			listaDeDatos.add(hashDeDatos);
		}
	}
	/**
	 * VALIDA EL PROCESO DE COMPRAS, ORDEN NULA, PK NULA, ORDEN CON CANTIDAD = 0 
	 * @param request
	 * @param response
	 * @param nombreDePagina
	 * @return
	 */
	public String frwRedireccion(HttpServletRequest request,HttpServletResponse response,String nombreDePagina){
		MainHelper.controlDeModo(request, response);
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		Boolean esSocioTMK = ((Boolean)request.getSession().getAttribute("socioTMK"));
		if(esSocioTMK == null) {
			esSocioTMK = new Boolean(false);
		}
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		String frwRedirect = null;
		
		if(ordenDAO == null || socioPK == null) {
			request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
			return "frwMiCuenta";
		}
		
		if(ProcesoCompraUtil.PAPEL_REGALO.equals(nombreDePagina)) {
			//valido orden y usuario
			if(ordenDAO == null || socioPK == null || ordenDAO.getArticulos().size() == 0) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, ProcesoCompraUtil.PAPEL_REGALO);
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwMiCuenta";
			} else if (esSocioTMK) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/papelDeRegalo.do");
				frwRedirect = "frwRegistroSocioCadena";			
			}	
		}else if(ProcesoCompraUtil.ENTREGA.equals(nombreDePagina)) {
			if(ordenDAO == null || socioPK == null || ordenDAO.getCantidadArticulos() == 0) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/domicilio.do");
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwMiCuenta";
			} else if (esSocioTMK) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/domicilio.do");
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwRegistroSocioCadena";	
			}
		}else if(ProcesoCompraUtil.MEDIO_DE_PAGO.equals(nombreDePagina)) {
			if (ordenDAO == null || socioPK == null ||ordenDAO.getArticulos().size() == 0) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/medioDeCobro.do");
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwMiCuenta";
			}else if (esSocioTMK) {
				request.getSession().setAttribute(MainHelper.URL_REDIRECT, "/compra/medioDeCobro.do");
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwRegistroSocioCadena";	
			}
			if(frwRedirect == null) {
				if(ordenDAO.getDomicilioEnvio()== null && ordenDAO.getDomicilioFacturacion() == null){
					request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
					frwRedirect =  "frwDomicilio";
				}
			}
			/*if(frwRedirect == null) {
				//AGREGO CHEQUEO DE DOMICILIO PARA SUSCRIPCION:BLOQUE PARA CHEQUEO DE SI ES SUSCRIPCION SOLO SEA EN ARGETINA
		        if(ordenDAO!=null && CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
		        	//si el pais no es argentina indico con un mensaje de error        	
		        	if(ordenDAO.getDomicilioEnvio()!=null && !ordenDAO.getDomicilioEnvio().getIdPais().equals(Globals.ARGENTINA.getId())||
		        			!ordenDAO.getDomicilioFacturacion().getIdPais().equals(Globals.ARGENTINA.getId())){
		        		request.getSession().setAttribute("errorEnDomicilioDeSuscripcion", "true");
		        		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		        		frwRedirect = "frwDomicilio";
		        	}else{
		        		//si esta Ok, elimino el msj.
		        		request.getSession().removeAttribute("errorEnDomicilioDeSuscripcion");
		        	}        	
		        }
			}*/
		}else if(ProcesoCompraUtil.VISTA_PREVIA.equals(nombreDePagina)) {	
			if(esSocioTMK.booleanValue()){
				request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
				frwRedirect = "frwRegistroSocioCadena";
			}
			if(ordenDAO.getArticulos().size() == 0) {
				frwRedirect = "frwMiCuenta";
			}
			if (ordenDAO.getMedioDeCobro() == null) {				
				frwRedirect = "frwDomicilio";
			}
		}
		if(frwRedirect == null) {
			//chequeo de si una orden tiene articulos de pasatiempos, para que no se pueda eñlegir una direccion de envio fuera de arg.		
			if(ordenDAO.getDomicilioEnvio()!=null && ProcesoCompraUtilImp.getInstance().tienePasatiempos(ordenDAO) &&		
				ordenDAO.getDomicilioEnvio().getTipoDomicilio().toLowerCase().indexOf("en") >=0) {
				if(!ordenDAO.getDomicilioEnvio().getIdPais().equals(
					Globals.ARGENTINA.getId())) {
						request.setAttribute("idSeccion", new Integer(Globals.SECCION_MICUENTA));
						if(!ProcesoCompraUtil.ENTREGA.equals(nombreDePagina)) {
							frwRedirect = "frwDomicilio";
						}
				}
			}
		}
		return frwRedirect;
	}
	
	public boolean esProcesoNueo(HttpServletRequest request) {
		//boolean esProcesoNuevo = (request.getSession().getAttribute("procesoDeCompraNuevo") != null);		
		//if(esProcesoNuevo){
		//	esProcesoNuevo = ((String)request.getSession().getAttribute("procesoDeCompraNuevo")).equals("true");
		//}
		boolean esProcesoNuevo = true;
		return esProcesoNuevo;
	}
}

