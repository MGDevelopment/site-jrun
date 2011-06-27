package com.tmk.action.compra;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.soa.servicios.interfaces.SocioDomiciliosService;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class DomiciliosAction extends Action {

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String frwRedirect = ProcesoCompraUtilImp.getInstance().frwRedireccion(request, response, ProcesoCompraUtil.ENTREGA);
		if(frwRedirect != null ){
			return mapping.findForward(frwRedirect);
		}
		frwRedirect = "frwDomicilio";

		//obtengo el servicio de socio,y la pk de la sesion
		SocioPK pk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		OrdenDAO ordenDao = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		//template
		Template tmpDomicilios = (Template)ServiceLocator.getTemplateService().getTemplate("tmpDomicilios");
		
		SocioDomiciliosService servicioSocio = ServiceLocator.getSocioDomiciliosService();
		//domicilio de envio
		boolean tieneAlgunDomicilio = false;
		Collection colDomicilio = servicioSocio.findByTipoEnvio(pk);
		if(colDomicilio != null) {
			setDomicilios(tmpDomicilios, colDomicilio.iterator(), servicioSocio, ordenDao,"Envio");			
		}else {
			//le paso un iterador vacio.(new TreeSet().iterator())
			setDomicilios(tmpDomicilios, new TreeSet().iterator(), servicioSocio, ordenDao,"TFacturacion");
		}
		tieneAlgunDomicilio = colDomicilio != null;
		//domcilio de facturacion
		colDomicilio = servicioSocio.findByTipoFacturacion(pk);
		if(colDomicilio != null) {
			setDomicilios(tmpDomicilios, colDomicilio.iterator(), servicioSocio, ordenDao,"TFacturacion");
		}else {
			setDomicilios(tmpDomicilios, new TreeSet().iterator(), servicioSocio, ordenDao,"TFacturacion");
		}
		tieneAlgunDomicilio = tieneAlgunDomicilio || colDomicilio!=null;
		tmpDomicilios.setParam("display", ordenDao.getDomicilioFacturacion()!=null ? "inline" : "none");
				
		tmpDomicilios.setParam("tieneAlgunDomicilio", tieneAlgunDomicilio ? "true" : "");
		
		//chequeo de DIRECCIONES, ¿SON LAS MISMAS?.PARA MOSTRAR EN LOS RADIOS-BUTTON LA OPCION
		//"El domicilio de facturación coincide con el de entrega"
		if(ordenDao.getDomicilioEnvio() != null && ordenDao.getDomicilioFacturacion() != null) {
			if(ordenDao.getDomicilioEnvio().equals2(ordenDao.getDomicilioFacturacion())) {
				tmpDomicilios.setParam("dirIguales", "checked");
				tmpDomicilios.setParam("display", "none");
			}else {
				tmpDomicilios.setParam("dirDistintas", "checked");	
			}
		}else {
			if(ordenDao.getDomicilioEnvio() == null && ordenDao.getDomicilioEnvio() == null) {
				tmpDomicilios.setParam("dirIguales", "checked");
			}else {
				//si no tiene domicilio de facturacion
				if(ordenDao.getDomicilioFacturacion() == null) {
					tmpDomicilios.setParam("dirIguales", "checked");	
				}
			}
		}
		//fin chequeo de radios
		
		//DATOS DE LOS NOMBRES APELLIDOS, si no especifica nadie por defecto aparece el nombre de quiene esta logueado
		if(ordenDao.getNombresReceptor() == null && ordenDao.getApellidosReceptor() == null) {
			String[] socio = (String[])((String)request.getSession().getAttribute("Registracion.nombreCompleto")).split(" ");
			tmpDomicilios.setParam("nombreReceptor", socio[0]);
			tmpDomicilios.setParam("apellidoReceptor", socio[1]);			
		}
		if(ordenDao.getNombresReceptor()!=null){
			tmpDomicilios.setParam("nombreReceptor", ordenDao.getNombresReceptor());
		}
		if(ordenDao.getApellidosReceptor()!=null){
			tmpDomicilios.setParam("apellidoReceptor", ordenDao.getApellidosReceptor());
		}
		//FIN
		
		//comentario o aclaracones 
		String comentario  = ordenDao.getComentario(); 
		if(comentario != null){
			tmpDomicilios.setParam("comentario", comentario);
		}
		//fin--
		//seteo de datos para el la ventana modal cuando se va a agregar un nuevo domicilio
		tmpDomicilios.setParam("paisDefaultId", Globals.ARGENTINA.getId());
		tmpDomicilios.setParam("provinciaDefaultId","-1");	
		tmpDomicilios.setParam("localidadDefaultId", "-1");
		//fin		
		//obtengo las pantallas anterior y siguiente en base a la que estoy parado
		Map<String, String> direcciones = null;
		direcciones = ProcesoCompraUtilImp.getInstance().getDirecciones(ProcesoCompraUtil.ENTREGA);	
		tmpDomicilios.setParam("pantallaAnterior", direcciones.get("anterior"));
		tmpDomicilios.setParam("pantallaSiguiente", direcciones.get("siguiente"));

		request.setAttribute("template",tmpDomicilios.output());
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		//return mapping.findForward(frwRedirect);
		return mapping.findForward("frwDomicilio");
	}
	
	/***
	 * Obtiene un Iterador de domicilio, y seteo la template con los datos.
	 * @param tmpDomicilios
	 * @param itDomicilios
	 * @param servicioSocio
	 * @param ordenDao
	 * @param tipoDomicilio (envio, facturacion)
	 */
	public static void setDomicilios (Template tmpDomicilios,Iterator<SocioDomicilios> itDomicilios,SocioDomiciliosService servicioSocio,OrdenDAO ordenDao,String tipoDomicilio){
		Vector<Hashtable<String, Object>> vecDomicilios =  new Vector<Hashtable<String, Object>>();
		Hashtable<String, Object> hasDomicilios = null;
		//recorro los domicilios
		if(itDomicilios == null) {
			itDomicilios = new TreeSet<SocioDomicilios>().iterator();
		}
		int i = 1;
		int dirCheck = 1;
		boolean tienePasatiempos = ProcesoCompraUtilImp.getInstance().tienePasatiempos(ordenDao);
		while(itDomicilios.hasNext()) {
			SocioDomicilios domicilio = itDomicilios.next();
			hasDomicilios = new  Hashtable<String, Object>();				
			hasDomicilios.put("pais",Convert.nombrePropio(domicilio.getPais().getDescripcion(),false));
			if(domicilio.getProvincia()!=null) {
				hasDomicilios.put("provincia",Convert.nombrePropio(domicilio.getProvincia().getDescripcion(),false));
			}else{
				hasDomicilios.put("provincia","");
			}
			if(domicilio.getLocalidad()!=null){
				hasDomicilios.put("localidad",Convert.nombrePropio(domicilio.getLocalidad().getDescripcion(),false));
			}else{
				hasDomicilios.put("localidad","");				
			}
			hasDomicilios.put("direccion",Convert.nombrePropio(servicioSocio.getDireccionFormateada(domicilio),false));
			hasDomicilios.put("codigoPostal","CP "+Convert.nombrePropio(domicilio.getCp(),false));
			//datos para el radio.En la tempalte se usa para el value y para el id del radio el mismo valor
			hasDomicilios.put("id",domicilio.getTipo_domicilio());				
			String checked = "";
			String disabled = "";
			//si tiene pasatiempos fuera del grupo gs del tiempo y es direccion de envio, tengo que deshabilitar las direcciones fuera de argentina.			
			if(tienePasatiempos && tipoDomicilio.toLowerCase().indexOf("en") >=0) {
				if(!domicilio.getPais().getIdPais().equals(Globals.ARGENTINA.getId()) && (tipoDomicilio.indexOf(tipoDomicilio.substring(0,2)) >=0)){
					disabled = "disabled";//se deshabilita
					checked = "";//indica que no se chequea
					dirCheck++;
				}
			}
			//ENVIO
			if(tipoDomicilio.toLowerCase().indexOf("en") >= 0){
				//si la orden tiene domicilio de envio y es la misma que la que estoy evaluando
				if(ordenDao.getDomicilioEnvio()!=null ){
					if(sonIguales(domicilio, ordenDao.getDomicilioEnvio())){				
						checked = "checked";
					}
				}else {						
					checked = checked.equals("")  && !tienePasatiempos ? "checked" : "";					
				}
			//FACTURACION
			}else{
				//si la orden tiene Facturacion de envio y esta chequeada
				if(ordenDao.getDomicilioFacturacion() != null && ordenDao.getDomicilioFacturacion().getTipoDomicilio().toLowerCase().startsWith(tipoDomicilio.substring(0,2).toLowerCase()) ){
					if(sonIguales(domicilio, ordenDao.getDomicilioFacturacion())){				
						checked = "checked";
					}
				}else{
					checked = checked.equals("") ? "checked" : "";
				}
			}
			//si no tiene indicada ninguna dejo el check por defecto.
			if (ordenDao.getDomicilioEnvio()==null && ordenDao.getDomicilioFacturacion()==null && dirCheck == i && !tienePasatiempos) {
				checked = "checked";
			}			
			hasDomicilios.put("chequeado",checked);
			hasDomicilios.put("disabled",disabled);
			vecDomicilios.add(hasDomicilios);
			i++;
		}
		tmpDomicilios.setParam("mostratMensajeDomicilioFueraArgentina",tienePasatiempos ? "true" : "");
		tmpDomicilios.setParam("domicilios"+tipoDomicilio, vecDomicilios);
		tmpDomicilios.setParam("tieneDomicilios"+tipoDomicilio.substring(0,2), vecDomicilios.size() > 0 ? "true" : "");//las comillas vacias indica false.
	}

	/**
	 * Determina si la direccion que tiene la orden DireccionDAo es la misma que la que estoy evaluanco Direccion(DBO)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean sonIguales(SocioDomicilios s1,DomicilioDAO s2){
		if(s2==null)return false;
		boolean iguales = true;
		try{						
			if(s2.getPais()!=null){
				//iguales = s1.getPais().getIdPais().equals( s2.getIdPais());
				iguales = s2.getIdPais().equals(s1.getPais().getIdPais());
			}else{
				iguales = (null == s1.getPais().getIdPais());
			}
			if(!iguales) return iguales;
			if(s2.getProvincia()!=null){
				//iguales = s1.getProvincia().getId_provincia().equals( s2.getIdProvincia()); 
				iguales = s2.getIdProvincia().equals(s1.getProvincia().getId_provincia());
			}else{
				iguales = (null == s1.getProvincia().getId_provincia());
			}
			if(!iguales) return iguales;
			if(s2.getLocalidad()!=null){
				//iguales = s1.getLocalidad().getId_localidad().equals( s2.getIdLocalidad());
				iguales = s2.getIdLocalidad().equals(s1.getLocalidad().getId_localidad() );
			}else{
				iguales = (null == s1.getLocalidad().getId_localidad());
			}
			if(!iguales) return iguales;
			if(s2.getCalle()!=null){
				//iguales = s1.getCalle().equals( s2.getCalle()); 
				iguales = s2.getCalle().equals(s1.getCalle());
			}else{
				iguales = (null == s1.getCalle());
			}
			if(!iguales) return iguales;
			if(s2.getCodigoPostal()!=null){
				//iguales = s1.getCp().equals( s2.getCodigoPostal()); 
				iguales = s2.getCodigoPostal().equals(s1.getCp());
			}else{
				iguales = (null == s1.getCp());
			} 
			if(!iguales) return iguales;
			if(s2.getNumero()!=null){
				//iguales = s1.getNumero().equals( s2.getNumero()); 
				iguales = s2.getNumero().equals(s1.getNumero());
			}else{
				iguales = (null == s1.getNumero());
			}
		}catch(Exception e){
			iguales = false;
			System.out.println(e);
		}
		return iguales;
	}
	
}
