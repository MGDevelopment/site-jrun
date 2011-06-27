<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tmk.soa.servicios.interfaces.SocioDomiciliosService"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%	
	SocioPK pk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
	Template tmpDomicilios = (Template)ServiceLocator.getTemplateService().getTemplate("tmpDomiciliosMiCuenta");
	
	//Socio2Service servicioSocio = ServiceLocator.getSocioService();
	SocioDomiciliosService servicioSocio = ServiceLocator.getSocioDomiciliosService();
	Collection colDomicilio = servicioSocio.findByTipoEnvio(pk);
	if(colDomicilio != null) {
		//setDomicilios(tmpDomicilios, colDomicilio.iterator(), servicioSocio, "Envio");
		Iterator itDomicilios = colDomicilio.iterator();
		Vector<Hashtable<String, Object>> vecDomicilios =  new Vector<Hashtable<String, Object>>();
		Hashtable<String, Object> hasDomicilios = null;
		//recorro los domicilios
		if(itDomicilios == null) {
			itDomicilios = new TreeSet<SocioDomicilios>().iterator();
		}
		//int i = 1;		
		while(itDomicilios.hasNext()) {
			SocioDomicilios domicilio = (SocioDomicilios)itDomicilios.next();
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
			hasDomicilios.put("idDomicilio",domicilio.getTipo_domicilio());
			
			//se podira pasar el metodo que tiene dbUtil al SocioDomicilioService, asi dejar de usar DBUtil para acceder a ese metodo.
			//no hago ningun chequeo con el metodo el metodo, devuelve un Integer, pero como el <tmpl_if ...> pone interpreta true si hay distinto de vacio dejo el valor de retorno.
			Integer idOrden = DBUtil.ordenesEnProcesoPorDireccion(pk.ID_SOCIO,pk.ID_SUCURSAL,domicilio.getTipo_domicilio());
			if(idOrden != null){
				hasDomicilios.put("tieneOrdenEnProgreso", "true");	
			}
			
			//datos para el radio.En la tempalte se usa para el value y para el id del radio el mismo valor						
			vecDomicilios.add(hasDomicilios);

		}
		tmpDomicilios.setParam("domiciliosEnvio", vecDomicilios);		
	}

	//seteo de datos para el la ventana modal cuando se va a agregar un nuevo domicilio
	tmpDomicilios.setParam("paisDefaultId", Globals.ARGENTINA.getId());
	tmpDomicilios.setParam("provinciaDefaultId","-1");	
	tmpDomicilios.setParam("localidadDefaultId", "-1");
	
	response.getWriter().print(tmpDomicilios.output());
	request.setAttribute("template",tmpDomicilios.output());
	
%>