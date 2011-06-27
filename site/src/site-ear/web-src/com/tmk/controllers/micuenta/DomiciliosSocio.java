package com.tmk.controllers.micuenta;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.soa.servicios.interfaces.SocioDomiciliosService;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class DomiciliosSocio extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	SocioPK pk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
	//template
	Template tmpDomicilios = (Template)ServiceLocator.getTemplateService().getTemplate("tmpDomicilios");
	SocioDomiciliosService servicioSocio = ServiceLocator.getSocioDomiciliosService();
	//domicilio de envio
	boolean tieneAlgunDomicilio = false;
	Collection colDomicilio = servicioSocio.findByTipoEnvio(pk);
	if(colDomicilio != null) {
		setDomicilios(tmpDomicilios, colDomicilio.iterator(), servicioSocio, "Envio");			
	}else {
		//le paso un iterador vacio.(new TreeSet().iterator())
		setDomicilios(tmpDomicilios, new TreeSet().iterator(), servicioSocio, "TFacturacion");
	}
	tieneAlgunDomicilio = colDomicilio != null;
	//domcilio de facturacion
	colDomicilio = servicioSocio.findByTipoFacturacion(pk);
	if(colDomicilio != null) {
		setDomicilios(tmpDomicilios, colDomicilio.iterator(), servicioSocio, "TFacturacion");
	}else {
		setDomicilios(tmpDomicilios, new TreeSet().iterator(), servicioSocio, "TFacturacion");
	}
	tieneAlgunDomicilio = tieneAlgunDomicilio || colDomicilio!=null;
			
	tmpDomicilios.setParam("tieneAlgunDomicilio", tieneAlgunDomicilio ? "true" : "");
		
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
		
	}
	
	public static void setDomicilios (Template tmpDomicilios,Iterator<SocioDomicilios> itDomicilios,SocioDomiciliosService servicioSocio,String tipoDomicilio){
		Vector<Hashtable<String, Object>> vecDomicilios =  new Vector<Hashtable<String, Object>>();
		Hashtable<String, Object> hasDomicilios = null;
		//recorro los domicilios
		if(itDomicilios == null) {
			itDomicilios = new TreeSet<SocioDomicilios>().iterator();
		}
		int i = 1;		
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
			hasDomicilios.put("codigoPostal",Convert.nombrePropio(domicilio.getCp(),false));
			//datos para el radio.En la tempalte se usa para el value y para el id del radio el mismo valor
			hasDomicilios.put("id",domicilio.getTipo_domicilio());				
			String checked = "";
			String disabled = "";			
		
			hasDomicilios.put("chequeado",checked);
			hasDomicilios.put("disabled",disabled);
			vecDomicilios.add(hasDomicilios);
			i++;
		}
		tmpDomicilios.setParam("domicilios"+tipoDomicilio, vecDomicilios);
		tmpDomicilios.setParam("tieneDomicilios"+tipoDomicilio.substring(0,2), vecDomicilios.size() > 0 ? "true" : "");//las comillas vacias indica false.
	}
}
